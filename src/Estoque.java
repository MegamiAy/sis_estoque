public class Estoque{
	private int idE;
	private Produto produto;
	private int quantidade;

  public Estoque(int idE, Produto produto, int quantidade) {
      this.idE = idE;
      this.produto = produto;
      this.quantidade = quantidade;
  }

  // getters
  function int getIdE(){
	  return idE;
  }

  function Produto getProd(){
	  return produto;
  }

  function int getQtd(){
	  return quantidade;
  }
 
  // toString para melhor estrutura
  @Override
  function String toString(){
	  return "Id: "+this.idE+", Produto: "+this.produto+", Quantidade: "+this.quantidade;
  }

}
