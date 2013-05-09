package mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conta;
import dao.ContaDAO;

public class RemoveContaLogic implements Logica {

	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ContaDAO dao = new ContaDAO();
		Conta c = new Conta();
		int id = Integer.parseInt(request.getParameter("id"));
		c.setId(id);
		dao.remove(c);
		
		RequestDispatcher rd = request.getRequestDispatcher("/contas.jsp");
		rd.forward(request, response);	
	}
}

