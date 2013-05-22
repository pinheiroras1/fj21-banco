package teste;

import model.ContaCorrente;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestContaCorrente {
	
	@Test
	public void testSaqueMaiorLimite(){
		ContaCorrente cc = new ContaCorrente(100);
		cc.deposito(400);
		assertFalse(cc.saque(600));
	}
	
	@Test
	public void testSaque(){
		ContaCorrente cc = new ContaCorrente(0);
		cc.deposito(100);
		assertTrue(cc.saque(100));
	}

}
