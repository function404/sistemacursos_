import java.util.ArrayList; // Importa a classe ArrayList

public class Professor {
    // Atributos da classe Professor
    int idProf;
    String nomeProf;
    String departamento;

    // Lista de cursos pelo professor
    ArrayList<Curso> cursos = new ArrayList<>(); 

    // Construtor da classe Professor. Recebe o ID, nome e departamento do professor
    public Professor(int idProf, String nomeProf, String departamento) {
        // Atribui os valores recebidos aos atributos da classe Professor
        this.idProf = idProf;
        this.nomeProf = nomeProf;
        this.departamento = departamento;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }
}