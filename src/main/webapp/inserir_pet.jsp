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
    
    <div> ${msg}</div>
     
     <div>
     	<p><a>Preencha o formulário abaixo com as informações do pet!</a><br><br>
     </div>
  
      <form name="inserir" method="POST" action="InserirPetServlet">
      
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
                                    
        <input type="submit" type="button" class="btn btn-primary py-2 px-4" 
               name="enviar" value="Inserir"><br><br>  
               
      </form>
      
    <!-- Footer Start -->
     <%@include file="rodape.jsp"%>
    <!-- Footer End -->
</body>
</html>