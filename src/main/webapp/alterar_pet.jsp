<%@page import="br.com.animalcare.bean.Ong"%>

<%request.getAttribute("pet");%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<!-- link head -->
<jsp:include page="cabecalho.jsp"></jsp:include>
<body>

<!-- Topbar Start -->
<jsp:include page="barraBotoesOng.jsp"></jsp:include>
<!-- Topbar End -->   

<a>
          <%
			 Ong ong = (Ong) session.getAttribute("usuarioLogado");
			 if(ong.getEmail() != null){
			 out.print(ong.getNome_ong());
			 }
		 %>
     </a>
     <a>
     
     </a>
     ${pet}

<form name="frmAlteraPet" method="POST" action="AlterarPetServlet?id_pet">
	<table>
	
		<tr>
	      <td><input type="text" name="id_pet"  id="id_pet" class="form-control-endereco p-2"
	      readonly value="${pet.getId_pet}"/></td>
	     </tr>
			
	     <tr>
	      <td><input type="text" name="nome_pet"  id="nome_pet" class="form-control-endereco p-2"
	      value="${pet.getNome_pet}"/></td>
	     </tr>
	     
	     <tr>
	      <td><input type="text" name="idade"  id="idade" class="form-control-endereco p-2"
	      value="${pet.getIdade}"></td>
	     </tr>
	     
	     <tr>
	      <td><input type="text" name="genero"  id="genero" class="form-control-endereco p-2"
	      value="${pet.getGenero}"></td>
	     </tr>
	     
	     <tr>
	      <td><input type="text" name="obs"  id="obs" class="form-control-endereco p-2"
	      value="${obj.getObs}"></td>
	     </tr>
	</table>
	<input type="submit" type="button" class="btn btn-primary py-2 px-4" 
                                    name="enviar" value="Alterar">
</form>

<!-- Footer Start -->
<jsp:include page="rodape.jsp"></jsp:include>   
<!-- Footer End -->
</body>
</html>