import java.util.Scanner;

import javax.xml.transform.OutputKeys;

public class TesteDAO {
    public static void main(String[] args) {
        var opts = 0;
        PessoaDAO PessoasCadastro = new PessoaDAO();
        Scanner reader = new Scanner(System.in);

        int qtsPessoa = 0;

        PessoasCadastro.InicializarVetorPessoas(100);
        
        while (opts != 6) {
            System.out.println("""
                \n*** Bem Vindo ao Sistema ***
                1. Inserir
                2. Buscar 
                3. Relatório
                4. Remover
                5. Alterar
                6. Sair
                ****************************""");
        
            opts = reader.nextInt();
            switch (opts) {
                case 1:
                    System.out.println("Digite o nome da pessoa para cadastrar: ");
                    var nomePessoa = reader.next();
                    
                    System.out.println("Digite o id da pessoa ao ser cadastrada: ");
                    var idPessoa = reader.nextInt();

                    System.out.println("Digite o email da pessoa ao ser cadastrado: ");
                    var emailPessoa = reader.next();

                    var pessoaCadastrada = new Pessoa(idPessoa, nomePessoa ,emailPessoa);

                    qtsPessoa++;
                    PessoasCadastro.cadastrarPessoa(pessoaCadastrada);

                    break;

                case 2:
                    System.out.println("Digite o email da pessoa ao ser buscado: ");

                    var emailPessoaBuscar = reader.next();
                    var pessoaBuscada = PessoasCadastro.buscarPessoa(emailPessoaBuscar);
                    
                    if (pessoaBuscada == null) {
                        System.out.println("\nNão encontrado!");

                    } else if (pessoaBuscada != null) {
                        System.out.println("\nNome: " + pessoaBuscada.toString());
                        System.out.println("============================");
                    }

                    break;
                    
                case 3:
                    Pessoa[] pessoas = PessoasCadastro.GetPessoa();

                    for (int i = 0; i < qtsPessoa; i++) {
                        System.out.println(pessoas[i].toString());
                    }            
                    System.out.println("============================");

                    break;

                case 4:
                    System.out.println("Digite o email da pessoa ao ser buscado: ");

                    var emailPessoaBusca = reader.next();
                    var pessoaBusca = PessoasCadastro.buscarPessoa(emailPessoaBusca);
                    
                    if (pessoaBusca == null) {
                        System.out.println("\nNão encontrado!");
                    } else if (pessoaBusca != null) {
                        qtsPessoa--;
                        PessoasCadastro.removerPessoa(pessoaBusca);
                    }
                    break;

                case 5:
                    System.out.println("Digite o email da pessoa ao ser buscado: ");

                    var emailPessoaBusca5 = reader.next();
                    var pessoaBusca5 = PessoasCadastro.buscarPessoa(emailPessoaBusca5);
                    
                    if (pessoaBusca5 == null) {
                        System.out.println("\nNão encontrado!");
                    } else if (pessoaBusca5 != null) {
                        PessoasCadastro.alterarPessoa(pessoaBusca5);
                    }
                    break;

                case 6:
                    break;
                default:
                System.out.println("Opção não disponivel!");
                    break;
            }
        }
        
        reader.close();
    }
}
