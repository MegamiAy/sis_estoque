package pac;
public class Estoque {
    private int idE;
    private Produto produto;
    private int quantidade;

    public Estoque(int idE, Produto produto, int quantidade) {
        this.idE = idE;
        this.produto = produto;
        this.quantidade = quantidade;
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

    @Override
    public String toString() {
        return "Id: "+this.idE+", Produto: "+this.produto +
               ", Quantidade: "+this.quantidade;
    }
}
