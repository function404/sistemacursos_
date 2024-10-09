import java.util.ArrayList; // Importa a classe ArrayList

public class Professor extends InfoGeral {
    // Atributos da classe Professor
    private int idProf;
    private String departamento;

    // Lista de cursos pelo professor
    static ArrayList<Curso> cursos = new ArrayList<>(); 

    // Construtor da classe Professor. Recebe o ID, nome e departamento do professor
    public Professor(int idProf, String nomeProf, String departamento) {
        // Atribui os valores recebidos aos atributos da classe Professor
        super(nomeProf);
        this.idProf = idProf;
        this.departamento = departamento;
    }

    // Métodos getters
    public int getIdProf() {
        return this.idProf;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    @Override
    public String toString() {
        return "Nome do Professor: " 
            + this.getNome()
            + " | Departamento: "
            + this.getDepartamento()
            + " | Cursos Associados: ";
    }
}