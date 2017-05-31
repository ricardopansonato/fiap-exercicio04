package br.com.fiap.ex03;

import java.util.Arrays;

public class Exercicio03 {
	public static void main(String[] args) {
		Arrays.asList(Cores.class.getEnumConstants()).forEach(c -> {
			System.out.println(c.toString());
		});
		System.out.println("************");
		System.out.println(Cores.BRANCO);
	}
}
