<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String msg = (String) request.getAttribute("msg");
%>

<!DOCTYPE html>
<html lang="pt-br">

<!-- link head -->
<jsp:include page="cabecalho.jsp"></jsp:include>
<body>

<!-- Topbar Start -->
<jsp:include page="barraBotoes.jsp"></jsp:include>
<!-- Topbar End -->  
     <div class="row py-5"> 

	<h1>Faça seu login</h1>
	<form method="POST" action="LoginOngServlet">
		<p>
			<label>E-mail</label> <input type="email" name="email" />
		</p>
		
		<p>
			<label>Senha</label> <input type="password" name="senha" />
		</p>
		
		<input type="submit" value="Entrar" />
		
		<div>${msg}</div>

	</form>
	</div>
	<div class="container-fluid pt-5"></div>
	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script src="./resources/lib/easing/easing.min.js"></script>
	<script src="./resources/lib/owlcarousel/owl.carousel.min.js"></script>
	<script src="./resources/lib/tempusdominus/js/moment.min.js"></script>
	<script src="./resources/lib/tempusdominus/js/moment-timezone.min.js"></script>
	<script
		src="./resources/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

	<!-- Contact Javascript File -->
	<script src="./resources/mail/jqBootstrapValidation.min.js"></script>
	<script src="./resources/mail/contact.js"></script>

	<!-- Template Javascript -->
	<script src="./resources/js/main.js"></script>
	
<!-- Footer Start -->
<jsp:include page="rodape.jsp"></jsp:include>   
<!-- Footer End -->
</body>
</html>