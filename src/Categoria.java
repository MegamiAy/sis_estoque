import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private int idC;
    private String nome;
    private String desc;
    private static List<Categoria> listCategorias = new ArrayList<>();

    public Categoria(int idC, String nome, String desc) {
        this.idC = idC;
        this.nome = nome;
        this.desc = desc;
        listCategorias.add(this);
    }

    public int getIdC() {
        return idC;
    }

    public String getNome() {
        return nome;
    }

    public String getDesc() {
        return desc;
    }

    public static List<Categoria> listarCategorias() {
        return listCategorias;
    }
    
    @Override
    public String toString() {
        return "ID: '" + this.idC + "', Nome: '" + this.nome + "', Descrição: '" + this.desc + "'";
    }
}
