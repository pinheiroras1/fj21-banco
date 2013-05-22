package teste;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.servlet.ControllerServlet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class TestControllerServlet {
	
	@Mock private HttpServletRequest request;
	@Mock private HttpServletResponse response;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test 
	public void TestService() throws ServletException, IOException{
		when(request.getParameter("logica")).thenReturn("TesteLogic");
		ControllerServlet cs = new ControllerServlet();
		cs.service(request, response);
		
	}
	
	@Test (expected=ServletException.class) public void
	TestServiceErro() throws ServletException, IOException{
		when(request.getAttribute("logica")).thenReturn("NaoSeiALogic");
		ControllerServlet cs = new ControllerServlet();
		cs.service(request, response);
	}
	
}
