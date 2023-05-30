import java.util.Scanner;

// Construa um projeto em Java que represente uma lista de contatos de um telefone.
// O programa deverá ter um menu com as opções de cadastrar, listar, alterar e excluir e entrar no contato;
// Cada contato deverá armazenar o Nome, o Telefone Pessoal e se é contato de emergência;
// Para as opções de cadastrar o contato, poderá ser cadastrado um contato contendo no mínimo o nome e o telefone. 
// E também a opção de inserir todos os campos. 
// Não poderá ser permitido a criação de um contato sem nenhuma informação (Nome, telefone e emergência);
// Após entrar no contato, você deverá implementar a opção de realizar uma ligação, 
// que poderá receber outro contato ou então o número de telefone de outra pessoa que não está na lista.

public class Principal {
    public static void main(String[] args) {
        int opcao = 0;
            ListaDeContato contato = new ListaDeContato();
            try (Scanner leitor = new Scanner(System.in)) {
                System.out.println("____________Motorola S4 Pro Plus 11-Promax____________");
                System.out.println("Escolha uma opção:");
                do {
                    System.out.println("0 - Sair");
                    System.out.println("1 - Cadastrar Contato");
                    System.out.println("2 - Listar Contatos ");
                    System.out.println("3 - Alterar Contatos");
                    System.out.println("4 - Entrar em um Contato");
                    System.out.println("5 - Excluir Contatos");
                    System.out.print("Digite sua Opção Aqui: ");

                    opcao = leitor.nextInt();

                    switch (opcao) {
                        case 1: {
                            contato.CadastrarContato();
                            break;
                        }
                        case 2: {
                            contato.ListarContatos();
                            break;
                        }
                        case 3: {
                            contato.AlterarContatos();
                            break;
                        }
                        case 4: {
                            contato.EntrarEmContato();
                            break;
                        }
                        case 5: {
                            contato.ExcluirContatos();
                            break;
                        }
                        default:
                            continue;
                    }
                } while (opcao != 0);
            }
        }
    }

