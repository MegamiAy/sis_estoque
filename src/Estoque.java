public class Estoque {
    private int idE;
    private Produto produto;
    private int quantidade;
    private static List<Estoque> listaEstoque = new ArrayList<>();

    public Estoque(int idE, Produto produto, int quantidade) {
        this.idE = idE;
        this.produto = produto;
        this.quantidade = quantidade;
        listaEstoque.add(this);   
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
        return listaEstoque;
    }

    @Override
    public String toString() {
        return "Id: "+this.idE+", Produto: "+this.produto +
               ", Quantidade: "+this.quantidade;
    }
}
