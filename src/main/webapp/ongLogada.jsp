 <%@page import="br.com.animalcare.bean.Ong"%>
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
    	<h5>
			 <%
			 Ong ong = (Ong) session.getAttribute("usuarioLogado");
			 if(ong.getEmail() != null){
			 out.println(ong.getNome_ong());
			 }
			 %>    		
    		</h5>
     	<br><br>
    </div>
</body>
</html>