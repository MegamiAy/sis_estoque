// funções helper, para "facilitar", encurtar o caminho
// exeplo de uso:
// ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
// String valor = "123456.78";
// String telefone = "11987654321";
// ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
// System.out.println("Valor monetário formatado: " + mascara(valor, "money"));
// System.out.println("Telefone formatado: " + mascara(telefone, "phone"));
import java.text.NumberFormat;
import java.util.Locale;

public class Helper {
  
public static String mascara(String valor, String tipo) {
        switch (tipo.toLowerCase()) {
            case "money":
                return formatarValorMonetario(valor);
            case "phone":
                return formatarTelefone(valor);
            default:
                return valor; // retorna o dado original, para casos do tipo não for reconhecido
        }
    }
    // dinheiro
    private static String formatarValorMonetario(String valor) {
        try {
            double valorNumerico = Double.parseDouble(valor.replace(",", "."));
            NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            return formatoMoeda.format(valorNumerico);
        } catch (NumberFormatException e) {
            return "Valor inválido";
        }
    }
    // telefone
    private static String formatarTelefone(String telefone) {
        telefone = telefone.replaceAll("[^\\d]", "");
        if (telefone.length() == 11) {
            return String.format("(%s) %s-%s", 
                                  telefone.substring(0, 2), 
                                  telefone.substring(2, 7), 
                                  telefone.substring(7));
        } else if (telefone.length() == 10) {
            return String.format("(%s) %s-%s", 
                                  telefone.substring(0, 2), 
                                  telefone.substring(2, 6), 
                                  telefone.substring(6));
        } else {
            return telefone;
        }
    }
}
