public class Categoria {
    private int idC;
    private String nome;
    private String desc;

    public Categoria(int idC, String nome, String desc) {
        this.idC = idC;
        this.nome = nome;
        this.desc = desc;
    }

    public int getIdC() {
        return idC;
    }

    public String getNome() {
        return nome;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "ID: '" + this.idC + "', Nome: '" + this.nome + "', Descrição: '" + this.desc + "'";
    }
}
