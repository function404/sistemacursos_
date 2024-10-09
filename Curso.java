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
        professor.getCursos().add(this);
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    @Override
    public String toString() {
        return "Curso: " + this.nomeCurso 
            + " | Carga Horária: " 
            + this.cargaHoraria 
            + " horas"
            + " | Professor: " 
            + this.professor.nomeProf;
    }
}
