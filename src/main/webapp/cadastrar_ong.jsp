<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%String erro = (String) request.getAttribute("erro");%>

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
            <h3 class="display-4 m-0">Cadastre<span class="text-primary"> sua Ong </span></h3>
            <h5 class="text-secondary mb-3">Preencha o formulário abaixo</h5>
        </div>
        <div class="row justify-content-center">
            <div class="col-12 col-sm-8 mb-5">
                <div class="contact-form">
                   
                     <form name="cadastrar" method="POST" action="OngServlet">
                     
                        <div class="control-group">
                            <input type="text" class="form-control p-4" name="nome_ong" id="nome"  value="" placeholder="Nome da ONG" 
                                required="required" data-validation-required-message="Please enter your name" />
                            <p class="help-block text-danger"></p>
                        </div>
                        
                        <div class="control-group">
                            <input type="tel" onkeydown="return mascaraTelefone(event)" class="form-control p-4 "
                                name="telefone" id="telefone" value="" placeholder="Telefone" required="required"
                                data-validation-required-message="Please enter a subject" />

                            <script>
                                function mascaraTelefone(event) {
                                    let tecla = event.key;
                                    let telefone = event.target.value.replace(/\D+/g, "");

                                    if (/^[0-9]$/i.test(tecla)) {
                                        telefone = telefone + tecla;
                                        let tamanho = telefone.length;

                                        if (tamanho >= 12) {
                                            return false;
                                        }

                                        if (tamanho > 10) {
                                            telefone = telefone.replace(/^(\d\d)(\d{5})(\d{4}).*/, "($1) $2-$3");
                                        } else if (tamanho > 5) {
                                            telefone = telefone.replace(/^(\d\d)(\d{4})(\d{0,4}).*/, "($1) $2-$3");
                                        } else if (tamanho > 2) {
                                            telefone = telefone.replace(/^(\d\d)(\d{0,5})/, "($1) $2");
                                        } else {
                                            telefone = telefone.replace(/^(\d*)/, "($1");
                                        }

                                        event.target.value = telefone;
                                    }

                                    if (!["Backspace", "Delete"].includes(tecla)) {
                                        return false;
                                    }
                                }
                            </script>
                            <p class="help-block text-danger"></p>
                        </div>
                        <div class="control-group">
                            <input type="number" class="form-control p-4" name="cnpj" id="cnpj" value="" maxlength="11"
                            	placeholder="CNPJ" required="required" 
                            	data-validation-required-message="Please enter your message">
                            <p class="help-block text-danger"></p>
                        </div>
                        <div class="control-group">
                        		
      
                                CEP: <input type="text" class="form-control-cep p-4" name="cep" id="cep" value="" maxlength="8"
                                    placeholder="00000-000" autofocus required="required" 
                                    data-validation-required-message="Please enter your message"><br><br>
                                    
                                <input type="text" class="form-control-endereco p-4" name="logradouro" id="logradouro" value=""
                                    placeholder="Logradouro" required="required" 
                                    data-validation-required-message="Please enter your message">
                                    
                                <input type="text" class="form-control-numero p-4" name="numero" id="numero" value=""
                                    placeholder="Número" required="required" 
                                    data-validation-required-message="Please enter your message"><br><br><br>
                                    
                                <input type="text" class="form-control-complemento p-4" name="complemento" id="complemento" value=""
                                    placeholder="Complemento">
                                    
                                <input type="text" class="form-control-bairro p-4" name="bairro" id="bairro" value=""
                                    placeholder="Bairro" required="required" 
                                    data-validation-required-message="Please enter your message"><br><br><br>

                                <input type="text" class="form-control-cidade p-4" name="cidade" id="cidade" value="" 
                                placeholder="Cidade" required="required" data-validation-required-message="Please enter your message">
                                
                                <input type="text" class="form-control-uf p-4" name="uf" id="uf" value="" 
                                placeholder="UF" required="required" data-validation-required-message="Please enter your message"><br><br><br>
                                
                              </div>  
                                <h2> Informações de login</h2>
                                
                                <div class="control-group">
                            		<input type="email" class="form-control p-4" name="email" id="email" value="" placeholder="E-mail da ONG"
                               	    required="required" data-validation-required-message="Please enter your email" />
                            		<p class="help-block text-danger"></p>
                       			</div>
                       			
                       			 <div class="control-group">
                            		<input type="password" class="form-control p-4" name="senha" id="senha" value="" placeholder="Senha"
                               	    required="required" data-validation-required-message="Please enter your password" />
                            		<p class="help-block text-danger"></p>
                       			</div>
		
                               <input type="submit" type="button" class="btn btn-primary py-2 px-4" 
                                    name="enviar" value="Cadastrar">
                               <p><% if (erro != null) out.print(erro); %></p>
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