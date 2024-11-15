package pac;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueFuncs {
    private Connection connect = null;
    
    public void connectionDB() {
        connect = ConexaoMySQL.getConexaoMySQL();
    }
    
    public List<Estoque> listEstoques() {
        connectionDB();
        String sql = "SELECT e.id, e.id_prod, e.quantidade, p.nome, p.descricao, p.preco, p.id_cat, p.id_forn " +
                     "FROM estoque e " +
                     "JOIN produto p ON e.id_prod = p.id"; // Join serve para -> pegar as informações do produto associado ao estoque

        List<Estoque> estoques = new ArrayList<>();

        try (PreparedStatement pst = connect.prepareStatement(sql);
             ResultSet rst = pst.executeQuery()) {

            while (rst.next()) {
                Produto produto = new Produto(
                    rst.getInt("id_prod"),
                    rst.getString("nome"), 
                    rst.getString("descricao"),
                    rst.getDouble("preco"),
                    new Categoria(rst.getInt("id_cat"), "", ""),
                    new Fornecedor(rst.getInt("id_forn"), "", "", "", "")
                );

                Estoque estoque = new Estoque(
                    rst.getInt("id"),
                    produto,                  
                    rst.getInt("quantidade")
                );
                
                estoques.add(estoque);
            }
        } catch (SQLException se) {
            System.out.println("Erro ao consultar estoque: " + se.getMessage());
        }
        return estoques;
    }

    // adicionar e deletar só vai alterar a quantidade.
    public void editEstoque() {
        connectionDB();
        listEstoque(); // Lista os produtos com suas quantidades
        System.out.println("\nEditar Estoque:");
        System.out.print("Informe o ID do Produto para ajustar o estoque: ");
        String idInput = scanner.nextLine();
    
        if (!helper.mascara(idInput, "numeric")) {
            System.out.println("ID inválido. Operação cancelada.");
            return;
        }
        int id = Integer.parseInt(idInput);
    
        String fetchSql = "SELECT quantidade FROM estoque WHERE id_prod = ?";
        String updateSql = "UPDATE estoque SET quantidade = ? WHERE id-prod = ?";
    
        try (PreparedStatement fetchStmt = connect.prepareStatement(fetchSql)) {
            fetchStmt.setInt(1, id);
    
            try (ResultSet rs = fetchStmt.executeQuery()) {
                if (rs.next()) {
                    int qtAtual = rs.getInt("quantidade");
    
                    System.out.print("Ajuste no Estoque (atual: " + qtAtual + ", use valores positivos para adicionar ou negativos para remover): ");
                    String ajusteInput = scanner.nextLine();
    
                    if (!helper.mascara(ajusteInput, "numeric")) {
                        System.out.println("Ajuste inválido. Operação cancelada.");
                        return;
                    }
    
                    int ajuste = Integer.parseInt(ajusteInput);
                    int novaQtd = qtAtual + ajuste;
    
                    if (novaQtd < 0) {
                        System.out.println("Ajuste resultaria em estoque negativo. Operação cancelada.");
                        return;
                    }
    
                    // Atualizar a quantidade
                    try (PreparedStatement updateStmt = connect.prepareStatement(updateSql)) {
                        updateStmt.setInt(1, novaQtd);
                        updateStmt.setInt(2, id);
    
                        int rowsAffected = updateStmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Estoque atualizado com sucesso. Nova quantidade: " + novaQtd);
                        } else {
                            System.out.println("Erro ao atualizar estoque.");
                        }
                    }
                } else {
                    System.out.println("Produto com ID " + id + " não encontrado.");
                }
            }
        } catch (SQLException | NumberFormatException ex) {
            System.out.println("Erro ao atualizar estoque: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            helper.closeConnection();
        }
    }
    
}
