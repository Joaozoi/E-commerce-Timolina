<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Meus Pedidos</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/MenuCliente.css">
</head>
<body>

<header>
    <div class="logo">Timolina</div>
    <span>Bem-Vindo</span>
    <div class="user-options">
        <a href="#">Entre ou cadastre-se </a>
        <a href="../../views/produtos.jsp">Voltar para Produtos</a>
    </div>
</header>

<main>
    <section class="meus-pedidos">
        <h2>Meus Pedidos</h2>
        
        <div id="pedidos-lista"></div>

    </section>
</main>

<script>
    window.onload = function() {
        const carrinho = JSON.parse(localStorage.getItem('carrinho')) || [];
        const listaPedidos = document.getElementById('pedidos-lista');
        
        if (carrinho.length === 0) {
            listaPedidos.innerHTML = '<p>Seu carrinho está vazio.</p>';
        } else {
            carrinho.forEach(function(produto) {
                const divProduto = document.createElement('div');
                divProduto.classList.add('produto');
                divProduto.innerHTML = `
                    <p>${produto.nome}</p>
                    <p>R$ ${produto.preco}</p>
                `;
                listaPedidos.appendChild(divProduto);
            });
        }
    }
</script>


 <script src="${pageContext.request.contextPath}/js/script.js"></script>

</body>
</html>
