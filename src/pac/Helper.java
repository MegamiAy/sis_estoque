package pac;

import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Helper {
	private Connection connect = null;

    public boolean mascara(String valor, String tipo) {
        switch (tipo.toLowerCase()) {
            case "money":
                // Formata valor monetário, mas retorna sempre true por consistência
                formatarValorMonetario(valor);
                return true;
            case "numeric":
                return verificarNumero(valor);
            default:
                return false; // Retorna false para tipos não reconhecidos
        }
    }

    // dinheiro
    private static void formatarValorMonetario(String valor) {
        try {
            double valorNumerico = Double.parseDouble(valor.replace(",", "."));
            NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            System.out.println(formatoMoeda.format(valorNumerico)); // Apenas exibe o valor formatado
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido");
        }
    }

    // verifica se é numérico
    private static boolean verificarNumero(String str) {
        if (str == null || str.isEmpty()) {
        	System.out.println("Valor Vazio. Digite um valor numérico.");
            return false; // Não é um número
        }
        try {
            Double.parseDouble(str);
            return true; // É um número
        } catch (NumberFormatException e) {
        	System.out.println("Valor inválido. Digite um valor numérico.");
            return false; // Não é um número
        }
    }
    
    public void closeConnection() {
        try {
            if (connect != null && !connect.isClosed()) {
                connect.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão: " + e.getMessage());
            e.printStackTrace();
        }
    }
}