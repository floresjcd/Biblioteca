import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Autor> autores = new ArrayList<>();
    private static ArrayList<Livro> livros = new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
            System.out.println("1. Cadastrar Autor");
            System.out.println("2. Cadastrar Livro");
            System.out.println("3. Cadastrar Usuário");
            System.out.println("4. Realizar Empréstimo");
            System.out.println("5. Listar Livros");
            System.out.println("6. Listar Empréstimos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarAutor();
                    break;
                case 2:
                    cadastrarLivro();
                    break;
                case 3:
                    cadastrarUsuario();
                    break;
                case 4:
                    realizarEmprestimo();
                    break;
                case 5:
                    listarLivros();
                    break;
                case 6:
                    listarEmprestimos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarAutor() {
        System.out.print("Nome do Autor: ");
        String nome = scanner.nextLine();
        System.out.print("Nacionalidade: ");
        String nacionalidade = scanner.nextLine();
        autores.add(new Autor(nome, nacionalidade));
        System.out.println("Autor cadastrado com sucesso!");
    }

    private static void cadastrarLivro() {
        if (autores.isEmpty()) {
            System.out.println("Cadastre autores primeiro!");
            return;
        }

        System.out.println("Autores disponíveis:");
        for (int i = 0; i < autores.size(); i++) {
            System.out.println((i + 1) + ". " + autores.get(i));
        }

        System.out.print("Escolha o número do autor: ");
        int autorIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpar buffer

        System.out.print("Título do Livro: ");
        String titulo = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        livros.add(new Livro(titulo, isbn, autores.get(autorIndex)));
        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void cadastrarUsuario() {
        System.out.print("Nome do Usuário: ");
        String nome = scanner.nextLine();
        System.out.print("ID: ");
        String id = scanner.nextLine();
        usuarios.add(new Usuario(nome, id));
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void realizarEmprestimo() {
        if (livros.isEmpty() || usuarios.isEmpty()) {
            System.out.println("Cadastre livros e usuários primeiro!");
            return;
        }

        System.out.println("Livros disponíveis:");
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).isDisponivel()) {
                System.out.println((i + 1) + ". " + livros.get(i));
            }
        }

        System.out.print("Escolha o número do livro: ");
        int livroIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpar buffer

        System.out.println("Usuários disponíveis:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i + 1) + ". " + usuarios.get(i));
        }

        System.out.print("Escolha o número do usuário: ");
        int usuarioIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpar buffer

        System.out.print("Dias para devolução: ");
        int dias = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        Emprestimo emp = new Emprestimo(livros.get(livroIndex), usuarios.get(usuarioIndex), dias);
        emprestimos.add(emp);
        System.out.println("Empréstimo realizado:\n" + emp);
    }

    private static void listarLivros() {
        System.out.println("\n=== LIVROS CADASTRADOS ===");
        for (Livro livro : livros) {
            System.out.println(livro);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static void listarEmprestimos() {
        System.out.println("\n=== EMPRÉSTIMOS ATIVOS ===");
        for (Emprestimo emp : emprestimos) {
            System.out.println(emp + "\n");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}