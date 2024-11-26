<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cartões</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manutencaoClientes.css">
</head>
<body>
    <header>
        <div class="logo">Timolina</div>
        <div class="menu">
            <a href="${pageContext.request.contextPath}/views/novasPaginas/login.jsp">Bem-vindo<br>Entre ou cadastre-se</a>
            <a href="${pageContext.request.contextPath}/views/novasPaginas/cadastroProduto.jsp">Adicionar produto</a>
            <a href="#">Carrinho</a>
        </div>
    </header>
    <br><br>
    <div class="pagina">
        <div class="barraLateral">
            <div class="ola">Olá!</div>
            <br>
            <div class="opcoesCadastro">
                <a href="${pageContext.request.contextPath}/views/novasPaginas/manutencaoClientes/dadosPessoais.jsp">
                    <img src="${pageContext.request.contextPath}/imagens/person.png">Dados pessoais</a>
                <br><br>
                <a href="${pageContext.request.contextPath}/views/novasPaginas/manutencaoClientes/enderecos.jsp">
                    <img src="${pageContext.request.contextPath}/imagens/Icon.png">Endereços</a>
                <br><br>
                <a href="${pageContext.request.contextPath}/views/novasPaginas/manutencaoClientes/cartoes.jsp">
                    <img src="${pageContext.request.contextPath}/imagens/Icon-2.png">Cartões</a>
                <br><br>
                <a href="${pageContext.request.contextPath}/views/novasPaginas/manutencaoClientes/pedidos.jsp">
                    <img src="${pageContext.request.contextPath}/imagens/icon-3.png">Pedidos</a>
                <br><br>
            </div>
        </div>
        <div class="barraLateralDireita">
            <span>Cartões</span>
            <br><br>

            <!-- Formulário para envio dos dados do cartão -->
            <form action="/TIMOLINAZOIO/CartaoServlet" method="post">


                <label for="numero">Número:</label>
                <input type="number" name="numero" id="numero" placeholder="Digite o número do cartão" required>
                <br><br>

                <label for="validade">Validade:</label>
                <input type="date" name="validade" id="validade" placeholder="mm/aaaa" required>
                <br><br>

                <label for="cvv">CVV:</label>
                <input type="number" name="cvv" id="cvv" placeholder="123" required>
                <br><br>

                <label for="titular">Nome do titular:</label>
				<input type="text" name="nomeTitular" id="titular" placeholder="Digite o nome do titular" required>

                <br><br>

                <button type="submit">Adicionar Cartão</button>
            </form>
        </div>
    </div>
</body>
</html>
