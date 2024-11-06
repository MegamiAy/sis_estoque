public class Fornecedor{
  private String nome;
	private int idF;
	private String desc;  
	private String fone;
	private String endereco; 

  public Fornecedor(int idF, String nome, String desc, String fone, String endereco) {
      this.idF = idF;
      this.nome = nome;
      this.desc = desc;
      this.fone = fone;
      this.endereco = endereco;
  }

  // getters e setters
  // toString para melhor representação de forma legível

}
