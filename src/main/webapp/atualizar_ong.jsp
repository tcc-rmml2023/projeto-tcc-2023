<%@page import="br.com.animalcare.bean.Ong"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
 	String erro = (String) request.getAttribute("erro");	
 %> 
<!DOCTYPE html>
<html lang="pt-br">

<!-- link head -->
<jsp:include page="cabecalho.jsp"></jsp:include>
<body>
	<!-- Topbar Start -->
<jsp:include page="barraBotoesOng.jsp"></jsp:include>
<!-- Topbar End -->   

<!-- Ong logada -->
<jsp:include page="ongLogada.jsp"></jsp:include>

  <div>
  	<a> ${msg}</a><br><br>
  </div>
	
	<h5>Informações do cadastro</h5>
	<form name="atualizar_ong" method="POST" action="AtualizarOngServlet">
	
		<input type="text" class="form-control-cep p-4" name="id_ong"  readonly="readonly"
		 value="<%out.println(request.getAttribute("id_ong"));%>"><br><br>
	
		<input type="text" class="form-control-cep p-4" name="nome_ong" 
		 value="<%out.println(request.getAttribute("nome_ong"));%>" 
    	 placeholder="Nome da Ong"><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="telefone"  maxlength="11"
		 value="<%out.println(request.getAttribute("telefone"));%>" 
    	 placeholder="Telefone"><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="cnpj"  maxlength="11"
		 value="<%out.println(request.getAttribute("cnpj"));%>" 
    	 placeholder="CNPJ"><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="cep" maxlength="8"
		 value="<%out.println(request.getAttribute("cep"));%>" 
    	 placeholder="00000-000"><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="logradouro" 
		 value="<%out.println(request.getAttribute("logradouro"));%>" 
    	 placeholder="Logradouro"><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="numero" 
		 value="<%out.println(request.getAttribute("numero"));%>" 
    	 placeholder="Número"><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="complemento" 
		 value="<%out.println(request.getAttribute("complemento"));%>" 
    	 placeholder="Complemento" ><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="bairro"  
		 value="<%out.println(request.getAttribute("bairro"));%>" 
    	 placeholder="Bairro"><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="cidade"  
		 value="<%out.println(request.getAttribute("cidade"));%>" 
    	 placeholder="Cidade"><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="uf" 
		 value="<%out.println(request.getAttribute("uf"));%>" 
    	 placeholder="UF"><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="email"  
		 value="<%out.println(request.getAttribute("cidade"));%>" 
    	 placeholder="E-mail"><br><br>
    	 
    	 <input type="password" class="form-control-cep p-4" name="senha" 
		 value="<%out.println(request.getAttribute("senha"));%>" 
    	 placeholder="Senha"><br><br>
		
		<input type="submit" type="button" class="btn btn-primary py-2 px-4" name="Salvar" value="Salvar">
	</form>
	
    <!-- Footer Start -->
    <jsp:include page="rodape.jsp"></jsp:include>
    <!-- Footer End -->
</body>
</html>