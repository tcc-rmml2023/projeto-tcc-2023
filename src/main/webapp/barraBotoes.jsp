<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<div class="container-fluid">
      
        <div class="row py-3 px-lg-5">
            <div class="col-lg-4">
           		 <a href="index.html" class="navbar-brand d-none d-lg-block">
                    <h1 class="m-0 display-5 text-capitalize"><span class="text-primary">Animal</span>CARE</h1>
                </a>
            </div>
            <div class="col-lg-8 text-center text-lg-right">
                
            </div>
        </div>
    </div>
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <div class="container-fluid p-0">
        <nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-lg-5">
            <a href="index.html" class="navbar-brand d-block d-lg-none">
                <h1 class="m-0 display-5 text-capitalize font-italic text-white"><span class="text-primary">Animal</span>CARE</h1>
               
            </a>
        
            <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
       
            <div class="collapse navbar-collapse justify-content-between px-3" id="navbarCollapse">
                <div class="navbar-nav mr-auto py-0">
                	<a href="index.html" class="nav-item nav-link">Home</a>
                    <a href="../animalcare/PetServlet?action=listarTodosPets" class="nav-item nav-link">Animais</a>
                    <a href="index_ongs.jsp" class="nav-item nav-link">ONGs</a>
                    <a href="quem_somos.jsp" class="nav-item nav-link">Quem Somos</a>
                    <a href="feedback.jsp" class="nav-item nav-link">Feedback</a>
                </div>
                <a href="LoginOngServlet" class="btn btn-lg btn-primary px-3 d-none d-lg-block">Login Ong</a>
            </div>
        </nav>
    </div>
</body>
</html>