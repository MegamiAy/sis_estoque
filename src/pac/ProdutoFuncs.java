package pac;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdutoFuncs {
    private Connection connect = null;
    Scanner scanner = new Scanner(System.in);
    CategoriaFuncs categoriaFuncs = new CategoriaFuncs();
    FornecedorFuncs fornecedorFuncs = new FornecedorFuncs();
    Helper helper = new Helper();

    public void connectionDB() {
        connect = ConexaoMySQL.getConexaoMySQL();
    }

    public void addProd() {
        System.out.println("Adicionar Produto:");
        int idAdd = 0;

        System.out.print("Informe o Nome do Produto: ");
        String nomeAdd = scanner.nextLine();

        System.out.print("Informe a Descrição do Produto: ");
        String descAdd = scanner.nextLine();

        System.out.print("Informe o Preço do Produto: ");
        String precoAddInput = scanner.nextLine();
        if (!helper.mascara(precoAddInput, "numeric")) {
            System.out.println("Preço inválido. Operação cancelada.");
            return;
        }
        if (!helper.mascara(precoAddInput, "money")) {
            System.out.println("Formato de preço inválido. Operação cancelada.");
            return;
        }
        double precoAdd = Double.parseDouble(precoAddInput);

        System.out.print("Informe o ID da Categoria: ");
        String idCatAddInput = scanner.nextLine();
        if (!helper.mascara(idCatAddInput, "numeric")) {
            System.out.println("ID de categoria inválido. Operação cancelada.");
            return;
        }
        int idCatAdd = Integer.parseInt(idCatAddInput);

        System.out.print("Informe o ID do Fornecedor: ");
        String idFornAddInput = scanner.nextLine();
        if (!helper.mascara(idFornAddInput, "numeric")) {
            System.out.println("ID de fornecedor inválido. Operação cancelada.");
            return;
        }
        int idFornAdd = Integer.parseInt(idFornAddInput);

        connectionDB();
        if (connect == null) {
            System.out.println("Erro de conexão com o banco de dados.");
            return;
        }

        // Buscar Categoria e Fornecedor
        Categoria categoriaAdd = categoriaFuncs.buscarId(idCatAdd);
        if (categoriaAdd == null) {
            System.out.println("Categoria não encontrada. Operação cancelada.");
            return;
        }

        Fornecedor fornecedorAdd = fornecedorFuncs.buscarId(idFornAdd);
        if (fornecedorAdd == null) {
            System.out.println("Fornecedor não encontrado. Operação cancelada.");
            return;
        }

        // Verificar se todos os dados foram preenchidos corretamente
        if (nomeAdd != null && descAdd != null && precoAdd > 0) {
            Produto novoProduto = new Produto(idAdd, nomeAdd, descAdd, precoAdd, categoriaAdd, fornecedorAdd);
            String sql = "INSERT INTO produto (id, nome, descricao, preco, id_cat, id_forn) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = connect.prepareStatement(sql)) {
                pst.setInt(1, novoProduto.getId());
                pst.setString(2, novoProduto.getNome());
                pst.setString(3, novoProduto.getDesc());
                pst.setDouble(4, novoProduto.getPreco());
                pst.setInt(5, novoProduto.getCategoria().getIdC());
                pst.setInt(6, novoProduto.getFornecedor().getIdF());

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Produto cadastrado com sucesso.");
                } else {
                    System.out.println("Falha ao cadastrar produto.");
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao cadastrar produto: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                try {
                    if (connect != null && !connect.isClosed()) {
                        connect.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Os dados não foram preenchidos corretamente.");
        }
    }

    public void editProd() {
        connectionDB();
        listProd();
        System.out.println("\nEditar Produto:");
        System.out.print("Informe o ID do Produto para editar: ");
        String idInput = scanner.nextLine();
        if (!helper.mascara(idInput, "numeric")) {
            System.out.println("ID inválido. Operação cancelada.");
            return;
        }
        int id = Integer.parseInt(idInput);

        String fetchSql = "SELECT * FROM produto WHERE id = ?";
        String updateSql = "UPDATE produto SET nome = ?, descricao = ?, preco = ?, id_cat = ?, id_forn = ? WHERE id = ?";

        try (PreparedStatement fetchStmt = connect.prepareStatement(fetchSql)) {
            fetchStmt.setInt(1, id);

            try (ResultSet rs = fetchStmt.executeQuery()) {
                if (rs.next()) {
                    String nomeAtual = rs.getString("nome");
                    String descAtual = rs.getString("descricao");
                    double precoAtual = rs.getDouble("preco");
                    int idCatAtual = rs.getInt("id_cat");
                    int idFornAtual = rs.getInt("id_forn");

                    System.out.print("Novo Nome do Produto (atual: " + nomeAtual + "): ");
                    String nome = scanner.nextLine();
                    nome = nome.isEmpty() ? nomeAtual : nome;

                    System.out.print("Nova Descrição do Produto (atual: " + descAtual + "): ");
                    String desc = scanner.nextLine();
                    desc = desc.isEmpty() ? descAtual : desc;

                    System.out.print("Novo Preço do Produto (atual: " + precoAtual + "): ");
                    String precoInput = scanner.nextLine();
                    double preco = helper.mascara(precoInput, "numeric") ? Double.parseDouble(precoInput) : precoAtual;

                    System.out.print("Novo ID da Categoria (atual: " + idCatAtual + "): ");
                    String idCatInput = scanner.nextLine();
                    int idCat = helper.mascara(idCatInput, "numeric") ? Integer.parseInt(idCatInput) : idCatAtual;

                    System.out.print("Novo ID do Fornecedor (atual: " + idFornAtual + "): ");
                    String idFornInput = scanner.nextLine();
                    int idForn = helper.mascara(idFornInput, "numeric") ? Integer.parseInt(idFornInput) : idFornAtual;

                    // Verificar se a categoria e fornecedor existem
                    Categoria categoria = categoriaFuncs.buscarId(idCat);
                    Fornecedor fornecedor = fornecedorFuncs.buscarId(idForn);

                    if (categoria == null) {
                        System.out.println("Categoria com ID " + idCat + " não encontrada. Operação cancelada.");
                        return;
                    }
                    if (fornecedor == null) {
                        System.out.println("Fornecedor com ID " + idForn + " não encontrado. Operação cancelada.");
                        return;
                    }

                    // Atualizar o produto
                    try (PreparedStatement updateStmt = connect.prepareStatement(updateSql)) {
                        updateStmt.setString(1, nome);
                        updateStmt.setString(2, desc);
                        updateStmt.setDouble(3, preco);
                        updateStmt.setInt(4, idCat);
                        updateStmt.setInt(5, idForn);
                        updateStmt.setInt(6, id);

                        int rowsAffected = updateStmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Produto atualizado com sucesso.");
                        } else {
                            System.out.println("Erro ao atualizar produto.");
                        }
                    }
                } else {
                    System.out.println("Produto com ID " + id + " não encontrado.");
                }
            }
        } catch (SQLException | NumberFormatException ex) {
            System.out.println("Erro ao atualizar produto: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            helper.closeConnection();
        }
    }

    public List<Produto> listProd() {
        connectionDB();
        String sql = "SELECT id, nome, descricao, preco, id_cat, id_forn FROM produto";
        // Criação de uma coleção (objetos produto) com o ArrayList
        List<Produto> produtos = new ArrayList<>();
        try (PreparedStatement pst = connect.prepareStatement(sql);
             ResultSet rst = pst.executeQuery()) {

            while (rst.next()) {
                Produto produto = new Produto(
                    rst.getInt("id"),
                    rst.getString("nome"),
                    rst.getString("descricao"),
                    rst.getDouble("preco"),
                    categoriaFuncs.buscarId(rst.getInt("id_cat")),
                    fornecedorFuncs.buscarId(rst.getInt("id_forn"))
                );
                produtos.add(produto);
            }

            if (produtos.isEmpty()) {
                System.out.println("Nenhum produto encontrado.");
            } else {
                System.out.println("Lista de Produtos:");
                // Iterator com ArrayList
                for (Produto produto : produtos) {
                    System.out.printf(
                            "ID: %d, Nome: %s, Descrição: %s, Preço: %.2f, Categoria: %s, Fornecedor: %s%n",
                            produto.getId(), produto.getNome(), produto.getDesc(), produto.getPreco(),
                            produto.getCategoria() != null ? produto.getCategoria().getIdC() : "N/A",
                            produto.getFornecedor() != null ? produto.getFornecedor().getIdF() : "N/A");
                }
            }
        } catch (SQLException se) {
            System.out.println("Erro ao consultar produtos: " + se.getMessage());
            se.printStackTrace();
        } finally {
            helper.closeConnection();
        }
        return produtos;
    }

    public void delProd() {
    	listProd();
        System.out.print("\nInforme o ID do Produto para remover: ");
        String idRemoverInput = scanner.nextLine();
        if (!helper.mascara(idRemoverInput, "numeric")) {
            System.out.println("ID inválido. Operação cancelada.");
            return;
        }
        int idRemover = Integer.parseInt(idRemoverInput);

        connectionDB();

        String deleteEstoque = "DELETE FROM estoque WHERE id_prod = ?";
        String deleteProduto = "DELETE FROM produto WHERE id = ?";

        try (PreparedStatement pstEstoque = connect.prepareStatement(deleteEstoque);
             PreparedStatement pstProduto = connect.prepareStatement(deleteProduto)) {

            // Remove as referências na tabela 'estoque'
            pstEstoque.setInt(1, idRemover);
            pstEstoque.executeUpdate();

            // Agora, remove o produto
            pstProduto.setInt(1, idRemover);
            int rowsAffected = pstProduto.executeUpdate();

            if (rowsAffected > 0) {
                System.out.printf("Produto com ID %d excluído com sucesso.%n", idRemover);
            } else {
                System.out.println("Produto com ID " + idRemover + " não encontrado para exclusão.");
            }
        } catch (SQLException se) {
            System.out.println("Erro ao excluir produto: " + se.getMessage());
            se.printStackTrace();
        } finally {
            helper.closeConnection();
        }
    }

    public boolean checkEstoqueMin() {
    	listProd();
    	System.out.print("\nInforme o ID do produto: ");
        String idCheckInput = scanner.nextLine();
        if (!helper.mascara(idCheckInput, "numeric")) { return false; }
        int idCheck = Integer.parseInt(idCheckInput);
        
        int qtMinima = 20;
        
        connectionDB();
        String sql = "SELECT quantidade FROM estoque WHERE id_prod = ?";
        boolean estoqueBaixo = false;
        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            pst.setInt(1, idCheck);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                int qtAtual = rst.getInt("quantidade");
                if (qtAtual <= qtMinima) {
                    System.out.printf("Atenção: Produto ID %d está com estoque baixo (%d unidades).%n", idCheck, qtAtual);
                    estoqueBaixo = true;
                } else {
                	System.out.printf("Produto ID %d está com estoque de (%d unidades).%n", idCheck, qtAtual);
                	estoqueBaixo = false;
                }
            } else {
            	System.out.println("Não existe produto com este ID.");
            }
        } catch (SQLException se) {
            System.out.println("Erro ao verificar estoque: " + se.getMessage());
            se.printStackTrace();
        }
        return estoqueBaixo;
    }

    public Produto getProdutoById(int id) {
        connectionDB();
        String sql = "SELECT id, nome, descricao, preco, id_cat, id_forn FROM produto WHERE id = ?";
        Produto produto = null;
        
            try (PreparedStatement pst = connect.prepareStatement(sql)) {
                pst.setInt(1, id);
                ResultSet rst = pst.executeQuery();
            
                if (rst.next()) {
                    produto = new Produto(
                        rst.getInt("id"),
                        rst.getString("nome"),
                        rst.getString("descricao"),
                        rst.getDouble("preco"),
                        new Categoria(rst.getInt("id_cat"), "", ""),
                        new Fornecedor(rst.getInt("id_forn"), "", "", "", "")
                    );
                }
            } catch (SQLException se) {
                System.out.println("Erro ao buscar produto: " + se.getMessage());
            }
        return produto;
    }
}
