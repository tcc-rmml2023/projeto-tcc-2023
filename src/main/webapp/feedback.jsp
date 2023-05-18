<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<!-- link head -->
<%@include file="cabecalho.jsp"%>

<body>

	<!-- Topbar Start -->
    <%@include file="barraBotoes.jsp"%>
    <!-- Topbar End -->
      <div class="container-fluid pt-5">
        <div class="d-flex flex-column text-center mb-5 pt-5">
            
          <p class="display-4 m-1"><h3>Ajude-nos a melhorar os nossos serviços, deixando o seu <i>feedback</i> abaixo</h3><span class="text-primary"></span></p>

        </div>
        <div class="row justify-content-center">
            <div class="col-12 col-sm-8 mb-5">
           	  <div>${msg}</div><br>
                <div class="contact-form">
                    <div id="success"></div>
                    <form name="cadastroAdotante" method="post" action="FeedbackServlet" >

                        <div class="control-group">
                            <input type="text" class="form-control p-4" name="nome" value="" 
                            placeholder="Seu nome" required="required" 
                            data-validation-required-message="Please enter your name" />
                            <p class="help-block text-danger"></p>
                        </div>
                        
                        <div class="control-group">
                            <input type="email" class="form-control p-4" name="email" value="" 
                            placeholder="Seu e-mail" required="required" 
                            data-validation-required-message="Please enter your email" />
                            <p class="help-block text-danger"></p>
                        </div>
                        
                        <div class="control-group">
                        
                        <textarea class="form-control p-4" id="feedback" name ="feedback"
                    		rows ="6" cols="35"
                        placeholder="Seu e-mail">
                        </textarea>
                           
                        </div>
                        
                       <br><br>
                        <input type="submit" type="button" class="btn btn-primary py-2 px-4" 
                        name="enviar" value="Enviar">
                    
                    </form>
                </div>
            </div>
        </div>
    </div>

	<!-- Footer Start -->
    <%@include file="rodape.jsp"%>
    <!-- Footer End -->
</body>
</html>