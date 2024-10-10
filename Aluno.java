public class Aluno extends InfoGeral {
    // Atributos da classe Aluno
    private int idAluno;
    private String dataNascimento;
    private String cpf;
    private Curso curso;

    // Construtor da classe Aluno. Recebe o ID, nome, data de nascimento, CPF e curso do aluno
    public Aluno(int idAluno, String nomeAluno, String dataNascimento, String cpf, Curso curso) {
        // Atribui os valores recebidos aos atributos da classe Aluno
        super(nomeAluno);
        this.idAluno = idAluno;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.curso = curso;

        // Relaciona o aluno ao curso
        curso.getAlunos().add(this);
    }

    // Métodos getters
    // Método para retornar o ID do aluno
    public int getIdAluno() {
        return this.idAluno;
    }

    // Método para retornar o nome do aluno
    public String getNomeAluno() {
        return this.getNome();
    }

    // Método para retornar a data de nascimento do aluno
    public String getDataNascimento() {
        return this.dataNascimento;
    }

    // Método para retornar o CPF do aluno 
    public String getCpf() {
        return this.cpf;
    }

    // Método para retornar o curso do aluno
    public Curso getCurso() {
        return this.curso;
    }

    @Override
    public String toString() {
        return "\nNome do Aluno: " 
            + this.getNomeAluno() 
            + " | Data de Nascimento: " 
            + this.getDataNascimento() 
            + " | CPF: " 
            + this.getCpf() 
            + " | Curso: " 
            + this.curso.getNome();
    }
}
