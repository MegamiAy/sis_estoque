import java.util.List;

public interface ProdutoInt{
  void addProd(Produto produto);
  List<Produto> listProd();
  void editProd(int id);
  void delProd(int id);
}
