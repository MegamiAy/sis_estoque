public class Produto{
  	private String nome;
	private int id;
	private String desc;
	private double preco;
	private Categoria categoria;
	private Fornecedor fornecedor;       

  public Produto(int id, String nome, String desc, double preco, Categoria categoria, Fornecedor fornecedor) {
      this.id = id;
      this.nome = nome;
      this.desc = desc;
      this.preco = preco;
      this.categoria = categoria;
      this.fornecedor = fornecedor;
  }

  // getters
  public int getId(){
	  return id;
  }

  public String getNome(){
	  return nome;
  }

  public String getDesc(){
	  return desc;
  }

  public double getPreco(){
	  return preco;
  }

  public Categoria getCategoria(){
	  return categoria;
  }

  public Fornecedor getFornecedor(){
	  return fornecedor;
  }
	
  // toString para melhor estrutura
  @Override
  public String toString(){
	  return "Id: "+this.id+", Nome: "+this.nome+", Desc: "+this.desc+", Preço: "+this.preco+", Categoria: "+this.categoria+", Fornecedor: "+this.fornecedor;
  }

}
