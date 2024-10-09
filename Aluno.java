public class Aluno {
    // Atributos da classe Aluno
    int idAluno;
    String nomeAluno;
    String dataNascimento;
    String cpf;
    Curso curso;

    // Construtor da classe Aluno. Recebe o ID, nome, data de nascimento, CPF e curso do aluno
    public Aluno(int idAluno, String nomeAluno, String dataNascimento, String cpf, Curso curso) {
        // Atribui os valores recebidos aos atributos da classe Aluno
        this.idAluno = idAluno;
        this.nomeAluno = nomeAluno;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.curso = curso;

        // Relaciona o aluno ao curso
        curso.getAlunos().add(this);
    }
}
