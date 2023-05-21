<%@page import="br.com.animalcare.bean.Ong"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<!DOCTYPE html>
<html lang="pt-br">

<!-- Head Start -->
<%@include file="cabecalho.jsp"%>
<!-- Head End -->

<body>
    <!-- Topbar Start -->
    <%@include file="barraBotoesOng.jsp"%>
    <!-- Topbar End -->
    
    <!-- Ong logada Start -->
    <jsp:include page="ongLogada.jsp" />
    <!-- Ong logada End -->
   
        <div class="d-flex flex-column text-center mb-5 pt-5">
        
            <h6 class="display-4 m-0"><span class="text-primary">Lista de pets</span></h6></div>
        <div class="row pb-3">
            <div class="col-lg-4 mb-4">
            
            	<!-- Mensagem ao atualizar pet -->
            	<div><h5>${msg}</h5></div>
            	
                  <c:forEach items="${lista}" var="obj">
                  <div class="card border-0 mb-2">
                  		
                  		<table class="tabela" border="1">
                  			<tr><td> ID Pet</td><td><c:out value="${obj.id_pet}"/></td></tr>
                        	<tr><td> Nome</td><td><c:out value="${obj.nome_pet}"/></td></tr>
                            <tr><td> Idade</td><td><c:out value="${obj.idade}"/></td></tr>
                            <tr><td> Genero</td><td><c:out value="${obj.genero}"/></td></tr>
                            <tr><td> Observação</td><td><c:out value="${obj.obs}"/></td></tr>
                            <tr><td> Ong</td><td><c:out value="${obj.ong_nome}"/></td></tr>
                            <tr><td> ID Ong</td><td><c:out value="${obj.id_ong}"/></td></tr>
                        </table>
                        <a href="AlterarPetServlet?id_pet=${obj.id_pet}" class="btn btn-primary-crud py-2 px-4">Alterar</a>
                  	    <a href="ExcluirPetServlet?id_pet=${obj.id_pet}" class="btn btn-primary-crud py-2 px-4">Excluir</a>
                      
                       <table border="1">
                       <tr>
                       <td>
                       <c:if test="${obj.imagem.imagemBase64!=null}">
                      		 <c:forEach items="${obj.imagem.imagemBase64}" var="img">
                       				<img alt="Imagem Pet" width="300" height="200" src="${img}">
                       			</c:forEach>
                        </c:if>
                       </td>
                       </tr>
                       </table>
                       </div>
                       
                  		</c:forEach>
                    </div>
                </div>
            <div class="col-lg-12">
                <nav aria-label="Page navigation">
                  <ul class="pagination justify-content-center mb-4">
                    <li class="page-item disabled">
                      <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo; Anterior</span>
                      </a>
                    </li>
                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                    <!--li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li-->
                    <li class="page-item">
                      <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">Próxima &raquo;</span>
                      </a>
                    </li>
                  </ul>
                </nav>
            </div>
    <!-- Blog End -->

    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
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