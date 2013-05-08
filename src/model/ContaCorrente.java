package model;

public class ContaCorrente extends Conta{
	private double limite;
	
	public ContaCorrente(double limite){
		this.limite = limite;
		this.setTipo(CONTA_CORRENTE);
	}
	
	public boolean saque(double valor) {
		if ((this.saldo+this.limite) < valor) return false;
		else {
			this.saldo -= valor;
			return true;
		}
	}
	
	public boolean transferePara(Conta destino, double valor){
		boolean retirou = this.saque(valor);
		if (retirou) destino.deposito(valor);
		return retirou;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

}
