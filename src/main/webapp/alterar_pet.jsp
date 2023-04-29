<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<!-- link head -->
<jsp:include page="cabecalho.jsp"></jsp:include>
<body>

<!-- Topbar Start -->
<jsp:include page="barraBotoes.jsp"></jsp:include>
<!-- Topbar End -->   

<form name="frmAlteraPet" method="POST" action="AlterarPetServlet">
	<table>
	     <tr><td> ID Pet</td><td><c:out value="${obj.id_pet}"/></td></tr>
	     <tr><td> Nome</td><td><c:out value="${obj.nome_pet}"/></td></tr>
	     <tr><td> Idade</td><td><c:out value="${obj.idade}"/></td></tr>
	     <tr><td> Genero</td><td><c:out value="${obj.genero}"/></td></tr>
	     <tr><td> Observação</td><td><c:out value="${obj.obs}"/></td></tr>
	</table>
	<input type="submit" type="button" class="btn btn-primary py-2 px-4" 
                                    name="enviar" value="Alterar">
</form>

<!-- Footer Start -->
<jsp:include page="rodape.jsp"></jsp:include>   
<!-- Footer End -->
</body>
</html>