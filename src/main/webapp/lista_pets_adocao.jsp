 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    
<!DOCTYPE html>
<html lang="pt-br">

<!-- link head -->
<jsp:include page="cabecalho.jsp"></jsp:include>

<body>
    <!-- Topbar Start -->
    <jsp:include page="barraBotoes.jsp"></jsp:include>
    <!-- Topbar End -->

    <!-- Blog Start -->
    <div class="container pt-5">
        <div class="d-flex flex-column text-center mb-5 pt-5">
            <h4 class="text-secondary mb-3">Encontre o seu amiguinho</h4>
            <h2 class="display-4 m-0"><span class="text-primary">Animais</span> para Adoção</h2>
        </div>
        <div class="row pb-3">
            <div class="col-lg-4 mb-4">
                <div class="card border-0 mb-2">
                  
                 		<c:forEach items="${lista }" var="obj">
                  		<p>	
                  		<table class="tabela" border="1" >
                  			<tr><td> ID</td><td><c:out value="${obj.id_pet}"/></td></tr>
                        	<tr><td> Nome</td><td><c:out value="${obj.nome_pet}"/></td></tr>
                            <tr><td> Idade</td><td><c:out value="${obj.idade}"/></td></tr>
                            <tr><td> Genero</td><td><c:out value="${obj.genero}"/></td></tr>
                            <tr><td> Observação</td><td><c:out value="${obj.obs}"/></td></tr>
                            <tr><td> Ong</td><td><c:out value="${obj.ong_nome}"/></td></tr>
                            <tr><td> Cidade</td><td><c:out value="${obj.ong_cidade}"/></td></tr>
                        </table>
                        <a href="AdocaoServlet?id_pet=${obj.id_pet}" class="btn btn-lg btn-secondary mt-3 mt-md-4 px-4">ADOTE</a>	
                        </p>
                  		</c:forEach>
                        
                    </div>
                </div>
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

 <!-- Footer Start -->
 <jsp:include page="rodape.jsp"></jsp:include>
 <!-- Footer End -->
</body>
</html>