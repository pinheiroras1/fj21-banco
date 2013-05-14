package mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import dao.ContaDAO;

public class DadosContaLogic implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ContaDAO dao = new ContaDAO();

		int id = Integer.parseInt(request.getParameter("id"));
		int tipo = Integer.parseInt(request.getParameter("tipo"));
		if (tipo == Conta.CONTA_CORRENTE) {
			ContaCorrente cc;
			cc = dao.getContaCorrenteId(id);
			request.setAttribute("conta", cc);
		} else {
			ContaPoupanca cp;
			cp = dao.getContaPoupancaId(id);
			request.setAttribute("conta", cp);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/adiciona.jsp");
		rd.forward(request, response);

	}

}
