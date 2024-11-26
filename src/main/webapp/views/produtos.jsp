<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Produtos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manutencaoClientes.css">
</head>
<body>
    <header>
        <div class="logo">Timolina</div>
        <div class="menu">
            <a href="${pageContext.request.contextPath}/views/novasPaginas/login.jsp">Bem-vindo <br> Entre ou cadastre-se</a>
            <a href="${pageContext.request.contextPath}/views/novasPaginas/cadastroProduto.jsp">Adicionar produto</a>
            <a href="#">Carrinho</a>
        </div>
    </header>
    <br><br>
    <div class="pagina">
        <div class="barraLateral">
            <div class="ola">Olá!</div><br>
            <div class="opcoesCadastro">
                <a href="${pageContext.request.contextPath}/views/novasPaginas/exibicao/clientes.jsp"><img src="${pageContext.request.contextPath}/imagens/person.png">Clientes</a><br><br>
                <a href="${pageContext.request.contextPath}/views/novasPaginas/exibicao/produtos.jsp"><img src="${pageContext.request.contextPath}/imagens/Icon.png">Produtos</a><br><br>
                <a href="${pageContext.request.contextPath}/views/novasPaginas/exibicao/relatorioDetalhado.jsp"><img src="${pageContext.request.contextPath}/imagens/Icon-2.png">Relatório Detalhado</a><br><br>
                <a href="${pageContext.request.contextPath}/views/novasPaginas/exibicao/relatorioResumido.jsp"><img src="${pageContext.request.contextPath}/imagens/icon-3.png">Relatório Resumido</a><br><br>
            </div>
        </div>
        <div class="barraLateralDireita">
            <span>Produtos</span><br><br>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Descrição</th>
                        <th>Preço</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
          
               
                    
                </tbody>
            </table>
            <a href="${pageContext.request.contextPath}/views/novasPaginas/cadastroProduto.jsp">
                <button type="button">Adicionar Produto</button>
            </a>
        </div>
    </div>
</body>
</html>
