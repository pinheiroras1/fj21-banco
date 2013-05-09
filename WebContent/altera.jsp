<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Altera conta</title>
</head>
<body> 
	<c:import url="cabecalho.jsp"/>
		<form action="mvc" method="post">
	       	
	       	<jsp:useBean id="dao" class="dao.ContaDAO"/>
	       	<jsp:useBean id="conta" class="model.Conta"/>
	       	
	       	dao.byId(param.id)
	       	
			Id : <input type="text" name="id" value="${param.id}" /> <br />
			Titular : <input type="text" name="titular" value="" /> <br />
			Saldo : <input type="text" name="saldo" value=""/> <br />
			<c:if test="${conta.tipo == 0 }">
			    Limite : <input type="text" name="limite" value=""/> <br /> 
			</c:if>
<!-- 			Tipo : <input type="text" name="tipo" /> <br /> -->
		    Tipo de Conta :
			<select name="tipo">
				<option value="0">Conta Corrente</option>
				<option value="1">Conta Poupanca</option>
				<option value="2">Conta Salario</option>
			</select>
			
			<input type="hidden" name="logica" value="AlteraContaLogic" /> <br />
			<input type="submit" value="Enviar" />
		</form>
		<br />
		<a href="contas.jsp">voltar</a> <br /> <br />
	<c:import url="rodape.jsp"/>
</body>
</html>