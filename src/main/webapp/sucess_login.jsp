<%@page import="br.com.animalcare.dao.DaoPet"%>
<%@page import="br.com.animalcare.bean.Ong"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String msg = (String) request.getAttribute("msg");
%>

<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<jsp:include page="cabecalho.jsp"></jsp:include>

<body>

	<!-- Topbar Start -->
    <jsp:include page="barraBotoesOng.jsp"></jsp:include>
    <!-- Topbar End -->
	
	<h3>Login realizado com sucesso!</h3>
	<a> 
		<%
 			Ong ong = (Ong) session.getAttribute("usuarioLogado");
 			if (ong.getEmail() != null) {
 				out.print(ong.getEmail());
 				}
		 %>
	</a>

	<!-- Footer Start -->
    <jsp:include page="rodape.jsp"></jsp:include>
    <!-- Footer End -->
</body>
</html>