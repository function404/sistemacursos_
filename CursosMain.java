package atvd3;

import java.util.ArrayList; // Importa a classe ArrayList
import java.util.Scanner; // Importa a classe Scanner

public class CursosMain {
    static ArrayList<Professor> professores = new ArrayList<>(); // Lista de professores
    static ArrayList<Curso> cursos = new ArrayList<>(); // Lista de cursos
    static ArrayList<Aluno> alunos = new ArrayList<>(); // Lista de alunos
    
    public static void main(String[] args) { // Método principal
        Scanner scanner = new Scanner(System.in);
        int opt;

        do { // Menu principal
            System.out.println("\n<----------Menu---------->");
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Cadastrar Curso");
            System.out.println("3 - Cadastrar Aluno");
            System.out.println("4 - Listar Professores");
            System.out.println("5 - Listar Cursos");
            System.out.println("6 - Listar Alunos");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            opt = scanner.nextInt();

            switch (opt) {
                // Cadastrar Professor
                case 1:
                    try { // Tratamento de exceção para evitar que o programa quebre caso o usuário digite um valor inválido
                        System.out.print("\nDigite o ID do professor: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consome o \n deixado pelo nextInt()
                        System.out.print("\nDigite o nome do professor: ");
                        String nome = scanner.nextLine();
                        System.out.print("\nDigite o departamento do professor: ");
                        String departamento = scanner.nextLine();
                        professores.add(new Professor(id, nome, departamento)); // Adiciona o professor à lista de professoress
                        System.out.println("\nProfessor cadastrado com sucesso.");
                    } catch (Exception e) {
                        System.out.println("\nErro ao cadastrar o professor: " + e.getMessage()); // Exibe a mensagem de erro
                    }
                    break;
                
                // Cadastrar Curso
                case 2:
                    if (professores.isEmpty()) { // Verifica se há professores cadastrados
                        System.out.println("\nErro: Não é possível cadastrar um curso sem professores cadastrados.");
                    } else {
                        try { // Tratamento de exceção para evitar que o programa quebre caso o usuário digite um valor inválido
                            System.out.print("\nDigite o ID do curso: ");
                            int id = scanner.nextInt();
                            scanner.nextLine(); // Consome o \n deixado pelo nextInt()
                            System.out.print("\nDigite o nome do curso: ");
                            String nome = scanner.nextLine();
                            System.out.print("\nDigite a carga horária do curso: ");
                            int cargaHoraria = scanner.nextInt();
                            System.out.print("\nDigite o ID do professor responsável: ");
                            int idProfessor = scanner.nextInt();
                            scanner.nextLine(); // Consome o \n deixado pelo nextInt()
                            Professor professor = professores.stream()
                                    .filter(p -> p.getId() == idProfessor).findFirst().orElse(null);// Busca o professor pelo ID
                            if (professor != null) { 
                                cursos.add(new Curso(id, nome, cargaHoraria, professor)); // Adiciona o curso à lista de cursos
                                System.out.println("\nCurso cadastrado com sucesso.");
                            } else {
                                System.out.println("\nErro: Professor não encontrado.");
                            }
                        } catch (Exception e) {
                            System.out.println("\nErro ao cadastrar o curso: " + e.getMessage()); // Exibe a mensagem de erro
                        }
                    }
                    break;

                // Cadastrar Aluno
                case 3:
                    if (cursos.isEmpty()) { // Verifica se há cursos cadastrados
                        System.out.println("\nErro: Não é possível cadastrar um aluno sem cursos cadastrados.");
                    } else {
                        try { // Tratamento de exceção para evitar que o programa quebre caso o usuário digite um valor inválido
                            System.out.print("\nDigite o ID do aluno: ");
                            int id = scanner.nextInt();
                            scanner.nextLine(); // Consome o \n deixado pelo nextInt()
                            System.out.print("\nDigite o nome do aluno: ");
                            String nome = scanner.nextLine();
                            System.out.print("\nDigite a data de nascimento (dd/MM/yyyy): ");
                            String dataNascimento = scanner.nextLine();
                            System.out.print("\nDigite o CPF do aluno: ");
                            String cpf = scanner.nextLine();
                            System.out.print("\nDigite o ID do curso: ");
                            int idCurso = scanner.nextInt();
                            scanner.nextLine(); // Consome o \n deixado pelo nextInt()
                            Curso curso = cursos.stream().filter(c -> c.getId() == idCurso).findFirst().orElse(null); // Busca o curso pelo ID
                            if (curso != null) {
                                alunos.add(new Aluno(id, nome, dataNascimento, cpf, curso)); // Adiciona o aluno à lista de alunos
                                System.out.println("\nAluno cadastrado com sucesso.");
                            } else {
                                System.out.println("\nErro: Curso não encontrado.");
                            }
                        } catch (Exception e) {
                            System.out.println("\nErro ao cadastrar o aluno: " + e.getMessage()); // Exibe a mensagem de erro
                        }
                    }
                    break;
                
                // Listar Professores
                case 4:
                    if (professores.isEmpty()) { // Verifica se há professores cadastrados
                        System.out.println("\nNenhum professor cadastrado.");
                    } else {
                        for (Professor professor : professores) {
                            System.out.println(professor);
                            for (Curso curso : professor.getCursos()) {
                                System.out.println("Cursos:" + curso.getNome() + " | Alunos no curso: " + curso.getAlunos().size());
                            }
                            System.out.println();
                        }
                    }
                    break;

                // Listar Cursos
                case 5:
                    if (cursos.isEmpty()) { // Verifica se há cursos cadastrados
                        System.out.println("\nNenhum curso cadastrado.");
                    } else {
                        cursos.forEach(System.out::println);
                    }
                    break;

                // Listar Alunos
                case 6:
                    if (alunos.isEmpty()) { // Verifica se há alunos cadastrados
                        System.out.println("\nNenhum aluno cadastrado.");
                    } else {
                        alunos.forEach(System.out::println);
                    }
                    break;
                
                // Sair
                case 7:
                    System.out.println("\nSaindo...");
                    break;
                
                // Opção inválida
                default:
                    System.out.println("\nOpção inválida.");
            }
        } while (opt != 7);

        scanner.close();
    }
}
