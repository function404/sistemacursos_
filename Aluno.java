package atvd3;

public class Aluno {
    // Atributos da classe Aluno
    int id;
    String nome;
    String dataNascimento;
    String cpf;
    Curso curso;

    // Construtor da classe Aluno
    public Aluno(int id, String nome, String dataNascimento, String cpf, Curso curso) { // Recebe o ID, nome, data de nascimento, CPF e curso do aluno
        // Atribui os valores recebidos aos atributos da classe Aluno
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.curso = curso;
        curso.adicionarAluno(this); // Relaciona o aluno ao curso
    }

    // Getters dos atributos da classe Aluno
    public int getId() {
        return id;// Retorna o ID do aluno
    }

    public String getNome() {
        return nome;// Retorna o nome do aluno
    }

    public String getDataNascimento() {
        return dataNascimento;// Retorna a data de nascimento do aluno
    }

    public String getCpf() {
        return cpf;// Retorna o CPF do aluno
    }

    public Curso getCurso() {
        return curso; // Retorna o curso do aluno
    }

    // Método toString da classe Aluno
    public String toString() {
        return "Aluno: " + nome + " | Nascimento: " + dataNascimento + " | CPF: " + cpf + " | Curso: " + curso.getNome();
    }
}
