package atvd3;

import java.util.ArrayList; // Importa a classe ArrayList

public class Professor {
    // Atributos da classe Professor
    int id;
    String nome;
    String departamento;
    ArrayList<Curso> cursos = new ArrayList<>(); // Lista de cursos pelo professor

    // Construtor da classe Professor
    public Professor(int id, String nome, String departamento) {// Recebe o ID, nome e departamento do professor
        // Atribui os valores recebidos aos atributos da classe Professor
        this.id = id;
        this.nome = nome;
        this.departamento = departamento; // Departamento do professor
    }

    // Getters dos atributos da classe Professor
    public int getId() {
        return id;// Retorna o ID do professor
    }

    public String getNome() {
        return nome;// Retorna o nome do professor
    }

    public String getDepartamento() {
        return departamento;// Retorna o departamento do professor
    }

    public ArrayList<Curso> getCursos() {
        return cursos;// Retorna a lista de cursos do professor
    }

    public void adicionarCurso(Curso curso) {
        cursos.add(curso);// Adiciona um curso à lista de cursos do professor
    }

    // Método toString da classe Professor
    public String toString() {
        return "Professor: " + nome + " | Departamento: " + departamento;
    }
}