package model;

public class ContaPoupanca extends Conta {
	final private double PERCENTUAL = 0.95;
	
	public ContaPoupanca(){
		this.setTipo(CONTA_POUPANCA);
	}
	
	public boolean saque(double valor) {
		if (this.saldo < valor) return false;
		else {
			this.saldo -= valor;
			return true;
		}
	}
	
	public boolean transferePara(Conta destino, double valor){
		double cincoPorcento = valor-(valor*PERCENTUAL);
		boolean retirou = this.saque(valor+cincoPorcento);
		if (retirou) destino.deposito(valor);
		return retirou;
	}

}
