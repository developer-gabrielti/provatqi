package br.com.tqi.analisedecredito.conta;

public class Cliente {

	// Atributos

	private String nomeCompleto;
	private String cpf;
	private String dataNascimento;
	private String endereco;
	private String numTelefone;
	private String email;
	private double salario;
	private String senha;

	/**** Métodos Construtores ****/

	public Cliente() {

	}

	public Cliente(String nomeCompleto, String cpf, String dataNascimento, String endereco, String numTelefone,	String email, double salario, String senha) {
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.numTelefone = numTelefone;
		this.email = email;
		this.salario = salario;
		this.senha = senha;
	}

	/*** GETS SETS ***/

	public void setNomeCompleto(String nomeCompleto) {

		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeCompleto() {

		return nomeCompleto;
	}

	public void setCpf(String cpf) {

		this.cpf = cpf;
	}

	public String getCpf() {

		return cpf;
	}

	public void setDataNascimento(String dataNascimento) {

		this.dataNascimento = dataNascimento;
	}

	public String getDataNascimento() {

		return dataNascimento;
	}

	public void setEndereco(String endereco) {

		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setNumTelefone(String numTelefone) {

		this.numTelefone = numTelefone;
	}

	public String getNumTelefone() {

		return numTelefone;
	}

	public void setRenda(double salario) {

		this.salario = salario;
	}

	public double getRenda() {

		return salario;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getEmail() {

		return email;
	}

	public void setSenha(String senha) {

		this.senha = senha;
	}

	public String getSenha() {

		return senha;
	}

}
