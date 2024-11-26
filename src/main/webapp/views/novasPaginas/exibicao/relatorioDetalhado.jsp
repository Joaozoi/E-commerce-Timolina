<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Relatorio Detalhado</title>
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
			<div class="opcoesCadastro">
				<a
					href="${pageContext.request.contextPath}/views/novasPaginas/exibicao/clientes.jsp"><img
					src="${pageContext.request.contextPath}/imagens/person.png">Clientes</a>
				<!-- Adicionar link -->
				<br> <br> <a
					href="${pageContext.request.contextPath}/views/novasPaginas/exibicao/produtos.jsp"><img
					src="${pageContext.request.contextPath}/imagens/Icon.png">Produtos</a>
				<!-- Adicionar link -->
				<br> <br> <a
					href="${pageContext.request.contextPath}/views/novasPaginas/exibicao/relatorioDetalhado.jsp"><img
					src="${pageContext.request.contextPath}/imagens/Icon-2.png">Relatorio
					Detalhado</a>
				<!-- Adicionar link -->
				<br> <br> <a
					href="${pageContext.request.contextPath}/views/novasPaginas/exibicao/relatorioResumido.jsp"><img
					src="${pageContext.request.contextPath}/imagens/icon-3.png">Relatorio
					Resumido</a>
				<!-- Adicionar link -->
				<br> <br>
			</div>
		</div>
		<div class="barraLateralDireita">
			<span>Relatorio Detalhado</span> <br> <br>
			<table>
        <thead>
            <tr>
            	<th>ID</th>
                <th>Produto</th>
                <th>Vendas</th>
                <th>Valor Unitario</th>
                <th>Total</th>
            </tr>
        </thead>
        <tbody>
           
            <c:forEach var="produto" items="${produtos}">
                <tr>
                	<td>${relatorio.id}</td>
                    <td>${relatorio.produto}</td>
                    <td>${relatorio.vendar}</td>
                    <td>${relatorio.preco}</td>
                    <td>${relatorio.total}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


		</div>


	</div>

</body>
</html>