<%@page import="br.com.animalcare.bean.Pet"%>
<%@page import="br.com.animalcare.bean.Ong"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html lang="pt-br">

<!-- Head Start -->
<%@include file="cabecalho.jsp"%>
<!-- Head End -->


<body>

<!-- Topbar Start -->
<%@include file="barraBotoesOng.jsp"%>
<!-- Topbar End -->   

<!-- Ong logada -->
	 <jsp:include page="ongLogada.jsp" />
   
<form name="frmAlteraPet" method="POST" action="AlterarPetServlet">
	
	 <input type="text" class="form-control-cep p-4" name="id_pet" id="id_pet" readonly="readonly"
	 value="<%out.println(request.getAttribute("id_pet"));%>"><br><br>
	
	 Nome<input type="text" class="form-control-cep p-4" name="nome_pet" id="nome_pet" 
	 value="<%out.println(request.getAttribute("nome_pet"));%>" 
     placeholder="Nome" autofocus required="required" 
     data-validation-required-message="Please enter your message"><br><br>
     
     <input type="text" class="form-control-cep p-4" name="idade" id="idade" 
	 value="<%out.println(request.getAttribute("idade"));%>" 
     placeholder="Idade" autofocus required="required" 
     data-validation-required-message="Please enter your message"><br><br>
     
     <input type="text" class="form-control-cep p-4" name="genero" id="genero" 
	 value="<%out.println(request.getAttribute("genero"));%>" 
     placeholder="Genero" autofocus required="required" 
     data-validation-required-message="Please enter your message"><br><br>
     
     <input type="text" class="form-control-cep p-4" name="obs" id="obs" 
	 value="<%out.println(request.getAttribute("obs"));%>" 
     placeholder="Observação" autofocus required="required" 
     data-validation-required-message="Please enter your message"><br><br>
	
	<input type="submit" type="button" class="btn btn-primary py-2 px-4" 
                                    name="enviar" value="Salvar">
</form>

<!-- Footer Start -->
<%@include file="rodape.jsp"%> 
<!-- Footer End -->
</body>
</html>