package pac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    public static String status = "Não conectou...";

    public ConexaoMySQL() { }

    public static Connection getConexaoMySQL() {
        Connection connection = null;
        String driverName = "com.mysql.cj.jdbc.Driver";
        String serverName = "localhost"; // Endereço do servidor
        String mydatabase = "EstoqueDB"; // Nome banco de dados
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase; // String de Conexão
        String username = "root"; // Nome de um usuário
        String password = ""; // A senha de acesso

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
            status = "Conectado";
            System.out.println("Banco " + mydatabase + " " + status);
        } catch (ClassNotFoundException e) {
            System.out.println("O driver especificado não foi encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(status);
            e.printStackTrace();
        }

        return connection;
    }
}
