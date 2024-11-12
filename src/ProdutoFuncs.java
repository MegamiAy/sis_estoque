import java.sql.*;

public class ProdutoFuncs implements ProdutoInt {
    private Connection connect = null;

    public void connectionDB() {
        connect = ConexaoMySQL.getConexaoMySQL();
    }

    public void addProd(Produto produto) {
        connectionDB();
        String sql = "INSERT INTO produto (id, nome, descricao, preco, id_cat, id_forn) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            pst.setInt(1, produto.getId());
            pst.setString(2, produto.getNome());
            pst.setString(3, produto.getDesc());
            pst.setDouble(4, produto.getPreco());
            pst.setInt(5, produto.getCategoria().getId());
            pst.setInt(6, produto.getFornecedor().getId());

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Produto cadastrado com sucesso.");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar produto: " + ex.getMessage());
        }
    }

    public List<Produto> listProd() {
        connectionDB();
        String sql = "SELECT id, nome, descricao, preco, id_cat, id_forn FROM produto";
        List<Produto> produtos = new ArrayList<>();
        try (PreparedStatement pst = connect.prepareStatement(sql);
             ResultSet rst = pst.executeQuery()) {

            while (rst.next()) {
                Produto produto = new Produto(
                    rst.getInt("id"),
                    rst.getString("nome"),
                    rst.getString("descricao"),
                    rst.getDouble("preco"),
                    new Categoria(rst.getInt("id_cat"), "", ""), 
                    new Fornecedor(rst.getInt("id_forn"), "", "", "", "")
                );
                produtos.add(produto);
            }
        } catch (SQLException se) {
            System.out.println("Erro ao consultar produtos: " + se.getMessage());
        }
        return produtos; 
    }
    
    public void editProd(int id, String nome, String desc, double preco, int categoria, int fornecedor) {
        connectionDB();
        String sql = "UPDATE produto SET nome = ?, descricao = ?, preco = ?, id_cat = ?, id_forn = ? WHERE id = ?";
        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            pst.setString(1, nome);
            pst.setString(2, desc);
            pst.setDouble(3, preco);
            pst.setInt(4, categoria);
            pst.setInt(5, fornecedor);
            pst.setInt(6, id);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Produto atualizado com sucesso.");
            } else {
                System.out.println("Produto não encontrado para atualização.");
            }
        } catch (SQLException se) {
            System.out.println("Erro ao atualizar produto: " + se.getMessage());
        }
    }

    public void delProd(int id) {
        connectionDB();
        String sql = "DELETE FROM produto WHERE id = ?";
        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.printf("Produto com ID %d excluído com sucesso.%n", id);
            } else {
                System.out.println("Produto não encontrado para exclusão.");
            }
        } catch (SQLException se) {
            System.out.println("Erro ao excluir produto: " + se.getMessage());
        }
    }

    public void checkEstoqueMin(int idProduto, int qtMin) {
        connectionDB();
        String sql = "SELECT quantidade FROM estoque WHERE id_prod = ?";
        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            pst.setInt(1, idProduto);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                int qtAtual = rst.getInt("quantidade");
                if (qtAtual <= qtMin) {
                    System.out.printf("Atenção: Produto ID %d está com estoque baixo (%d unidades).%n", idProduto, qtAtual);
                }
            }
        } catch (SQLException se) {
            System.out.println("Erro ao verificar estoque: " + se.getMessage());
        }
    }
}
