<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<!-- Head Start -->
<%@include file="cabecalho.jsp"%>
<!-- Head End -->

<body>

	<!-- Topbar Start -->
	<%@include file="barraBotoes.jsp"%>
	<!-- Topbar End -->

<div class="container py-5">
<div class="row pt-6">
            <div class="d-flex flex-column text-center mb-5">
              
                <h1 class="mb-3">Nossa História</h1>
          
            </div>
             <!--AQUI DEVE-SE COLOCAR A HISTÓRIA-->
   
                   <div class="mb-6">
                       <img class="img-fluid w-100 mb-4" src="./resources/img/imagem1.jpg" alt="Image">
                       <h5>A <i>Animal Care</i> surgiu em 2022, em um projeto de conclusão do curso de Análise e Desenvolvimento de Sistemas, na Fatec Zona Sul "Dom Paulo Evaristo Arns" 
                        Os alunos: Luciano, Murilo e Robson pensaram em uma plataforma que integra os que possuem interesse em adotar algum PEt, às ONGs que próximas, que estão cadastradas
                        no site. <br><br> 
                        A plataforma possui acesso reservado às ONGs, para cadastro de animais.  
    
                       </h5>
                   </div>
    </div>

    <!-- Team Start -->
    <div class="container mt-5 pt-5 pb-3">
        <div class="d-flex flex-column text-center mb-5">
            <h4 class="text-secondary mb-3">Fundadores</h4>
      
        </div>
        <div class="row">
            <div class="col-lg-3 col-md-5">
                <div class="team card position-relative overflow-hidden border-0 mb-4">
                    <img class="card-img-top" src="./resources/img/Luciano.png" alt="">
                    <div class="card-body text-center p-0">
                        <div class="team-text d-flex flex-column justify-content-center bg-light">
                            <h5>Luciano Bento</h5>
                            <i>Equipe de Gerenciamento</i>
                        </div>
                        <div class="team-social d-flex align-items-center justify-content-center bg-dark">
                             <a class="btn btn-outline-primary rounded-circle text-center mr-2 px-0" style="width: 36px; height: 36px;" target="_blank" href="https://www.linkedin.com/in/luciano-bento-034251160/"><i class="fab fa-linkedin-in"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="col-lg-3 col-md-6">
                <div class="team card position-relative overflow-hidden border-0 mb-4">
                    <img class="card-img-top" src="./resources/img/Robson.png" alt="">
                    <div class="card-body text-center p-0">
                        <div class="team-text d-flex flex-column justify-content-center bg-light">
                            <h5>Robson Carlos</h5>
                            <i>BackEnd</i>
                        </div>
                        <div class="team-social d-flex align-items-center justify-content-center bg-dark">
                            <a class="btn btn-outline-primary rounded-circle text-center mr-2 px-0" style="width: 36px; height: 36px;" target="_blank"  href="https://www.linkedin.com/in/robson-sousa-67a452275/"><i class="fab fa-linkedin-in"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="col-lg-3 col-md-6">
                <div class="team card position-relative overflow-hidden border-0 mb-4">
                    <img class="card-img-top" src="./resources/img/Murilo.png" alt="">
                    <div class="card-body text-center p-0">
                        <div class="team-text d-flex flex-column justify-content-center bg-light">
                            <h5>Murilo Cavalcanti</h5>
                            <i>FrontEnd</i>
                        </div>
 						<div class="team-social d-flex align-items-center justify-content-center bg-dark">
                            <a class="btn btn-outline-primary rounded-circle text-center mr-2 px-0" style="width: 36px; height: 36px;" target="_blank" href="https://www.linkedin.com/in/murilo0300/"><i class="fab fa-linkedin-in"></i></a>
                           
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="col-lg-3 col-md-6">
                <div class="team card position-relative overflow-hidden border-0 mb-4">
                    <img class="card-img-top" src="./resources/img/Marcio.jpg" alt="">
                    <div class="card-body text-center p-0">
                        <div class="team-text d-flex flex-column justify-content-center bg-light">
                            <h5>Marcio Sousa</h5>
                            <i>Equipe de gerenciamento</i>
                        </div>
                        <div class="team-social d-flex align-items-center justify-content-center bg-dark">
                           <a class="btn btn-outline-primary rounded-circle text-center mr-2 px-0" style="width: 36px; height: 36px;" target="_blank" href="https://www.linkedin.com/in/marciosousa4/"><i class="fab fa-linkedin-in"></i></a>
                        </div>
                    </div>
                </div>
            </div>
          
        </div>
    </div>
    <!-- Team End -->
</div>

 <!-- Footer Start -->
 <%@include file="rodape.jsp"%>
 <!-- Footer End -->
</body>
</html>