package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
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

import static org.mockito.Mockito.*;

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
		assertNotNull(new ConnectionFactory().getConnection(ConnectionFactory.BANCO,ConnectionFactory.USER,ConnectionFactory.PWD));
	}
	
	@Test(expected=RuntimeException.class)
	public void testErroConexao(){
		new ConnectionFactory().getConnection(ConnectionFactory.BANCO,ConnectionFactory.USER,"rooot");
	}
	
	@Test
	public void testAddContaCorrente() throws SQLException{
		cc.setTitular(1);
		cc.setSaldo(500);
		cc.setLimite(100);
		dao.add(cc);
	}
	
	@Test
	public void testAddContaPoupanca() throws SQLException{
		cp.setTitular(2);
		cp.setSaldo(400);
		dao.add(cp);
	}
	
	
	@Test
	public void testRemove() throws SQLException{
		cc.setTitular(2);
		dao.remove(cc);
	}
	
	@Test
	public void testbyIdContaCorrente() throws SQLException{
		cc.setId(7);
		cc.setLimite(100);
		dao.update(cc);
		cc = dao.getContaCorrenteId(7);
		assertEquals(0,cc.getTitular());
		assertEquals(Conta.CONTA_CORRENTE,cc.getTipo());
		assertEquals(100, cc.getLimite(),00001);
	}
	
	
	@Test
	public void testAtualizaContaCorrente() throws SQLException{
		cc.setTitular(1);
		cc.setLimite(200);
		cc.setId(7);
		dao.update(cc);
		cc = dao.getContaCorrenteId(7);
		assertEquals(200, cc.getLimite(),00001);
		
	}

	@Test
	public void testAtualizaContaPoupanca() throws SQLException{
		cp.setTitular(1);
		cp.setId(13);
		cp.setSaldo(700);
		dao.update(cp);
		cp = dao.getContaPoupancaId(13);
		assertEquals(700, cp.getSaldo(),00001);
	}
	
	@Test
	public void testLista() throws SQLException{
		List <Conta> lista = new ArrayList<Conta>();
		lista = dao.getLista();
		assertEquals(0,lista.get(0).getSaldo(),0001);
	}
	
	@Test
	public void testRemoveTitular() throws SQLException{
		cc.setTitular(17);
		dao.removeTitular(cc);
	}
}