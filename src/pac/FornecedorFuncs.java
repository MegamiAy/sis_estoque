package pac;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorFuncs {
    private Connection connect = null;

    public void connectionDB() {
        connect = ConexaoMySQL.getConexaoMySQL();
    }

    public List<Fornecedor> listFornecedores() {
        connectionDB();
        String sql = "SELECT id, nome, fone, email, endereco FROM fornecedor";
        List<Fornecedor> fornecedores = new ArrayList<>();

        try (PreparedStatement pst = connect.prepareStatement(sql);
             ResultSet rst = pst.executeQuery()) {

            while (rst.next()) {
                Fornecedor fornecedor = new Fornecedor(
                    rst.getInt("id"),
                    rst.getString("nome"),
                    rst.getString("fone"),
                    rst.getString("email"),
                    rst.getString("endereco")
                );
                fornecedores.add(fornecedor);
            }
        } catch (SQLException se) {
            System.out.println("Erro ao consultar fornecedores: " + se.getMessage());
        }
        return fornecedores;
    }
}
