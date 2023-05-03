<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<!-- link head -->
<jsp:include page="cabecalho.jsp"></jsp:include>

<body>

	<!-- Topbar Start -->
    <jsp:include page="barraBotoes.jsp"></jsp:include>
    <!-- Topbar End -->
      <div class="container-fluid pt-5">
        <div class="d-flex flex-column text-center mb-5 pt-5">
            
            <p class="display-4 m-1"><h2>Ajude a melhorar os nossos serviços</h2><span class="text-primary"></span></p>
          

        </div>
        <div class="row justify-content-center">
            <div class="col-12 col-sm-8 mb-5">
                <div class="contact-form">
                    <div id="success"></div>
                    <jsp:useBean id="pet" class="br.com.animalcare.bean.Pet" scope="request"></jsp:useBean>
                    <form name="cadastroAdotante" method="post" action="AdocaoServlet" >

                        <div class="control-group">
                            <input type="text" class="form-control p-4" name="nome_adotante" value="" 
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
                            <input type="text" class="form-control p-4" name="email" value="" 
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
                        
                       
                        <input type="submit" type="button" class="btn btn-primary py-2 px-4" 
                        name="enviar" value="Enviar">
                    <br><br><br>
                    </form>
                </div>
            </div>
        </div>
    </div>

	<!-- Footer Start -->
    <jsp:include page="rodape.jsp"></jsp:include>
    <!-- Footer End -->
</body>
</html>