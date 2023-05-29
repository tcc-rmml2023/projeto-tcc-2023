<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<div class="row">
                <div class="text-left mb-5">
                  
                 		<c:forEach items="${lista}" var="obj">
                 		
                 		<a href="AdocaoServlet?id_pet=${obj.id_pet}" class="btn btn-lg btn-secondary mt-3 mt-md-4 px-2">ADOTE</a>
                 		
                  		<table class="tabela" border="1" >
                  			<tr><td> ID</td><td><c:out value="${obj.id_pet}"/></td></tr>
                        	<tr><td> Nome</td><td><c:out value="${obj.nome_pet}"/></td></tr>
                            <tr><td> Idade</td><td><c:out value="${obj.idade}"/></td></tr>
                            <tr><td> Genero</td><td><c:out value="${obj.genero}"/></td></tr>
                            <tr><td> Observação</td><td><c:out value="${obj.obs}"/></td></tr>
                            <tr><td> Ong</td><td><c:out value="${obj.ong_nome}"/></td></tr>
                            <tr><td> Cidade</td><td><c:out value="${obj.ong_cidade}"/></td></tr> 
                            
                        	</table>
                        	
                        	<c:if test="${obj.imagem.imagemBase64!=null}">
                        				<c:forEach items="${obj.imagem.imagemBase64}" var="img">
                        					
														<ul class="nav">
															<li>
        														<img  alt="Imagem Pet" style="width:250px;height:250px" src="${img}">
    														</li>
													     </ul>
                        				</c:forEach>
                        			</c:if>
                  	  	</c:forEach>
                    </div>
                </div>
          

</body>
</html>