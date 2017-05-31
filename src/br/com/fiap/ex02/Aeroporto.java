package br.com.fiap.ex02;

import java.util.ArrayList;
import java.util.List;

public class Aeroporto extends Thread {
	private List<Aviao> avioes = new ArrayList<>();
	private boolean aguardarPistaDisponivel = false; 
	private String nomeAeroporto;
	
	public Aeroporto(String nomeAeroporto) {
		this.nomeAeroporto = nomeAeroporto;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
				alterarEstadoPista();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void alterarEstadoPista() {
		this.aguardarPistaDisponivel = !aguardarPistaDisponivel;
		System.out.println("********************************");
		System.out.println(!aguardarPistaDisponivel ? nomeAeroporto + " permite decolar/aterrisar" : nomeAeroporto + " não permite decolar/aterrisar");
		if (!aguardarPistaDisponivel) {
			avioes.forEach(a -> {
				synchronized (a) {
					a.notify();
				}
			});
		}
		avioes.forEach(a -> { System.out.println(a.getVoo() + " - " + a.getState()); });
	}
	
	public boolean aguardarPistaDisponivel() {
		return aguardarPistaDisponivel;
	}

	public String getNomeAeroporto() {
		return nomeAeroporto;
	}
	
	public void add(Aviao aviao) {
		this.avioes.add(aviao);
	}
}
