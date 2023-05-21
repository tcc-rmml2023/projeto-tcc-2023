<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="pt-br">

<!-- Head Start -->
<%@include file="cabecalho.jsp"%>
<!-- Head End -->

<body>
    <!-- Topbar Start -->
    <%@include file="barraBotoes.jsp"%>
    <!-- Topbar End -->

    <!-- Contact Start -->
    <div class="container-fluid pt-5">
        <div class="d-flex flex-column text-center mb-5 pt-5">
             <h2>Cadastro realizado com sucesso!!</h2>
             <h3>Faça seu login!!</h3>
             <a href="LoginOngServlet" class="btn btn-lg btn-secondary mt-3 mt-md-4 px-4">Login</a>
        </div>
    </div>
    <!-- Contact End -->

    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="./resources/lib/easing/easing.min.js"></script>
    <script src="./resources/lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="./resources/lib/tempusdominus/js/moment.min.js"></script>
    <script src="./resources/lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="./resources/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

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