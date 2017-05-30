package br.com.fiap.ex02;

public class Exercicio02 {
	public static void main(String[] args) {
		Aeroporto aeroporto = new Aeroporto("GRU");
		Aviao aviao1 = new Aviao("TAN 123", aeroporto);
		Aviao aviao2 = new Aviao("OLÉ 111", aeroporto);
		Aviao aviao3 = new Aviao("LINHA 222", aeroporto);
		
		aeroporto.start();
		
		aviao1.start();
		aviao2.start();
		aviao3.start();
	}
}
