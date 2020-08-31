package br.com.tqi.analisedecredito.main;

import br.com.tqi.analisedecredito.conta.Cliente;
import br.com.tqi.analisedecredito.analise.Analisando;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		List<Cliente> listaCliente = new ArrayList<>();
		Scanner ler = new Scanner(System.in);

		int op = 0;

		while (op != 4) {
			System.out.print("\n\n******* TQI BANK *******");
			System.out.print("\n1 - Cadastrar");
			System.out.print("\n2 - Login");
			System.out.print("\n4 - Sair");

			System.out.print("\nSelecione a opcao desejada: ");
			op = ler.nextInt();

			switch (op) {
			case 1: {
				// CHAMA O METODO DE CADASTRO
				servicoCadastrarCliente(listaCliente);

				break;
			}

			case 2: {
				// CHAMA O METODO DE LOGIN

				servicoLogin(listaCliente);

				break;
			}

			default: {
				System.out.print("\n *** Sistema Finalizado ***");
				break;
			}
			}
		}
	}

	// *** Inicio do cadastro do cliente e da verificação ***//
	public static void servicoCadastrarCliente(List<Cliente> listaCliente) {

		Scanner ler = new Scanner(System.in);

		System.out.print("\nDigite seu NOME COMPLETO: ");
		String nome = ler.nextLine();

		System.out.print("Digite seu CPF: ");
		String cpf = ler.nextLine();

		System.out.print("Digite a DATA de Nascimento: ");
		String dataNasc = ler.nextLine();

		System.out.print("Digite o seu ENDERECO: ");
		String endereco = ler.nextLine();

		System.out.print("Digite o NUMERO do seu Telefone: ");
		String numTelefone = ler.nextLine();

		System.out.print("Digite o seu EMAIL: ");
		String email = ler.nextLine();

		System.out.print("\nPOR FAVOR DIGITE O TOTAL DA RENDA QUE VOCÊ GANHA\n");

		System.out.print("Digite o valor da sua RENDA: ");
		double renda = ler.nextInt();

		System.out.print("Digite uma SENHA: ");
		String senha = ler.next();

		Boolean cpfValido = validaCPF(cpf);
		if (cpfValido != true) {
			System.out.print("\n**** CPF NÃO CONTÉM 11 DIGITOS ****\n");
		}

		Boolean cpfCadastrado = verificaCadastro(cpf, listaCliente);
		if (cpfCadastrado != false) {
			System.out.print("\n**** CPF JÁ CADASTRADO ****\n");
		}

		if (cpfValido == true && cpfCadastrado == false) {
			listaCliente.add(new Cliente(nome, cpf, dataNasc, endereco, numTelefone, email, renda, senha));
			System.out.print("\n**** Cadastro Realizado ****\n");
		} else {
			System.out.print("\n**** Cadastro Contém Erros ****");
		}

	}

	public static Boolean validaCPF(String cpf) {

		if (cpf.length() == 11) {
			return true;
		}
		return false;
	}

	public static Boolean verificaCadastro(String cpf, List<Cliente> listaCliente) {

		for (int i = 0; i < listaCliente.size(); i++) {

			if (cpf.equals(listaCliente.get(i).getCpf())) {
				return true;
			}
		}
		return false;
	}
	// *** Fim do cadastro do cliente e da verificação *** //

	// *** Inicio do login e da verificação *** //
	public static void servicoLogin(List<Cliente> listaCliente) {

		Scanner ler1 = new Scanner(System.in);

		System.out.print("\nInsira seu CPF para logar: ");
		String cpfLogin = ler1.nextLine();

		System.out.print("Digite sua SENHA: ");
		String senhaLogin = ler1.nextLine();

		Boolean lg = verificaLogin(cpfLogin, senhaLogin, listaCliente);

		if (lg != true) {
			System.out.print("\n\n*** Acesso Negado, CPF/Senha incorretos ou não encontrados ***");
		} else {
			System.out.print("\n\n*** Seja bem vindo ***");
			servicoMenuEmprestimo(cpfLogin, listaCliente);
		}
	}

	public static Boolean verificaLogin(String cpfLogin, String senhaLogin, List<Cliente> listaCliente) {
		for (int i = 0; i < listaCliente.size(); i++) {

			if (cpfLogin.equals(listaCliente.get(i).getCpf()) && senhaLogin.equals(listaCliente.get(i).getSenha())) {
				if (cpfLogin.length() == 11) {
					return true;
				}
			}
		}
		return false;
	}
	// *** Fim do login e da verificação *** //

	// *** Inicio da solicitação do emprestimo e verificação *** //

	public static void servicoMenuEmprestimo(String cpf, List<Cliente> listaCliente) {

		List<Analisando> listaAnalise = new ArrayList<>();
		Scanner ler2 = new Scanner(System.in);

		int op2 = 0;

		while (op2 != 4) {

			System.out.print("\n1 - Solicitar Emprestimo");
			System.out.print("\n2 - Acompanhar Emprestimo");
			System.out.print("\n4 - Voltar");
			System.out.print("\nDigite a opção: ");
			op2 = ler2.nextInt();

			switch (op2) {
			case 1: {
				// Chama o Método Solicitar Emprestimo
				servicoSolicitarEmprestimo(cpf, listaAnalise);
				break;
			}
			case 2: {
				servicoAcompanhaEmprestimo(cpf, listaAnalise, listaCliente);
				break;
			}
			}
		}
	}

	public static void servicoSolicitarEmprestimo(String cpf, List<Analisando> listaAnalise) {

		Scanner ler3 = new Scanner(System.in);

		double valorEmprestimo;
		double juros;
		int numParcelas = 0;

		double resultadoJuros;
		double resultadoTotal;
		double parcelas;

		System.out.print("\nDigite o valor que deseja pegar no empréstimo: ");
		valorEmprestimo = ler3.nextDouble();

		System.out.print("Digite o numero de parcelas: ");
		numParcelas = ler3.nextInt();

		System.out.print("Digite o valor dos juros: ");
		juros = ler3.nextDouble();

		if (numParcelas < 1 || numParcelas > 60) {
			System.out.print("\n O numero de parcelas não pode ser menor que 0 e nem maior que 60\n");

			System.out.print("Digite o numero de Parcelas: ");
			numParcelas = ler3.nextInt();
		}

		juros = juros / 100;

		resultadoJuros = valorEmprestimo * juros * numParcelas;

		resultadoTotal = resultadoJuros + valorEmprestimo;

		parcelas = (resultadoJuros + valorEmprestimo) / numParcelas;

		System.out.printf(
				"\n\n\nO valor TOTAL é de R$ %.2f com parcelas de R$ %.2f, o valor dos juros dentro de %d meses é de R$ %.2f\n",
				resultadoTotal, parcelas, numParcelas, resultadoJuros);

		listaAnalise.add(new Analisando(cpf, parcelas));

	}

	public static void servicoAcompanhaEmprestimo(String cpfAtual, List<Analisando> listaAnalise,
			List<Cliente> listaCliente) {

		String nome;

		for (Analisando item : listaAnalise) {
			if (item.getCpf().equals(cpfAtual)) {
				Cliente cliente = pegaCliente(cpfAtual, listaCliente);
				nome = cliente.getNomeCompleto();
				double rendaAtual = cliente.getRenda();
				double parcela = item.getParcela();

				rendaAtual = rendaAtual * 0.35;

				if (parcela > rendaAtual) {
					System.out.printf(
							"\nO valor da parcela é maior que os 35 porcento que é permitido para o empréstimo ser aprovado.\n");
					System.out.printf("\nValor da parcela: %.2f", parcela);
					System.out.printf("\nValor máximo que você pode pagar de parcela: %.2f", rendaAtual);
				} else {
					System.out.print("\nO Valor solicitado para emprestimo foi aprovado.\n");
				}
			}
		}
	}

	private static Cliente pegaCliente(String cpfAtual, List<Cliente> listaCliente) {
		for (Cliente item : listaCliente) {
			if (item.getCpf().equals(cpfAtual)) {
				return item;
			}
		}
		return null;
	}
}
