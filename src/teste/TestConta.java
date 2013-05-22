package teste;

import org.junit.Test;

import model.ContaCorrente;
import model.ContaPoupanca;

public class TestConta {
	
	@Test
	public void testDepositoZero(){
		ContaCorrente cc = new ContaCorrente(0);
		cc.deposito(0);	
	}
	
	@Test
	public void testDepositoConta(){
		ContaPoupanca cp = new ContaPoupanca();
		cp.deposito(300);
	}
}
