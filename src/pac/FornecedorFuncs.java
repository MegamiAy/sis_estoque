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
        System.out.println("Fornecedores Cadastrados:");
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
            
            for (Fornecedor fornecedor : fornecedores) {
                System.out.println(fornecedor);
            }
            
        } catch (SQLException se) {
            System.out.println("Erro ao consultar fornecedores: " + se.getMessage());
        }
        return fornecedores;
    }
    
    public Fornecedor buscarId(int idForn) {
        Fornecedor fornecedor = null;
        String sql = "SELECT * FROM fornecedor WHERE id = ?";
        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            pst.setInt(1, idForn);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    fornecedor = new Fornecedor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("fone"),
                        rs.getString("email"),
                        rs.getString("endereco"),
                    );
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar fornecedor: " + ex.getMessage());
        }
        return fornecedor;
    }
}
