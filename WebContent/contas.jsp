<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Contas</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<br />
	<a href="adiciona.jsp">Cadastrar</a>
	<jsp:useBean id="dao" class="dao.ContaDAO" />
	<table border="1">
		<tr>
			<td>Conta</td><td>Titular</td><td>Saldo</td><td>Limite</td><td>Tipo</td><td>Ações</td>
		</tr>
		<c:forEach var="conta" items="${dao.lista}" varStatus="id">
			<tr bgcolor="${id.count % 2 == 0 ? 'aaee88' : 'ffffff'} ">
				<td>${conta.id}</td>
				<td>${conta.titular}</td>
				<td>${conta.saldo}</td> 
				<td>
<%-- 				    <c:if test="${conta.class == 'class model.ContaCorrente'}">${conta.limite}</c:if> --%>
				    ${ (conta.class == 'class model.ContaCorrente') ? conta.limite : '0' } 
				</td> 
				<td>
				    ${ (conta.tipo == '0') ? 'CC' : 'CP'}
				</td>
				<td>
					<a href="mvc?logica=RemoveContaLogic&id=${conta.id}"> Excluir </a>
					<a href="altera.jsp?id=${conta.id}"> Alterar </a>
				</td>
			</tr>
		</c:forEach>
	</table>
	* CC = ContaCorrente <br />
	  CP = ContaPoupanca <br /><br /><br />
	<c:import url="rodape.jsp" />
</body>
</html>