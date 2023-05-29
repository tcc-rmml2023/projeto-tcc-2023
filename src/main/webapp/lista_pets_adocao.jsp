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
    <%@include file="barraBotoes.jsp"%>
    <!-- Topbar End -->

    <!-- Blog Start -->
    <div class="container pt-2">
        <div class="d-flex flex-column text-center mb-5 pt-5">
            <h4 class="text-secondary mb-2">Encontre o seu amiguinho</h4>
            <h3 class="display-4 m-0"><span class="text-primary">Animais</span> para Adoção</h3>
        </div>
        <div >
            <div class="row pb-1">
            	<div class="text mb-5 pt-5">
                		<c:forEach items="${lista}" var="obj"> 
                				
                     	   <div class="col-lg-5 mb-1"  > 
                       			<div class="card border-3 mb-1" >
			                  		<table class="tabela" border="1" >
			                  			<tr><td> ID</td><td><c:out value="${obj.id_pet}"/></td></tr>
			                        	<tr><td> Nome</td><td><c:out value="${obj.nome_pet}"/></td></tr>
			                            <tr><td> Idade</td><td><c:out value="${obj.idade}"/></td></tr>
			                            <tr><td> Genero</td><td><c:out value="${obj.genero}"/></td></tr>
			                            <tr><td> Observação</td><td><c:out value="${obj.obs}"/></td></tr>
			                            <tr><td> Ong</td><td><c:out value="${obj.ong_nome}"/></td></tr>
			                            <tr><td> Cidade</td><td><c:out value="${obj.ong_cidade}"/></td></tr> 
			                        </table>
                       			 </div> 
                     		</div>
                     		
                        	 <div class="nav">
                        		<c:if test="${obj.imagem.imagemBase64!=null}">
                        		   <c:forEach items="${obj.imagem.imagemBase64}" var="img">
        								<img  alt="Imagem Pet" style="width:350px; height:300px;" src="${img}">
                        			</c:forEach>
                        		</c:if>
                        		<div >
                        	   		<a href="AdocaoServlet?id_pet=${obj.id_pet}" class="btn btn-primary mt-1 px-2 mb-5" > 
                        	   		Adote o(a) <c:out value="${obj.nome_pet}" /></a>
                        	   </div>
                        			<hr style="height:1px;border-width:0;background-color:#fd7e14">
                        	   </div>
                        	    
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