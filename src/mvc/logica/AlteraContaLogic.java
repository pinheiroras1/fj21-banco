package mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import dao.ContaDAO;

public class AlteraContaLogic implements Logica{
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int tipo = Integer.parseInt(request.getParameter("tipo"));
		ContaCorrente cc = new ContaCorrente(0);
		ContaPoupanca cp = new ContaPoupanca();
		ContaDAO dao = new ContaDAO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		int titular = Integer.parseInt(request.getParameter("titular"));
		double saldo = Double.parseDouble(request.getParameter("saldo"));
		double limite = Double.parseDouble(request.getParameter("limite"));
		
		if (tipo == Conta.CONTA_CORRENTE) {
			cc.setId(id);			
			cc.setSaldo(saldo);						
			cc.setTitular(titular);
			cc.setLimite(limite);
			dao.update(cc);
		}
		else {
			cp.setId(id);
			cp.setTipo(titular);
			cp.setSaldo(saldo);
			dao.update(cp);
		}
		RequestDispatcher rd = request.getRequestDispatcher("contas.jsp");
		rd.forward(request, response);
	}
}

