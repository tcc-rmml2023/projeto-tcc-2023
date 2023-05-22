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
    
   <!-- Contact Start -->
    <div class="container-fluid pt-5">
        <div class="d-flex flex-column text-center mb-5 pt-5">
            
            <p class="display-4 m-1"><h2>Solicitação de adoção</h2><span class="text-primary"></span></p>
          
            <h4 class="text-secondary mb-3">Preencha o formulário</h4>
        </div>
        
        <div class="row justify-content-center">
            <div class="col-12 col-sm-8 mb-5">
                <div class="contact-form">
                
                <!-- Mensagem ao solicitar adoção -->
                <div><h6>${msg}</h6></div><br><b></b>
                
                    <div id="success"></div>
                    <jsp:useBean id="pet" class="br.com.animalcare.bean.Pet" scope="request" />
                    <form name="cadastroAdotante" method="post" action="AdocaoServlet" >
                   
                        <div class="control-group">
                            <input type="text" class="form-control p-4" name="nome_adotante" value="" 
                            placeholder="Seu nome" required="required" 
                            data-validation-required-message="Please enter your name" />
                            <p class="help-block text-danger"></p>
                        </div>
                        
                        <div class="control-group">
                            <input type="text" class="form-control p-4" name="cpf" value="" maxlength="11"
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
                            <input type="tel" onkeydown="return mascaraTelefone(event)" maxlength="11"
                             class="form-control p-4" name="telefone" value="" 
                            placeholder="Telefone" required="required" 
                            data-validation-required-message="Please enter a subject"/>  
                            <p class="help-block text-danger"></p>
                        </div>
                        
                        <input type="submit" type="button" class="btn btn-primary py-2 px-4" 
                        name="enviar" value="Enviar"><br><br><br>
                        
                        <h4>Informações do pet</h4>
                        
                        <div class="control-group">
                           ID pet <input type="text" class="form-control p-4" name="id_pet" readonly="readonly"
                            value="<%out.println(request.getAttribute("id_pet"));%>"/>
                             <p class=""></p>
                        </div>
                        
                        <div class="control-group">
                           Nome pet <input type="text" class="form-control p-4" name="nome_pet" readonly="readonly"
                             value="<%out.println(request.getAttribute("nome_pet"));%>"/>
                             <p class=""></p>
                        </div>
                        
                        <div class="control-group">
                           Idade <input type="text" class="form-control p-4" name="idade" readonly="readonly"
                             value="<%out.println(request.getAttribute("idade"));%>"/>
                             <p class=""></p>
                        </div>
                        
                        <div class="control-group">
                            Genero<input type="text" class="form-control p-4" name="genero" readonly="readonly"
                             value="<%out.println(request.getAttribute("genero"));%>"/>
                             <p class=""></p>
                        </div>
                        
                        <div class="control-group">
                           Observações <input type="text" class="form-control p-4" name="obs" readonly="readonly"
                             value="<%out.println(request.getAttribute("obs"));%>"/>
                             <p class=""></p>
                        </div>
                        
                        <div class="control-group">
                           Ong <input type="text" class="form-control p-4" name="nome_ong" readonly="readonly"
                             value="<%out.println(request.getAttribute("nome_ong"));%>"/>
                             <p class=""></p>
                        </div>
                        
                        <div class="control-group">
                           Email ong <input type="text" class="form-control p-4" name="emailOng" readonly="readonly"
                             value="<%out.println(request.getAttribute("emailOng"));%>"/>
                             <p class=""></p>
                        </div>
         
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