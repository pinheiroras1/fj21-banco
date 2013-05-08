package teste;

import static org.junit.Assert.assertEquals;
import model.Cliente;
import model.ContaCorrente;
import model.ContaPoupanca;

import org.junit.Test;

public class testeBanco {

	@Test
	public void testContaSimples() {
		Cliente cliente = new Cliente("61732494304","Pinheiro");
		assertEquals("Pinheiro", cliente.getNome());
		cliente.setCpf("111");
		cliente.setNome("jose");
		assertEquals("111", cliente.getCpf());
		assertEquals("jose", cliente.getNome());
	}

	@Test
	public void testContaCorrenteSaqueInvalido() {
		ContaCorrente c = new ContaCorrente(100);
		c.deposito(500);
		assertEquals(false,c.saque(700));
	}
	
	@Test
	public void testContaPoupancaSaqueInvalido(){
		ContaPoupanca p = new ContaPoupanca();
		p.deposito(400);
	    assertEquals(false,p.saque(500));
	}
	
	@Test
	public void testContaCorrenteSaque(){
		ContaCorrente c = new ContaCorrente(100);
		c.deposito(400);
		assertEquals(400.0, c.getSaldo(),00001);
		c.saque(300);
		assertEquals(100, c.getSaldo(),00001);
	}
	
	@Test
	public void testContaCorrenteSaqueLimite(){
		ContaCorrente c = new ContaCorrente(100);
		c.deposito(400);
		c.saque(500);
		assertEquals(-100, c.getSaldo(),00001);
	}
	
	@Test
	public void testContaPoupancaSaque(){
		ContaPoupanca p = new ContaPoupanca();
		p.deposito(350);
		assertEquals(350.0,p.getSaldo(),00001);
		p.saque(200);
		assertEquals(150,p.getSaldo(),00001);
	}
	
	@Test
	public void testContaCorrenteTransferencia(){
		ContaCorrente c = new ContaCorrente(100);
		ContaCorrente b = new ContaCorrente(100);
		c.deposito(1200);
		c.transferePara(b, 200);
		assertEquals(1000L,c.getSaldo(),00001);
		assertEquals(200L,b.getSaldo(),00001);
	}
	
	@Test
	public void testContaPoupancaTransferencia(){
		ContaPoupanca p = new ContaPoupanca();
		ContaPoupanca t = new ContaPoupanca();
		p.deposito(400);
		p.transferePara(t, 300);
		assertEquals(85,p.getSaldo(),00001);
		assertEquals(300,t.getSaldo(),00001);
		
	}
	
	@Test
	public void testContaTransferenciaErro(){
		ContaCorrente a = new ContaCorrente(100);
		ContaCorrente b = new ContaCorrente(100);	
		a.deposito(450);
		assertEquals(false,a.transferePara(b, 600));
		
	}
	
	
}
