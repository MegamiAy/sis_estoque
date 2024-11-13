package pac;
public class Fornecedor {
    private int idF;
    private String nome;
    private String fone;
    private String email;
    private String endereco;

    public Fornecedor(int idF, String nome, String fone, String email, String endereco) {
        this.idF = idF;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
        this.endereco = endereco;
    }

    public int getIdF() { return idF; }
    public String getNome() { return nome; }
    public String getFone() { return fone; }
    public String getEmail() { return email; }
    public String getEndereco() { return endereco; }

    @Override
    public String toString() {
        return "Fornecedor{"+"id="+idF+", nome='"+nome+'\'' +
               ", fone='"+fone+'\''+", email='"+email+'\'' +
               ", endereco='"+endereco+'\''+'}';
    }
}
