<%@page import="br.com.animalcare.bean.Ong"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
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

  	<a> ${msg}</a><br><br>

	<h5>Informações do cadastro</h5>
	<form name="atualizar_ong" method="POST" action="sucess_alterar_ong.jsp">
	
		<input type="text" class="form-control-cep p-4" name="id_ong"  readonly="readonly"
		 value=""><br><br>
	
		<input type="text" class="form-control-cep p-4" name="nome_ong" 
		 value="" 
    	 placeholder="Nome da Ong"><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="telefone"  maxlength="11"
		 value="" 
    	 placeholder="Telefone"><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="cnpj"  maxlength="11"
		 value="" 
    	 placeholder="CNPJ"><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="cep" maxlength="8"
		 value="" 
    	 placeholder="00000-000"><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="logradouro" 
		 value="" 
    	 placeholder="Logradouro"><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="numero" 
		 value="" 
    	 placeholder="Número"><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="complemento" 
		 value="" 
    	 placeholder="Complemento" ><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="bairro"  
		 value="" 
    	 placeholder="Bairro"><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="cidade"  
		 value="" 
    	 placeholder="Cidade"><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="uf" 
		 value="" 
    	 placeholder="UF"><br><br>
    	 
    	 <input type="text" class="form-control-cep p-4" name="email"  
		 value="" 
    	 placeholder="E-mail"><br><br>
    	 
    	 <input type="password" class="form-control-cep p-4" name="senha" 
		 value="" 
    	 placeholder="Senha"><br><br>
		
		<input type="submit" type="button" class="btn btn-primary py-2 px-4" name="Salvar" value="Salvar">
	</form>
	
    <!-- Footer Start -->
    <jsp:include page="rodape.jsp"></jsp:include>
    <!-- Footer End -->
</body>
</html>