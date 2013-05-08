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
			Id : <input type="text" name="id" /> <br />
			Titular : <input type="text" name="titular" /> <br />
			Saldo : <input type="text" name="saldo" /> <br />
			Tipo : <input type="text" name="tipo" /> <br />
			<input type="hidden" name="logica" value="AlteraContaLogic" />
			<input type="submit" value="Enviar" />
		</form>
	<c:import url="rodape.jsp"/>
</body>
</html>