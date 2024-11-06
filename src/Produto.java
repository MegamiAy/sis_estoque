public class Produto{
  private String nome;
	private String desc;
	private double preco;
	private Categoria categoria;
	private Fornecedor fornecedor;       

  public Produto(String nome, String desc, double preco, Categoria categoria, Fornecedor fornecedor) {
      this.nome = nome;
      this.desc = desc;
      this.preco = preco;
      this.categoria = categoria;
      this.fornecedor = fornecedor;
  }

  // getters e setters
  // toString para melhor estrutura

}
