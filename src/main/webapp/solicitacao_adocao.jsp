<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    
<!DOCTYPE html>
<html lang="pt-br">

<!-- link head -->
<%@include file="cabecalho.jsp"%>

<body>
    <!-- Topbar Start -->
    <%@include file="barraBotoes.jsp"%>
    <!-- Topbar End -->
    
   <!-- Contact Start -->
    <div class="container-fluid pt-5">
        <div class="d-flex flex-column text-center mb-5 pt-5">
            
            <p class="display-4 m-1"><h2>Solicitação de adoção</h2><span class="text-primary"></span></p>
          
            <h4 class="text-secondary mb-3">Preencha o formulário</h4>
        </div>
        <div class="row justify-content-center">
            <div class="col-12 col-sm-8 mb-5">
                <div class="contact-form">
                    <div id="success"></div>
                    <jsp:useBean id="pet" class="br.com.animalcare.bean.Pet" scope="request"></jsp:useBean>
                    <form name="cadastroAdotante" method="post" action="AdocaoServlet" >
                    
                    	<div class="control-group">
                            <input type="text" class="form-control p-4" name="id_pet" readonly="readonly"
                            value="<%out.println(request.getAttribute("id_pet"));%>"/>
                             <p class=""></p>
                        </div>
                        
                        <div class="control-group">
                            <input type="text" class="form-control p-4" name="nome_pet" readonly="readonly"
                             value="<%out.println(request.getAttribute("nome_pet"));%>"/>
                             <p class=""></p>
                        </div>
                    
                        <div class="control-group">
                            <input type="text" class="form-control p-4" name="nome_adotante" value="" 
                            placeholder="Seu nome" required="required" 
                            data-validation-required-message="Please enter your name" />
                            <p class="help-block text-danger"></p>
                        </div>
                        
                        <div class="control-group">
                            <input type="text" class="form-control p-4" name="cpf" value="" 
                            placeholder="Seu CPF" 
                            required="required" data-validation-required-message="Please enter your email" />
                            <p class="help-block text-danger"></p>
                        </div>
                        
                        <div class="control-group">
                            <input type="email" class="form-control p-4" name="email" value="" 
                            placeholder="Seu e-mail" required="required" 
                            data-validation-required-message="Please enter your email" />
                            <p class="help-block text-danger"></p>
                        </div>
                        
                        <div class="control-group">
                            <input type="tel" onkeydown="return mascaraTelefone(event)" 
                             class="form-control p-4" name="telefone" value="" 
                            placeholder="Telefone" required="required" 
                            data-validation-required-message="Please enter a subject"/>  
                            <p class="help-block text-danger"></p>
                        </div>
                        
                        <div class="control-group">
                                CEP: <input type="text" class="form-control-cep p-4" name="cep" value="" maxlength="9" placeholder="00000-000" autofocus><br><br>
                                <input type="text" class="form-control-endereco p-4"  name="endereco" value=""  placeholder="Logradouro">
                                <input type="text" class="form-control-numero p-4" name="numero" value="" placeholder="Número"><br><br><br>
                                <input type="text" class="form-control-complemento p-4" name="complemento" value="" placeholder="Complemento">
                                <input type="text" class="form-control-bairro p-4" name="bairro" value=""  placeholder="Bairro"><br><br><br>    
                                <input type="text" class="form-control-cidade p-4"  name="cidade" value=""  placeholder="Cidade">
                                <input type="text" class="form-control-uf p-4" name="uf" value=""  placeholder="UF" >
                               <br><br><br>                       		
                        </div>
                        <input type="submit" type="button" class="btn btn-primary py-2 px-4" 
                        name="enviar" value="Enviar">
                    <br><br><br>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- Contact End -->

   <!-- Footer Start -->
   <%@include file="rodape.jsp"%>
   <!-- Footer End -->
</body>

</html>