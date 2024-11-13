import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private int idE;
    private Produto produto;
    private int quantidade;
    private static List<Estoque> listEstoque = new ArrayList<>();

    public Estoque(int idE, Produto produto, int quantidade) {
        this.idE = idE;
        this.produto = produto;
        this.quantidade = quantidade;
        listEstoque.add(this);   
    }

    public int getIdE() {
        return idE;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public static List<Estoque> listarEstoques() {
        return listEstoque;
    }

    @Override
    public String toString() {
        return "Id: "+this.idE+", Produto: "+this.produto +
               ", Quantidade: "+this.quantidade;
    }
}
