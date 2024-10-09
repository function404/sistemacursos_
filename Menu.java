import java.util.ArrayList; // Importa a classe ArrayList
import java.util.Scanner; // Importa a classe Scanner

public class Menu {  
    public static void main(String[] args) { // Método principal
        Scanner scanner = new Scanner(System.in);
        int opt;

        ArrayList<Professor> professores = new ArrayList<>(); // Lista de professores
        ArrayList<Curso> cursos = new ArrayList<>(); // Lista de cursos
        ArrayList<Aluno> alunos = new ArrayList<>(); // Lista de alunos

        do { // Menu principal
            System.out.println("\n<----------Menu---------->");
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Cadastrar Curso");
            System.out.println("3 - Cadastrar Aluno");
            System.out.println("4 - Listar Professores");
            System.out.println("5 - Listar Cursos");
            System.out.println("6 - Listar Alunos");
            System.out.println("7 - Sair");
            System.out.println("<------------------------>");
            System.out.print("Escolha uma opção: ");

            // Tratamento de exceção para evitar que o programa quebre caso o usuário digite um valor inválido
            try {
                opt = scanner.nextInt();
            } catch (Exception e) {
                opt = 0;
                scanner.nextLine(); 
            }

            switch (opt) {
                // Cadastrar Professor
                case 1:
                    // Tratamento de exceção para evitar que o programa quebre caso o usuário digite um valor inválido
                    try {
                        System.out.print("\nDigite o ID do professor: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("\nDigite o nome do professor: ");
                        String nome = scanner.nextLine();

                        System.out.print("\nDigite o departamento do professor: ");
                        String departamento = scanner.nextLine();

                        // Adiciona o professor à lista de professoress
                        professores.add(new Professor(id, nome, departamento)); 
                        System.out.println("\nProfessor cadastrado com sucesso.");

                    } catch (Exception e) {
                        System.out.println("\nErro ao cadastrar o professor: " + e.getMessage());
                    }
                    break;
                
                // Cadastrar Curso
                case 2:
                    // Verifica se há professores cadastrados
                    if (professores.isEmpty()) { 
                        System.out.println("\nErro: Não é possível cadastrar um curso sem professores cadastrados.");
                    } else {
                        // Tratamento de exceção para evitar que o programa quebre caso o usuário digite um valor inválido
                        try {
                            System.out.print("\nDigite o ID do curso: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("\nDigite o nome do curso: ");
                            String nome = scanner.nextLine();

                            System.out.print("\nDigite a carga horária do curso: ");
                            int cargaHoraria = scanner.nextInt();
                            
                            System.out.print("\nDigite o ID do professor responsável: ");
                            int idProfessor = scanner.nextInt();
                            scanner.nextLine(); 


                            boolean professorEncontrado = false;

                            // Busca o professor pelo ID
                            for (Professor professor : professores) {
                                if (professor.getIdProf() == idProfessor) {
                                    // Adiciona o curso à lista de cursos
                                    cursos.add(new Curso(id, nome, cargaHoraria, professor)); 
                                    System.out.println("\nCurso cadastrado com sucesso.");
                                    professorEncontrado = true;
                                    break;
                                }
                            }

                            // Exibe a mensagem de erro caso o professor não seja encontrado
                            if (!professorEncontrado) {
                                System.out.println("\nErro: Professor não encontrado.");
                            }

                        } catch (Exception e) {
                            // Exibe a mensagem de erro
                            System.out.println("\nErro ao cadastrar o curso: " + e.getMessage());
                        }
                    }
                    break;

                // Cadastrar Aluno
                case 3:
                    // Verifica se há cursos cadastrados
                    if (cursos.isEmpty()) {
                        System.out.println("\nErro: Não é possível cadastrar um aluno sem cursos cadastrados.");
                    } else {
                        // Tratamento de exceção para evitar que o programa quebre caso o usuário digite um valor inválido
                        try {
                            System.out.print("\nDigite o ID do aluno: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            
                            System.out.print("\nDigite o nome do aluno: ");
                            String nome = scanner.nextLine();

                            System.out.print("\nDigite a data de nascimento (dd/MM/yyyy): ");
                            String dataNascimento = scanner.nextLine();

                            System.out.print("\nDigite o CPF do aluno: ");
                            String cpf = scanner.nextLine();

                            System.out.print("\nDigite o ID do curso: ");
                            int idCurso = scanner.nextInt();
                            scanner.nextLine();

                            boolean cursoEncontrado = false;

                            // Busca o curso pelo ID
                            for (Curso curso : cursos) {
                                if (curso.getIdCurso() == idCurso) {
                                    // Adiciona o aluno à lista de alunos
                                    alunos.add(new Aluno(id, nome, dataNascimento, cpf, curso)); 
                                    System.out.println("\nAluno cadastrado com sucesso.");
                                    cursoEncontrado = true;
                                    break;
                                }
                            }

                            // Exibe a mensagem de erro caso o curso não seja encontrado
                            if (!cursoEncontrado) {
                                System.out.println("\nErro: Curso não encontrado.");
                            }
                        } catch (Exception e) {
                            // Exibe a mensagem de erro
                            System.out.println("\nErro ao cadastrar o aluno: " + e.getMessage()); 
                        }
                    }
                    break;
                
                // Listar Professores
                case 4:
                    try{
                        // Verifica se há professores cadastrados
                        if (professores.isEmpty()) {
                            System.out.println("\nNenhum professor cadastrado.");
                        } else {
                            // Exibe os professores e seus cursos e a quantidade de alunos em cada curso
                            for (Professor professor : professores) {
                                System.out.print(professor);

                                boolean professorEncontrado = false;

                                // Busca o curso associado pelo ID do professor
                                for (Curso curso : professor.getCursos()) {
                                    if (curso.getProfessor().getIdProf() == professor.getIdProf()) {
                                        System.out.print("Cursos Associados: " + curso.getNome()  + " | Alunos no Curso: " + curso.getAlunos().size() + '\n');
                                        professorEncontrado = true;
                                    }
                                }

                                // Caso o professor não tenha curso associado
                                if (!professorEncontrado) {
                                    System.out.println("Cursos Associados: Nenhum curso associado.");
                                }                       
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("\nErro ao listar os professores: " + e.getMessage());
                    }
                    break;

                // Listar Cursos
                case 5:
                    try {
                        // Verifica se há cursos cadastrados
                        if (cursos.isEmpty()) { 
                            System.out.println("\nNenhum curso cadastrado.");
                        } else {
                            for (Curso curso : cursos) {
                                System.out.println(curso);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("\nErro ao listar os cursos: " + e.getMessage());
                    }
                    break;

                // Listar Alunos
                case 6:
                    try {
                        // Verifica se há alunos cadastrados
                        if (alunos.isEmpty()) { 
                            System.out.println("\nNenhum aluno cadastrado.");
                        } else {
                            // Exibe os alunos e seus cursos
                            for (Aluno aluno : alunos) {
                                System.out.println(aluno);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("\nErro ao listar os alunos: " + e.getMessage());
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

        // Fecha o scanner
        scanner.close();
    }
}
