<%@page import="br.com.animalcare.bean.Ong"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>

	 <!-- Topbar Start -->
    <div class="container-fluid">
       
        <div class="row py-3 px-lg-5">
            <div class="col-lg-4">
                    <h2 class="m-0 display-5 text-capitalize"><span class="text-primary">Animal</span>CARE</h2>
            </div>
            <div class="col-lg-8 text-center text-lg-right"> 
            </div>
        </div>
    </div>
    
    <div class="container-fluid p-0">
    <%Ong ong = (Ong) session.getAttribute("usuarioLogado");%>
        <nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-lg-5">
            <div class="collapse navbar-collapse justify-content-between px-3" id="navbarCollapse">
                <div class="navbar-nav mr-auto py-0"> 
                	<a href="AtualizarOngServlet?id_ong=<%ong.getId_ong();%>" class="nav-item nav-link">Cadastro</a>
					<a href="../animalcare/PetServlet?action=listarPetsPorOng" class="nav-item nav-link">Pets</a>
					<a href="../animalcare/PetServlet?action=inserirPets" class="nav-item nav-link">Adicionar Pets</a>
                    <a href="LogoutOngServlet" class="nav-item nav-link">Sair</a>
                </div>
            </div>
        </nav>
        <a>
        	
        </a>
    </div>
</body>
</html>