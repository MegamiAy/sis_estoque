package pac;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaFuncs {
	private Connection connect = null;
	Helper helper = new Helper();

    public void connectionDB() {
        connect = ConexaoMySQL.getConexaoMySQL();
    }

    public List<Categoria> listCategorias() {
        System.out.println("Categorias Cadastradas:");
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
            
            for (Categoria categoria : categorias) {
                System.out.println(categoria);
            }
            
        } catch (SQLException se) {
            System.out.println("Erro ao consultar categorias: " + se.getMessage());
            se.printStackTrace();
        }
        return categorias;
    }
    
    public Categoria buscarId(int idCat) {
        Categoria categoria = null;
        connectionDB();
        String sql = "SELECT * FROM categoria WHERE id = ?";
        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            pst.setInt(1, idCat);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    categoria = new Categoria(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao")
                    );
                } else {
                    System.out.println("Categoria não encontrada para o ID: " + idCat);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar categoria: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            helper.closeConnection(); // Fecha a conexão após o uso
        }
        return categoria;
    }
}
