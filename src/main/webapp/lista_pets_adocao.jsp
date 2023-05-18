 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html lang="pt-br">

<!-- link head -->
<%@include file="cabecalho.jsp"%>

<body>
    <!-- Topbar Start -->
    <%@include file="barraBotoes.jsp"%>
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
                       
                       <table border="1" style="width: 600px">
                       		<tr>
                       			<td>
                       				<c:if test="${obj.caminhoImagem != null}">
                       					<img alt="" src="${pageContext.request.contextPath + obj.caminhoImagem}" style="width: 300px; height: 250px">
                       				</c:if>
                       			</td>
                       		</tr>
                       </table>
                       
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

 <!-- Footer Start -->
 <%@include file="rodape.jsp"%>
 <!-- Footer End -->
</body>
</html>