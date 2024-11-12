package estoque;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	public static String status = "Não conectou...";
	
	public ConexaoMySQL() {  }
	
	public static java.sql.Connection getConexaoMySQL() {
    Connection connection = null;
    return connection;
	}
	
	String driverName = "com.mysql.cj.jdbc.Driver";
	
  	try {
  		Class.forName(driverName);
  	} catch (ClassNotFoundException e) {
  		e.printStackTrace();
  	}

  	String serverName = "localhost"; // Endereço do servidor do BD
  	String mydatabase = "EstoqueDB";   	// Nome do seu banco de dados
  	String url = "jdbc:mysql://" + serverName + "/" + mydatabase; // String de Conexão.
  	String username = "root"; // Nome de um usuário de seu BD 
  	String password = "";   	// A senha de acesso do usuário quando tiver em uso. 
  	
  	try {
  		connection = DriverManager.getConnection(url, username, password);
  		//connection = DriverManager.getConnection("jdbc:mysql://localhost/mapeamento", "root", "");
  		status = " Conectado";
  		System.out.println("Banco " + mydatabase + status);
  	} catch (SQLException e) {
  		System.out.println(status);
  		e.printStackTrace();
  	}
  	
    return connection;
}
