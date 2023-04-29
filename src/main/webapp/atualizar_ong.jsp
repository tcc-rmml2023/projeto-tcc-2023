<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
 	String erro = (String) request.getAttribute("erro");	
 %> 
<!DOCTYPE html>
<html lang="pt-br">

<!-- link head -->
<jsp:include page="cabecalho.jsp"></jsp:include>
<body>
	<!-- Topbar Start -->
	<jsp:include page="barraBotoes.jsp"></jsp:include>
	<!-- Topbar End -->
	
	<h3>Atualizar cadastro</h3>
	<form name="atualizar_ong" method="POST" action="AtualizarOngServlet">
		
		<input type="submit" type="button" class="btn btn-primary py-2 px-4" name="Salvar" value="Cadastrar">
	</form>
	<div class="container-fluid pt-5">
        <div class="d-flex flex-column text-center mb-5 pt-5">
             <a href="animais.html" class="btn btn-lg btn-secondary mt-3 mt-md-4 px-4">ADOTE</a>
        </div>
    </div>
    
    <!-- Footer Start -->
    <jsp:include page="rodape.jsp"></jsp:include>
    <!-- Footer End -->
</body>
</html>