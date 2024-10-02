import java.util.ArrayList;
import java.util.Scanner;

public class PrincipalCurso {

    private static ArrayList<Professor> professores = new ArrayList<>();
    private static ArrayList<Curso> cursos = new ArrayList<>();
    private static ArrayList<Aluno> alunos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("MENU DO SEU SISTEMA DE CURSOS!!!");
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Cadastrar Curso");
            System.out.println("3 - Cadastrar Aluno");
            System.out.println("4 - Listar Professores");
            System.out.println("5 - Listar Cursos");
            System.out.println("6 - Listar Alunos");
            System.out.println("7 - Encerrar o sistema :(");
            System.out.print("Escolha uma das opções acima!!! ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        cadastrarProfessor();
                        break;
                    case 2:
                        cadastrarCurso();
                        break;
                    case 3:
                        cadastrarAluno();
                        break;
                    case 4:
                        listarProfessores();
                        break;
                    case 5:
                        listarCursos();
                        break;
                    case 6:
                        listarAlunos();
                        break;
                    case 7:
                        System.out.println("Até mais!!!");
                        break;
                    default:
                        System.out.println("Você escolheu uma opção inválida, escolha novamente!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ta errado isso ai. Escolha uma das opções listadas.");
                opcao = 0;
            }
        } while (opcao != 7);
    }

    private static void cadastrarProfessor() {
        System.out.print("Insira o nome do professor: ");
        String nome = scanner.nextLine();
        System.out.print("Qual o departamento do professor inserido? ");
        String departamento = scanner.nextLine();

        Professor professor = new Professor(nome, departamento);
        professores.add(professor);
        System.out.println("Ocorreu tudo certo!!!");
        System.out.println("O ID desse professor é: " + professor.getIdProfessor());
    }

    private static void cadastrarCurso() {
        System.out.print("Insira o nome do curso: ");
        String nome = scanner.nextLine();
        System.out.print("Insira qual a carga horária do curso: ");
        
        int cargaHoraria = 0;
        while (true) {
            try {
                cargaHoraria = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("A carga horaria está incorreta, insira novamente.");
                scanner.nextLine();
            }
        }

        System.out.println("Um dos professores cadastrados tem que ser relacionado a essa matéria:");
        for (Professor professor : professores) {
            System.out.println(professor.getNomeProfessor());
        }

        System.out.print("Insira o nome do professor: ");
        String nomeProfessor = scanner.nextLine();
        Professor professorSelecionado = null;//pra deixar limpinho

        for (Professor professor : professores) {
            if (professor.getNomeProfessor().equalsIgnoreCase(nomeProfessor)) {
                professorSelecionado = professor;
                break;
            }
        }

        if (professorSelecionado != null) {
            Curso curso = new Curso(nome, cargaHoraria, professorSelecionado);
            cursos.add(curso);
            System.out.println("Ocorreu tudo certo!!!");
            System.out.println("O ID do curso criado é: " + curso.getIdCurso());
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    private static void cadastrarAluno() {
        System.out.print("Insira o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Insira a data de nascimento (dia/mês/ano): ");//Aqui eu tenho um problema, pq pra eu calcular a idade eu tinha q fazer inserir como int,
        String dataNascimento = scanner.nextLine();//podia usar o Integer.parseInt, mas ia da ruim se colocasse pontuação
        System.out.print("Insira o CPF do aluno sem pontuações: ");//eu pensei em pedir os numeros todos separados tbm, ou só o ano pra calcular a idade, mas dai ia ficar feio o codigo ne
        String cpf = scanner.nextLine();

        System.out.println("Escolha o Curso:");
        for (Curso curso : cursos) {
            System.out.println(curso.getNomeCurso());
        }

        System.out.print("Insira o nome do curso: ");
        String nomeCurso = scanner.nextLine();
        Curso cursoSelecionado = null;

        for (Curso curso : cursos) {
            if (curso.getNomeCurso().equalsIgnoreCase(nomeCurso)) {
                cursoSelecionado = curso;
                break;
            }
        }

        if (cursoSelecionado != null) {
            Aluno aluno = new Aluno(nome, dataNascimento, cpf, cursoSelecionado);
            alunos.add(aluno);
            System.out.println("Ocorreu tudo certo!!!");
            System.out.println("O ID do aluno criado é: " + aluno.getIdAluno());
        } else {
            System.out.println("Curso não encontrado.");
        }
    }

    private static void listarProfessores() {
        for (Professor professor : professores) {
            System.out.println("ID: " + professor.getIdProfessor() + ", Nome: " + professor.getNomeProfessor() + ", Departamento: " + professor.getDepartamentoProfessor());
        }
    }

    private static void listarCursos() {
        for (Curso curso : cursos) {
            System.out.println("ID: " + curso.getIdCurso() + ", Nome: " + curso.getNomeCurso() + ", Carga Horária: " + curso.getCargaHorariaCurso() +
                    ", Professor: " + curso.getProfessorCurso().getNomeProfessor());
        }
    }

    private static void listarAlunos() {
        for (Aluno aluno : alunos) {
            System.out.println("ID: " + aluno.getIdAluno() + ", Nome: " + aluno.getNomeAluno() + ", Data de Nascimento: " + aluno.getDataNascimentoAluno() +
                    ", CPF: " + aluno.getCpfAluno() + ", Curso: " + aluno.getCursoAluno().getNomeCurso());
        }
    }
}
