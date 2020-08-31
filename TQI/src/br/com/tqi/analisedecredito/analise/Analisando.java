package br.com.tqi.analisedecredito.analise;

public class Analisando {

	private String cpf;
	private double valorParcela;
	
	
	public Analisando(String cpf, double valorParcela) {
		this.cpf = cpf;
		this.valorParcela = valorParcela;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setParcela(double valorParcela) {
		this.valorParcela = valorParcela;
	}
	
	public double getParcela() {
		return valorParcela;
	}
	
}
