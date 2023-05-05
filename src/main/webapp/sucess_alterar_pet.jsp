<%@page import="br.com.animalcare.bean.Pet"%>
<%@page import="br.com.animalcare.bean.Ong"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html lang="pt-br">
<!-- link head -->
<%@include file="cabecalho.jsp"%>
<body>

<!-- Topbar Start -->
<%@include file="barraBotoesOng.jsp"%>
<!-- Topbar End -->   

<!-- Ong logada -->
<jsp:include page="ongLogada.jsp"></jsp:include>

	<div>${msg}</div>
   
<form name="frmAlteraPet" method="POST" action="sucess_alterar_pet.jsp">

	 <input type="text" class="form-control-cep p-4" name="id_pet" id="id_pet" readonly="readonly"
	 value=""><br><br>
	
	 <input type="text" class="form-control-cep p-4" name="nome_pet" id="nome_pet" 
	 value="" ><br><br>
     
     <input type="text" class="form-control-cep p-4" name="idade" id="idade" 
	 value="" ><br><br>
     
     <input type="text" class="form-control-cep p-4" name="genero" id="genero" 
	 value="" ><br><br>
     
     <input type="text" class="form-control-cep p-4" name="obs" id="obs" 
	 value="" ><br><br>
	
	<input type="submit" type="button" class="btn btn-primary py-2 px-4" 
                                    name="enviar" value="Salvar">
</form>

<!-- Footer Start -->
<%@include file="rodape.jsp"%> 
<!-- Footer End -->
</body>
</html>