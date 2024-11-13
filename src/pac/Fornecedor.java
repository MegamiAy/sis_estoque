package pac;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {
    private int idF;
    private String nome;
    private String fone;
    private String email;
    private String endereco;
    private static List<Fornecedor> listFornecedores = new ArrayList<>();

    public Fornecedor(int idF, String nome, String fone, String email, String endereco) {
        this.idF = idF;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
        this.endereco = endereco;
        listFornecedores.add(this);
    }

    public int getIdF() { return idF; }
    public String getNome() { return nome; }
    public String getFone() { return fone; }
    public String getEmail() { return email; }
    public String getEndereco() { return endereco; }
    
    public static List<Fornecedor> listarFornecedores() {
		return listFornecedores;
	}

    @Override
    public String toString() {
        return "Fornecedor{"+"id="+idF+", nome='"+nome+'\'' +
               ", fone='"+fone+'\''+", email='"+email+'\'' +
               ", endereco='"+endereco+'\''+'}';
    }
}
