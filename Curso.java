import java.util.ArrayList; // Importa a classe ArrayList

public class Curso {
    // Atributos da classe Curso
    int id;
    String nome;
    int cargaHoraria;
    Professor professor;
    ArrayList<Aluno> alunos = new ArrayList<>(); // Lista de alunos no curso

    public Curso(int id, String nome, int cargaHoraria, Professor professor) { // Recebe o ID, nome, carga horária e professor do curso
        // Atribui os valores recebidos aos atributos da classe Curso
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        professor.adicionarCurso(this); // Relaciona o curso ao professor
    }

    // Getters dos atributos da classe Curso
    public int getId() {
        return id;// Retorna o ID do curso
    }

    public String getNome() {
        return nome;// Retorna o nome do curso
    }

    public int getCargaHoraria() {
        return cargaHoraria;// Retorna a carga horária do curso
    }

    public Professor getProfessor() {
        return professor;// Retorna o professor do curso
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;// Retorna a lista de alunos do curso
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno); // Adiciona um aluno à lista de alunos do curso
    }

    // Método toString da classe Curso
    public String toString() {
        return"Curso: " + nome + " | Carga Horária: " + cargaHoraria + " horas | Professor: " + professor.getNome();
    }
}
