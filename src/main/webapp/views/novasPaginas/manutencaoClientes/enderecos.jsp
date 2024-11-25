<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Endereços</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/manutencaoClientes.css">
</head>
<body>
	<header>
		<div class="logo">Timolina</div>
		<div class="menu">
			<a
				href="${pageContext.request.contextPath}/views/novasPaginas/login.jsp">Bem-vindo
				<!-- Adicionar link --> <br> Entre ou cadastre-se
			</a> <a
				href="${pageContext.request.contextPath}/views/novasPaginas/cadastroProduto.jsp">Adicionar
				produto</a> <a href="#">Carrinho</a>
			<!-- Precisamos de um carrinho -->
		</div>
	</header>
	<br>
	<br>
	<div class="pagina">
		<div class="barraLateral">
			<div class="ola">Olá!</div>
			<br>
			<div class="opcoesCadstro">
				<a
					href="${pageContext.request.contextPath}/views/novasPaginas/manutencaoClientes/dadosPessoais.jsp"><img
					src="${pageContext.request.contextPath}/imagens/person.png">Dados
					pessoais</a>
				<!-- Adicionar link -->
				<br> <br> <a
					href="${pageContext.request.contextPath}/views/novasPaginas/manutencaoClientes/enderecos.jsp"><img
					src="${pageContext.request.contextPath}/imagens/Icon.png">Endereços</a>
				<!-- Adicionar link -->
				<br> <br> <a
					href="${pageContext.request.contextPath}/views/novasPaginas/manutencaoClientes/cartoes.jsp"><img
					src="${pageContext.request.contextPath}/imagens/Icon-2.png">Cartões</a>
				<!-- Adicionar link -->
				<br> <br> <a
					href="${pageContext.request.contextPath}/views/novasPaginas/manutencaoClientes/pedidos.jsp"><img
					src="${pageContext.request.contextPath}/imagens/icon-3.png">Pedidos</a>
				<!-- Adicionar link -->
				<br> <br>
			</div>
		</div>
		<div class="barraLateralDireita">

			<!-- Mandar pro banco -->

			<span>Endereços</span> <br> <label for="cep">CEP:</label> <input
				type="number" name="cpf" placeholder=""> <br> <br>
			<label for="bairro">Bairro:</label> <input type="text" name="bairro"
				placeholder=""> <br> <br> <label for="rua">Rua:</label>
			<input type="text" name="rua" placeholder=""> <br> <br>
			<label for="complemento">Complemento:</label> <input type="text"
				name="complemento" placeholder=""> <br> <br>

			<button type="submit">Adicionar Endereço</button>
		</div>


	</div>

</body>
</html>