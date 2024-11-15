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

    public void addEstoque(Produto produto, quantidade){
        
    }

    public void delEstoque(Produto produto, quantidade){
        
    }
    
}
