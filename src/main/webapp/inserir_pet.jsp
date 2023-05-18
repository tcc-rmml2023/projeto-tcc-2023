<%@page import="br.com.animalcare.bean.Ong"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html"
	xmlns:f="http://xmlns.jcp.org/jsf/core"
	xmlns:p="http://primefaces.org/ui"
	xmlns:jsf="http://xmlns.jcp.org/jsf"
	
lang="pt-br">

<!-- link head -->
<%@include file="cabecalho.jsp"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>

	<!-- Topbar Start -->
     <%@include file="barraBotoesOng.jsp"%>
    <!-- Topbar End -->
    
    <!-- Ong logada -->
    <jsp:include page="ongLogada.jsp"></jsp:include>
    
    <div> ${msg}</div>
     
     <div>
     	<p><a>Preencha o formulário abaixo com as informações do pet!</a><br><br>
     </div>
  
      <form name="inserir" method="POST" enctype="multipart/form-data" action="InserirPetServlet">
      
       	 <input type="text" class="form-control-cep p-4" name="nome_pet" id="nome" value=""
           placeholder="Nome do pet" autofocus required="required" 
           data-validation-required-message="Please enter your message"><br><br>
           
         <input type="text" class="form-control-cep p-4" name="idade" id="idade" value="" 
           placeholder="Idade" autofocus required="required" 
           data-validation-required-message="Please enter your message"><br><br>
           
         <input type="text" class="form-control-cep p-4" name="genero" id="genero" value="" 
           placeholder="Genero" autofocus required="required" 
           data-validation-required-message="Please enter your message"><br><br>
           
         <input type="text" class="form-control-cep p-4" name="obs" id="obs" value="" 
           placeholder="Observação" 
           data-validation-required-message="Please enter your message"><br><br>
           
          <p>Insira até três fotos</p>
         <p><input type="file" accept="imagem/*" multiple="multiple" name="imagem" value="" >
          <br><br>
                                  
        <input type="submit" type="button" class="btn btn-primary py-2 px-4" 
               name="enviar" value="Inserir"><br><br>  
               
      </form>
      
    <!-- Footer Start -->
     <%@include file="rodape.jsp"%>
    <!-- Footer End -->
</body>

<script type="text/javascript">

  function uploadFile() {
	
	var etiqueta = document.querySelector("img");
	var file = document.querySelector("input[type=file]").files[i];
	
	var reader = new FileReader();
	reader.onloadend = function() {
		etiqueta.src = reader.result;
	};
	
	if (file){
		reader.readAsDataURL(file);
		
		$.ajax({
			method : "POST",
			url : "InserirPetServlet",
			data : {"fileUpload" : etiqueta.src}
		
		}).done(function (response) {
			alert("Sucesso" + response);
			
		}).fail(function(xhr, status, errorThrown) {
			alert("Error: " + xhr.responseText);
		});
	}
	else {
		etiqueta.src="";
	}
	
  }	
</script>
</html>