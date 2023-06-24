import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Quantas pessoas deseja cadastrar: ");

        int quantidadePessoa = reader.nextInt();
        boolean encontrado = false;

        Pessoa[] Pessoas = new Pessoa[quantidadePessoa];

        for (int i = 0; i < Pessoas.length; i++) {

            System.out.println("Digite o id da pessoa " + i + ":");
            int idPessoa = reader.nextInt();

            System.out.println("Digite o email da pessoa " + i + ":");
            String emailPessoa = reader.next();

            System.out.println("Digite o nome da pessoa " + i + ": ");
            String nomePessoa = reader.next();

            Pessoa p = new Pessoa(idPessoa, nomePessoa, emailPessoa);
            Pessoas[i] = p;
        }

        System.out.println("Digite um email para a procura:");
        String emailProcura = reader.next();

        for (Pessoa pessoa : Pessoas) {
            if (pessoa.getEmail().equals(emailProcura)) {

                System.out.println("Pessoa encontrada!");
                System.out.println(pessoa.toString());

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Email não encontrado!");
        }

        for (Pessoa pessoa : Pessoas) {
            System.out.println(pessoa.toString());
        }

        reader.close();
    }
}