package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

public class ContaDAO {

	final int LIMITE_ZERO = 0;
	private Connection connection;
	final String insert = "insert into conta (titular,saldo,tipo,limite) values (?,?,?,?)";
	final String byId = "select * from conta where id = ?";
	final String deleteTitular = "delete from conta where titular = ?";
	final String delete = "delete from conta where id = ?";
	final String update = "update conta set titular = ?, saldo = ?, limite=? where id = ?";
	final String select = "select * from conta";

	public ContaDAO() {
		connection = new ConnectionFactory().getConnection(ConnectionFactory.BANCO, ConnectionFactory.USER,ConnectionFactory.PWD);
	}

	public void add(Conta conta) throws SQLException {
		PreparedStatement stms = connection.prepareStatement(insert);
		stms.setInt(1, conta.getTitular());
		stms.setDouble(2, conta.getSaldo());
		stms.setInt(3, conta.getTipo());
		if (conta.getTipo() == Conta.CONTA_CORRENTE) {
			stms.setDouble(4, ((ContaCorrente) conta).getLimite());
		} else {
			stms.setDouble(4, LIMITE_ZERO);
		}
		stms.execute();
		stms.close();
	}

	public ContaCorrente getContaCorrenteId(int id) throws SQLException {
		PreparedStatement stms = connection.prepareStatement(byId);
		stms.setInt(1, id);
		ResultSet rs = stms.executeQuery();
		rs.next();
		ContaCorrente c = new ContaCorrente(0);
		c.setId(rs.getInt("id"));
		c.setTitular(rs.getInt("titular"));
		c.setSaldo(rs.getDouble("saldo"));
		c.setTipo(rs.getInt("tipo"));
		if (c.getTipo() == Conta.CONTA_CORRENTE) {
			c.setLimite(rs.getDouble("limite"));
		}
		rs.close();
		stms.close();
		return c;
	}

	public ContaPoupanca getContaPoupancaId(int id) throws SQLException {
		PreparedStatement stms = connection.prepareStatement(byId);
		stms.setInt(1, id);
		ResultSet rs = stms.executeQuery();
		rs.next();
		ContaPoupanca c = new ContaPoupanca();
		c.setId(rs.getInt("id"));
		c.setTitular(rs.getInt("titular"));
		c.setSaldo(rs.getDouble("saldo"));
		c.setTipo(rs.getInt("tipo"));
		rs.close();
		stms.close();
		return c;
	}

	public void removeTitular(Conta conta) throws SQLException {
		PreparedStatement stms = connection.prepareStatement(deleteTitular);
		stms.setInt(1, conta.getTitular());
		stms.execute();
		stms.close();
	}

	public void remove(Conta conta) throws SQLException {
		PreparedStatement stms = connection.prepareStatement(delete);
		stms.setInt(1, conta.getId());
		stms.execute();
		stms.close();
	}

	public void update(ContaCorrente conta) throws SQLException {
		PreparedStatement smts = connection.prepareStatement(update);
		smts.setInt(1, conta.getTitular());
		smts.setDouble(2, conta.getSaldo());
		smts.setDouble(3, conta.getLimite());
		smts.setInt(4, conta.getId());
		smts.execute();
		smts.close();
	}

	public void update(ContaPoupanca conta) throws SQLException {
		PreparedStatement smts = connection.prepareStatement(update);
		smts.setInt(1, conta.getTitular());
		smts.setDouble(2, conta.getSaldo());
		smts.setDouble(3, 0); // poupanca nao tem limite
		smts.setInt(4, conta.getId());
		smts.execute();
		smts.close();
	}

	public List<Conta> getLista() throws SQLException {
		List<Conta> contas = new ArrayList<Conta>();
		PreparedStatement stmt = connection.prepareStatement(select);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			if (rs.getInt("tipo") == Conta.CONTA_CORRENTE) {
				ContaCorrente cc = new ContaCorrente(0);
				cc.setId(rs.getInt("id"));
				cc.setTitular(rs.getInt("titular"));
				cc.setSaldo(rs.getDouble("saldo"));
				cc.setLimite(rs.getDouble("limite"));
				cc.setTipo(rs.getInt("tipo"));
				contas.add(cc);
			} else {
				ContaPoupanca cp = new ContaPoupanca();
				cp.setId(rs.getInt("id"));
				cp.setTitular(rs.getInt("titular"));
				cp.setSaldo(rs.getDouble("saldo"));
				cp.setTipo(rs.getInt("tipo"));
				contas.add(cp);
			}
		}
		rs.close();
		stmt.close();
		return contas;
	}
}
