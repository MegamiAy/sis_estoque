// Interface ProdutoInt
import java.util.List;

public interface ProdutoInt {
    void addProd(Produto produto);
    void listProd();
    void editProd(int id, String nome, String desc, double preco, int categoria, int fornecedor);
    void delProd(int id);
    void checkEstoqueMin(int idProduto, int qtMin);
}
