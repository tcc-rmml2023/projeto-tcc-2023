<%@page import="br.com.animalcare.bean.Ong"%>

<%
String msg = (String) request.getAttribute("msg");
%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

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
     
     <p><a>Preencha o formulário abaixo</a>
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
          <%if(msg != null ){out.println(msg);} %>     
      </form>
      
    <!-- Footer Start -->
    <jsp:include page="rodape.jsp"></jsp:include>
    <!-- Footer End -->
</body>
</html>