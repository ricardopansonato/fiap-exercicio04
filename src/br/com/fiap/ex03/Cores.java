package br.com.fiap.ex03;

public enum Cores {
	BRANCO(21, "Branco"),
	PRETO(22, "Preto"),
	VERMELHO(23, "Vermelho"),
	AMARELO(24, "Amarelo"),
	AZUL(25, "Azul");
	
	private Integer codigo;
	private String cor;
	
	private Cores(Integer codigo, String cor) {
		this.codigo = codigo;
		this.cor = cor;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public String getCor() {
		return cor;
	}
	
	@Override
	public String toString() {
		return this.codigo + " - " + this.cor;
	}
}