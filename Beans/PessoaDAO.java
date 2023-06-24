import java.security.cert.TrustAnchor;
import java.util.Scanner;

public class PessoaDAO {
    Pessoa[] _ArrayDPessoas;
    int quantidadePessoas;
    int quantidadePessoasCadastrada;

    Scanner reader = new Scanner(System.in);

    // Método de Iniciar o vetor de array
    public void InicializarVetorPessoas(int quantidade) {
        _ArrayDPessoas = new Pessoa[quantidade];
        quantidadePessoas = quantidade;
        quantidadePessoasCadastrada = 0;
    }

    // Método de cadastrar uma pessoa na lista _ArrayDPessoas
    public void cadastrarPessoa(Pessoa pessoaCadastrar) {
        _ArrayDPessoas[quantidadePessoasCadastrada] = pessoaCadastrar;
        quantidadePessoasCadastrada ++;
    }

    // Método de buscar uma pessoa atráves do email cadastrado
    public Pessoa buscarPessoa(String email) {
        Pessoa pessoaEncontrada = null;
        var pessoas = _ArrayDPessoas;

        for (int i = 0; i < quantidadePessoasCadastrada; i++) {
            if (pessoas[i].getEmail().equals(email)) {
                pessoaEncontrada = pessoas[i];
                break;
            }   
        }

        return pessoaEncontrada;
    }

    // Método de remover pessoa
    public void removerPessoa(Pessoa pessoaRemover) {
        int posicaoPessoa = -1;

        for (int i = 0; i < quantidadePessoasCadastrada; i++) {
            if (pessoaRemover == _ArrayDPessoas[i]) {
                posicaoPessoa = i;
                break;
            }
        }

        for (int i = posicaoPessoa; i < quantidadePessoasCadastrada; i++) {
            _ArrayDPessoas[i] = _ArrayDPessoas[i+1];
        }

        if (posicaoPessoa != -1) {
            System.out.println("Pessoa Removida com sucesso!");
            quantidadePessoasCadastrada--;
        } else {
            System.out.println("Pessoa não encontrada!");
        }
    }

    // Método de alterar pessoa
    public void alterarPessoa(Pessoa pessoaAlterar) {
        boolean pessoaEncontradaAlterar = false;
        for (int i = 0; i < _ArrayDPessoas.length; i++) {
            if (pessoaAlterar == _ArrayDPessoas[i]) {
                System.out.println("Digite o nome da pessoa a ser alterado: ");
                String nome = reader.next();

                System.out.println("Digite o email da pessoa a ser alterado: ");
                String email = reader.next();

                System.out.println("Digite o id da pessoa a ser alterado: ");
                int id = reader.nextInt();

                pessoaAlterar.setNome(nome);
                pessoaAlterar.setEmail(email);
                pessoaAlterar.setId(id);

                System.out.println("Pessoa foi alterado com sucesso para: \n" + pessoaAlterar.toString());
                pessoaEncontradaAlterar = true;
            }
        }

        if (!pessoaEncontradaAlterar) {
            System.out.println("Pessoa não encontrada!");
        }
    }

    // Métodos de get e sets dos atributos de [QuantidadePessoasCadastrada, Pessoa]

    public int getQuantidadePessoasCadastrada() {
        return quantidadePessoasCadastrada;
    }


    public void setQuantidadePessoasCadastrada(int quantidadePessoasCadastrada) {
        this.quantidadePessoasCadastrada = quantidadePessoasCadastrada;
    }


    public Pessoa[] GetPessoa() {

        return _ArrayDPessoas;
    }


    public void SetPessoa(int IndicePessoa, Pessoa pessoaCadastrar) {
        if (quantidadePessoas < IndicePessoa) {
            System.out.println("Desculpa, mas o indice indicado não está disponivel");

        } else {
            _ArrayDPessoas[IndicePessoa] = pessoaCadastrar;
        }
    }
}   
