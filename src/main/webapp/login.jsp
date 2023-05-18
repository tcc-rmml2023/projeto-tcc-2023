<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="pt-br">

<!-- link head -->
<%@include file="cabecalho.jsp"%>
<body>

<!-- Topbar Start --> 

<%@include file="barraBotoes.jsp"%> 
    
<!-- Topbar End -->  
	<div class="container py-5">
        <div class="row py-5">
            <div class="col-lg-7 pb-5 pb-lg-0 px-3 px-lg-5">
                <h2 class="text-secondary mb-3">Faça seu login</h2> 
                	<form method="POST" action="LoginOngServlet">
						<p>
							<label>E-mail</label> <input type="email" class="form-control p-3"
							 name="email"/>
						</p>
						
						<p>
							<label>Senha</label> <input type="password" class="form-control p-3" 
							name="senha" />
						</p>
						
						<input type="submit" class="btn btn-primary py-2 px-4"  value="Entrar" />
				</form>
				<div>${msg}</div>
			</div>
		</div>
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
<%@include file="rodape.jsp"%>   
<!-- Footer End -->
</body>
</html>