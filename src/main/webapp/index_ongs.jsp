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
	
	<!-- About Start -->
    <div class="container py-5">
        <div class="row py-5">
            <div class="col-lg-7 pb-5 pb-lg-0 px-3 px-lg-5">
                <h2 class="text-secondary mb-3">Apresentando o </h2>
                <h1 class="display-4 mb-4"><span class="text-primary">Adotante</span> ao <span class="text-secondary">Adotado</span></h1>
                <h5 class="text-muted mb-3">A Animal.CARE é uma instituição de apoio à adoção. Fazemos o contato entre o adotante e o adotado. Nosso papel é ajudar o animalzinho encontrar o seu dono, de forma rápida e cuidadosa.</h5>
                <p class="mb-4">Cadastre sua ONG conosco</p>
                <ul class="list-inline">
                    <li><h5><i class="fa fa-check-double text-secondary mr-3"></i>Anuncios de animais</h5></li>
                    <li><h5><i class="fa fa-check-double text-secondary mr-3"></i>Localização facilitada</h5></li>
                    <li><h5><i class="fa fa-check-double text-secondary mr-3"></i>Contato direto com o adotante</h5></li>
                </ul>
                <a href="OngServlet" class="btn btn-lg btn-primary mt-3 px-4">Cadastrar ONG</a><!--link para forms de adoção-->
            </div>
            <div class="col-lg-5">
                <div class="row px-3">
                    <div class="col-12 p-0">
                        <img class="img-fluid w-100" src="./resources/img/about-1.jpg" alt="">
                    </div>
                    <div class="col-6 p-0">
                        <img class="img-fluid w-100" src="./resources/img/about-2.jpg" alt="">
                    </div>
                    <div class="col-6 p-0">
                        <img class="img-fluid w-100" src="./resources/img/about-3.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- About End -->

	<!-- Footer Start -->
	<jsp:include page="rodape.jsp"></jsp:include>
	<!-- Footer End -->
</body>
</html>