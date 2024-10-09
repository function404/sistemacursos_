import java.util.ArrayList; // Importa a classe ArrayList

public class Curso extends InfoGeral {
    // Atributos da classe Curso
    private int idCurso;
    private int cargaHoraria;
    private Professor professor;

    // Lista de alunos pelo curso
    static ArrayList<Aluno> alunos = new ArrayList<>();

    // Construtor da classe Curso. Recebe o ID, nome, carga horária e professor do curso
    public Curso(int idCurso, String nomeCurso, int cargaHoraria, Professor professor) { 
        // Atribui os valores recebidos aos atributos da classe Curso
        super(nomeCurso);
        this.idCurso = idCurso;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;

        // Relaciona o curso ao professor
        professor.getCursos().add(this);
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public int getIdCurso() {
        return this.idCurso;
    }

    public int getCargaHoraria() {
        return this.cargaHoraria;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    @Override
    public String toString() {
        return "Curso: " + this.getNome() 
            + " | Carga Horária: " 
            + this.cargaHoraria 
            + " horas"
            + " | Professor: " 
            + this.professor.getNome();
    }
}