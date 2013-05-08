package logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conta;
import model.ContaCorrente;
import dao.ContaDAO;

public class AdicionaContaLogic implements Logica{
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
			double limite = Double.parseDouble(request.getParameter("limite"));
			cc.setLimite(limite);
			cc.setTipo(tipo);
			
		}
		ContaDAO dao = new ContaDAO();
		dao.add(cc);
		
		RequestDispatcher rd = request.getRequestDispatcher("contas.jsp");
		rd.forward(request, response);
	}
}
