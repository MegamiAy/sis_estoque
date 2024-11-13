package pac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaFuncs {
	private Connection connect = null;

    public void connectionDB() {
        connect = ConexaoMySQL.getConexaoMySQL();
    }

    public List<Categoria> listCategorias() {
        connectionDB();
        String sql = "SELECT id, nome, descricao FROM categoria";
        List<Categoria> categorias = new ArrayList<>();
        try (PreparedStatement pst = connect.prepareStatement(sql);
             ResultSet rst = pst.executeQuery()) {
    
            while (rst.next()) {
                Categoria categoria = new Categoria(
                    rst.getInt("id"),
                    rst.getString("nome"),
                    rst.getString("descricao")
                );
                categorias.add(categoria);
            }
        } catch (SQLException se) {
            System.out.println("Erro ao consultar categorias: " + se.getMessage());
            se.printStackTrace();
        }
        return categorias;
    }
}
