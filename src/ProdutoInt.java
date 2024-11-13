import java.util.List;

public interface ProdutoInt {
    void addProd(Produto produto);
    List<Produto> listProd();
    void editProd(int id, String nome, String desc, double preco, int categoria, int fornecedor);
    void delProd(int id);
    boolean checkEstoqueMin(int idProduto, int qtMin);
    Produto getProdutoById(int id);
}
