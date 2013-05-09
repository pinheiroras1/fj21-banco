<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adiciona conta</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>	    
		<form action="mvc" method="post">
			Titular : <input type="text" name="titular" /> <br />
			Saldo : <input type="text" name="saldo" /> <br />
			Limite : <input type="text" name="limite" /> <br />
<!-- 			Tipo : <input type="text" name="tipo" /> <br /> -->
            Tipo de Conta :
			<select name="tipo">
				<option value="0">Conta Corrente</option>
				<option value="1" selected="selected">Conta Poupanca</option>
				<option value="2">Conta Salario</option>
			</select>
			<br />
			<input type="hidden" name="logica" value="AdicionaContaLogic" /> <br />
			<input type="submit" value="Enviar" />
		</form>
		<br />
		<a href="contas.jsp">voltar</a> <br />
	<c:import url="rodape.jsp"/>
</body>
</html>