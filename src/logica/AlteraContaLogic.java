package logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conta;
import model.ContaCorrente;
import dao.ContaDAO;

public class AlteraContaLogic implements Logica{
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int tipo = Integer.parseInt(request.getParameter("tipo"));
		ContaCorrente cc = new ContaCorrente(0);
		if (tipo == Conta.CONTA_CORRENTE) {
			int id = Integer.parseInt(request.getParameter("id"));
			cc.setId(id);
			double saldo = Double.parseDouble(request.getParameter("saldo"));
			cc.setSaldo(saldo);
			int titular = Integer.parseInt(request.getParameter("titular"));			
			cc.setTitular(titular);
		}
		ContaDAO dao = new ContaDAO();
		dao.update(cc);
		
		RequestDispatcher rd = request.getRequestDispatcher("contas.jsp");
		rd.forward(request, response);
	}
}
