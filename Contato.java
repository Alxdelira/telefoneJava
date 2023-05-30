import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contato {
    private String nome;
    private String telefonePessoal;
    private boolean emergencia;

    public Contato(String nome, String telefonePessoal, boolean emergencia) {
        this.nome = nome;
        this.telefonePessoal = telefonePessoal;
        this.emergencia = emergencia;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefonePessoal() {
        return telefonePessoal;
    }

    public boolean isEmergencia() {
        return emergencia;
    }
}

class ListaDeContato {
    private List<Contato> contatos;

    public ListaDeContato() {
        contatos = new ArrayList<>();
    }

    public void CadastrarContato() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Telefone Pessoal: ");
            String telefonePessoal = scanner.nextLine();

            System.out.print("É contato de emergência? (S/N): ");
            String opcao = scanner.nextLine().toUpperCase();
            boolean emergencia = opcao.equals("S");

            Contato contato = new Contato(nome, telefonePessoal, emergencia);
            contatos.add(contato);
        }

        System.out.println("Contato cadastrado com sucesso!");
    }

    public void ListarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("A lista de contatos está vazia.");
        } else {
            System.out.println("Lista de Contatos:");

            for (int i = 0; i < contatos.size(); i++) {
                Contato contato = contatos.get(i);
                System.out.println((i + 1) + ". " + contato.getNome() + " - " + contato.getTelefonePessoal()
                        + (contato.isEmergencia() ? " (Emergência)" : ""));
            }
        }
    }

    public void AlterarContatos() {
        try (Scanner scanner = new Scanner(System.in)) {
            ListarContatos();

            System.out.print("Digite o número do contato que deseja alterar: ");
            int indice = scanner.nextInt();

            if (indice >= 1 && indice <= contatos.size()) {
                Contato contato = contatos.get(indice - 1);

                System.out.println("Novos dados para o contato:");

                System.out.print("Nome (" + contato.getNome() + "): ");
                String nome = scanner.next();

                System.out.print("Telefone Pessoal (" + contato.getTelefonePessoal() + "): ");
                String telefonePessoal = scanner.next();

                System.out.print("É contato de emergência? (S/N) (" + (contato.isEmergencia() ? "S" : "N") + "): ");
                String opcao = scanner.next().toUpperCase();
                boolean emergencia = opcao.equals("S");

                contato = new Contato(nome, telefonePessoal, emergencia);
                contatos.set(indice - 1, contato);

                System.out.println("Contato alterado com sucesso!");
            } else {
                System.out.println("Índice inválido.");
            }
        }
    }

    public void EntrarEmContato() {
        try (Scanner scanner = new Scanner(System.in)) {
            ListarContatos();

            System.out.print("Digite o número do contato que deseja entrar: ");
            int indice = scanner.nextInt();

            if (indice >= 1 && indice <= contatos.size()) {
                Contato contato = contatos.get(indice - 1);
                
                System.out.println("Entrando em contato com " + contato.getNome() + ":");
                System.out.println("1 - Realizar ligação para " + contato.getTelefonePessoal());
                System.out.println("2 - Digitar outro número de telefone");

                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        realizarLigacao(contato.getTelefonePessoal());
                        break;
                    case 2:
                        System.out.print("Digite o número de telefone: ");
                        String numeroTelefone = scanner.next();
                        realizarLigacao(numeroTelefone);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } else {
                System.out.println("Índice inválido.");
            }
        }
    }

    public void realizarLigacao(String numeroTelefone) {
        System.out.println("Realizando ligação para o número: " + numeroTelefone);
        // Lógica para realizar a ligação
    }

    public void ExcluirContatos() {
        try (Scanner scanner = new Scanner(System.in)) {
            ListarContatos();

            System.out.print("Digite o número do contato que deseja excluir: ");
            int indice = scanner.nextInt();

            if (indice >= 1 && indice <= contatos.size()) {
                Contato contato = contatos.get(indice - 1);
                contatos.remove(indice - 1);

                System.out.println("Contato " + contato.getNome() + " removido com sucesso!");
            } else {
                System.out.println("Índice inválido.");
            }
        }
    }
}

