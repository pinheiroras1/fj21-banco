package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.ContaDAO;

public class testContaDAO {
	
	private ContaCorrente cc;
	private ContaPoupanca cp;
	private ContaDAO dao;
	
	@Before
	public void setUp(){
		dao = new ContaDAO();
		cc = new ContaCorrente(0);
		cp = new ContaPoupanca();
	}
	
	@After
	public void tearDown(){
		dao = null;
		cc = null;
		cp = null;
	}
	
	@Test
	public void testConexao(){
		assertNotNull(new ConnectionFactory().getConnection());
	}
	
	@Test
	public void testAddContaCorrente(){
		cc.setTitular(1);
		cc.setSaldo(500);
		cc.setLimite(100);
		dao.add(cc);
	}
	
	@Test
	public void testAddContaPoupanca(){
		cp.setTitular(2);
		cp.setSaldo(400);
		dao.add(cp);
	}
	
	@Test
	public void testRemove(){
		cc.setTitular(2);
		dao.remove(cc);
	}
	
	@Test
	public void testbyIdContaCorrente(){
		cc.setId(7);
		cc.setLimite(100);
		dao.update(cc);
		cc = dao.getContaCorrenteId(7);
		assertEquals(0,cc.getTitular());
		assertEquals(Conta.CONTA_CORRENTE,cc.getTipo());
		assertEquals(100, cc.getLimite(),00001);
	}
	
	@Test
	public void testAtualizaContaCorrente(){
		cc.setTitular(1);
		cc.setLimite(200);
		cc.setId(7);
		dao.update(cc);
		cc = dao.getContaCorrenteId(7);
		assertEquals(200, cc.getLimite(),00001);
		
	}
	
	@Test
	public void testLista(){
		List <Conta> lista = new ArrayList<Conta>();
		lista = dao.getLista();
		assertEquals(0,lista.get(0).getSaldo(),0001);
	}
}