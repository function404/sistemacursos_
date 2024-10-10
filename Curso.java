import java.util.ArrayList; // Importa a classe ArrayList

public class Curso extends InfoGeral {
    // Atributos da classe Curso
    private int idCurso;
    private int cargaHoraria;
    private Professor professor;

    // Lista de alunos pelo curso
    ArrayList<Aluno> alunos = new ArrayList<>();

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

    // Métodos getters
    // Método para retornar a lista de alunos do curso
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    // Método para retornar o ID do curso
    public int getIdCurso() {
        return this.idCurso;
    }

    // Método para retornar a carga horária do curso
    public int getCargaHoraria() {
        return this.cargaHoraria;
    }

    // Método para retornar o professor do curso
    public Professor getProfessor() {
        return this.professor;
    }

    @Override
    public String toString() {
        return "\nNome do Curso: " 
            + this.getNome() 
            + " | Carga Horária: " 
            + this.getCargaHoraria() 
            + " horas"
            + " | Nome do Professor: " 
            + this.professor.getNome();
    }
}