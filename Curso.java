import java.util.ArrayList; // Importa a classe ArrayList

public class Curso {
    // Atributos da classe Curso
    int idCurso;
    String nomeCurso;
    int cargaHoraria;
    Professor professor;

    // Lista de alunos pelo curso
    static ArrayList<Aluno> alunos = new ArrayList<>();

    // Construtor da classe Curso. Recebe o ID, nome, carga horária e professor do curso
    public Curso(int idCurso, String nomeCurso, int cargaHoraria, Professor professor) { 
        // Atribui os valores recebidos aos atributos da classe Curso
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;

        // Relaciona o curso ao professor
        professor.adicionarCurso(this); 
    }

    public void adicionarAluno(Aluno aluno) {
        // Adiciona um aluno à lista de alunos do curso
        alunos.add(aluno); 
    }
}
