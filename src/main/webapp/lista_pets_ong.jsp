<%@page import="br.com.animalcare.bean.Ong"%>

<%String msg = (String) request.getAttribute("msg");%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        
<!DOCTYPE html>
<html lang="pt-br">
<%@include file="cabecalho.jsp"%>

<body>
    <!-- Topbar Start -->
    <%@include file="barraBotoesOng.jsp"%>
    <!-- Topbar End -->
    
    <!-- Ong logada -->
    <jsp:include page="ongLogada.jsp"></jsp:include>
   					 
        <div class="d-flex flex-column text-center mb-5 pt-5">
        
            <h6 class="display-4 m-0"><span class="text-primary">Lista de pets</span></h6></div>
        <div class="row pb-3">
            <div class="col-lg-4 mb-4">
            
                  <c:forEach items="${lista}" var="obj">
                  <div class="card border-0 mb-2">
                  		<p>
                  		
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
                       </p>
                       </div>
                       
                  		</c:forEach>
                    </div>
                </div>
           	
           <!--div class="col-lg-4 mb-4">
                <div class="card border-0 mb-2">
                    <img class="card-img-top" src="img/blog-2.jpg" alt="">
                    <div class="card-body bg-light p-4">
                        <h4 class="card-title text-truncate">Diam amet eos at no eos</h4>
                        <div class="d-flex mb-3">
                            <small class="mr-2"><i class="fa fa-user text-muted"></i> Admin</small>
                            <small class="mr-2"><i class="fa fa-folder text-muted"></i> Web Design</small>
                            <small class="mr-2"><i class="fa fa-comments text-muted"></i> 15</small>
                        </div>
                        <p>Diam amet eos at no eos sit lorem, amet rebum ipsum clita stet, diam sea est diam eos, rebum sit vero stet justo</p>
                        <a class="font-weight-bold" href="">Read More</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 mb-4">
                <div class="card border-0 mb-2">
                    <img class="card-img-top" src="img/blog-3.jpg" alt="">
                    <div class="card-body bg-light p-4">
                        <h4 class="card-title text-truncate">Diam amet eos at no eos</h4>
                        <div class="d-flex mb-3">
                            <small class="mr-2"><i class="fa fa-user text-muted"></i> Admin</small>
                            <small class="mr-2"><i class="fa fa-folder text-muted"></i> Web Design</small>
                            <small class="mr-2"><i class="fa fa-comments text-muted"></i> 15</small>
                        </div>
                        <p>Diam amet eos at no eos sit lorem, amet rebum ipsum clita stet, diam sea est diam eos, rebum sit vero stet justo</p>
                        <a class="font-weight-bold" href="">Read More</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 mb-4">
                <div class="card border-0 mb-2">
                    <img class="card-img-top" src="img/blog-1.jpg" alt="">
                    <div class="card-body bg-light p-4">
                        <h4 class="card-title text-truncate">Diam amet eos at no eos</h4>
                        <div class="d-flex mb-3">
                            <small class="mr-2"><i class="fa fa-user text-muted"></i> Admin</small>
                            <small class="mr-2"><i class="fa fa-folder text-muted"></i> Web Design</small>
                            <small class="mr-2"><i class="fa fa-comments text-muted"></i> 15</small>
                        </div>
                        <p>Diam amet eos at no eos sit lorem, amet rebum ipsum clita stet, diam sea est diam eos, rebum sit vero stet justo</p>
                        <a class="font-weight-bold" href="">Read More</a>
                    </div>
                </div-->
          
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