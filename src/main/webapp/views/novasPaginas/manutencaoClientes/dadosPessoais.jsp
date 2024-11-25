<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dados Pessoais</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/manutencaoClientes.css">
<!-- Adicionar o link com o css -->
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
			<div class="opcoesCadastro">
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

			<!-- Linkar com o banco, se der tempo -->
			<span>Dados Pessoais</span> <br> <label for="nome">Nome
				Completo:</label> <br> <input type="text" name="nome"
				placeholder="Null"> <br> <br> <label
				for="nascimento">Data Nascimento</label> <br> <input
				type="date" name="nascimento" placeholder="dd/mm/aaaa"> <br>
			<br> <label for="telefone">Telefone:</label> <br> <input
				type="tel" name="telefone" placeholder="(00) 0000-0000"> <br>
			<br> <label for="email">Email:</label> <br> <input
				type="email" name="email" placeholder="Digite seu email"> <br>
			<br> <label for="cpf">CPF:</label> <br> <input
				type="number" name="cpf" placeholder="123.456.789-00"> <br>
			<br>
			<button type="submit">Adicionar Endereço</button>
		</div>


	</div>




</body>
</html>