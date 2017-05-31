package br.com.fiap.ex02;

public class Aviao extends Thread {
	private String voo;
	private Aeroporto aeroporto;
	
	public Aviao(String voo, Aeroporto aeroporto) {
		super();
		this.voo = voo;
		this.aeroporto = aeroporto;
		aeroporto.add(this);
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				decolar();
				voar();
				aterrisar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getVoo() {
		return voo;
	}

	public Aeroporto getAeroporto() {
		return aeroporto;
	}
	
	public void voar() throws InterruptedException {
		System.out.println(voo + " - Voando... ");
		Thread.sleep(2000);
	}
	
	public void decolar() throws InterruptedException {
		if(aeroporto.aguardarPistaDisponivel()) {
			synchronized (this) {
				this.wait();
			}
		}
		System.out.println(voo + " - Decolando... ");
	}
	
	public void aterrisar() throws InterruptedException {
		if(aeroporto.aguardarPistaDisponivel()) {
			synchronized (this) {
				this.wait();
			}
		}
		System.out.println(voo + " - Aterrisando... ");
	}
}
