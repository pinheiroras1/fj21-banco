package mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import dao.ContaDAO;

public class AdicionaContaLogic implements Logica{
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int tipo = Integer.parseInt(request.getParameter("tipo"));
		ContaCorrente cc = new ContaCorrente(0);
		ContaPoupanca cp = new ContaPoupanca();
		ContaDAO dao = new ContaDAO();
		//TODO
		double saldo = Double.parseDouble(request.getParameter("saldo"));
		int titular = Integer.parseInt(request.getParameter("titular"));			
		double limite = Double.parseDouble(request.getParameter("limite"));
		
		if (tipo == Conta.CONTA_CORRENTE) {
			cc.setSaldo(saldo);
			cc.setTitular(titular);
			cc.setLimite(limite);
			cc.setTipo(tipo);
			dao.add(cc);
		}
		else {
			cp.setSaldo(saldo);
			cp.setTitular(titular);
			cp.setTipo(tipo);
			dao.add(cp);
		}
		RequestDispatcher rd = request.getRequestDispatcher("contas.jsp");
		rd.forward(request, response);
	}
}
