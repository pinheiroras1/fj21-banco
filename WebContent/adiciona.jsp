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
		 
		    Id : <input type="text" name="id" readonly="readonly" value="<c:out value="${conta.id}" />" /><br /> 
			Titular : <input type="text" name="titular" value="${conta.titular}" /> <br />
			Saldo : <input type="text" name="saldo" value="${conta.saldo}" /> <br />
			Limite : <input type="text" name="limite" value="${ (conta.tipo == 0) ? conta.limite : '0' }"  ${ (conta.tipo ==1) ? 'readonly' : '' } /> <br />
<!-- 			Tipo : <input type="text" name="tipo" /> <br /> -->
            Tipo de Conta :
			<select name="tipo" >
				<option value="0" ${ (conta.tipo == 0) ? 'selected' : '' }>Conta Corrente</option>
				<option value="1" ${ (conta.tipo == 1) ? 'selected' : '' }>Conta Poupanca</option>
			</select>
			<br />
			<br />
			<input type="hidden" name="logica" value="${ (conta.id == null) ? 'AdicionaContaLogic' : 'AlteraContaLogic'}" /> <br />
			<input type="submit" value="Enviar" />
		</form>
		<br />
		<a href="contas.jsp">voltar</a> <br />
	<c:import url="rodape.jsp"/>
</body>
</html>