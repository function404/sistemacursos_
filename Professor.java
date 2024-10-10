import java.util.ArrayList; // Importa a classe ArrayList

public class Professor extends InfoGeral {
    // Atributos da classe Professor
    private int idProf;
    private String departamento;

    // Lista de cursos pelo professor
    ArrayList<Curso> cursos = new ArrayList<>(); 

    // Construtor da classe Professor. Recebe o ID, nome e departamento do professor
    public Professor(int idProf, String nomeProf, String departamento) {
        // Atribui os valores recebidos aos atributos da classe Professor
        super(nomeProf);
        this.idProf = idProf;
        this.departamento = departamento;
    }

    // Métodos getters
    // Método para retornar o ID do professor
    public int getIdProf() {
        return this.idProf;
    }

    // Método para retornar o departamento do professor
    public String getDepartamento() {
        return this.departamento;
    }

    // Método para adicionar um curso ao professor
    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    // Método para calcular a carga horária total dos cursos do professor
    public int calcularCargaHorariaTotal() {
        int cargaHorariaTotal = 0;
        for (Curso curso : cursos) {
            cargaHorariaTotal += curso.getCargaHoraria(); // Soma a carga horária de cada curso
        }
        return cargaHorariaTotal;
    }

    @Override
    public String toString() {
        return "\nNome do Professor: " 
            + this.getNome()
            + " | Departamento: "
            + this.getDepartamento()
            + " | Carga Horária Total: "
            + this.calcularCargaHorariaTotal()
            + " horas\n";
    }
}