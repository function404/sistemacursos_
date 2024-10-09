public class InfoGeral {
    private String nome;

    public InfoGeral(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome;
    }
}
