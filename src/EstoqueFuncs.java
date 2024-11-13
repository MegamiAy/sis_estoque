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
        String sql = "SELECT id, id_prod, quantidade FROM estoque";
        List<Estoque> estoques = new ArrayList<>();

        try (PreparedStatement pst = connect.prepareStatement(sql);
             ResultSet rst = pst.executeQuery()) {

            while (rst.next()) {
                int idProduto = rst.getInt("id_prod");
                ProdutoFuncs produtoFuncs = new ProdutoFuncs();
                Produto produto = produtoFuncs.getProdutoById(idProduto); // criar
                
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
}
