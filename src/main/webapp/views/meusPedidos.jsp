<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Meus Pedidos</title>
    <link rel="stylesheet" href="../styles/MenuCliente.css">
</head>
<body>
    <header>
        <div class="logo">Timolina</div>
        <div class="user-options">
            <a href="login.jsp">Entre ou cadastre-se</a>
            <a href="MenucCliente.jsp">Voltar para Produtos</a>
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
            
            // Verifica se o carrinho está vazio
            if (carrinho.length === 0) {
                listaPedidos.innerHTML = '<p>Seu carrinho está vazio.</p>';
            } else {
                carrinho.forEach(function(produto) {
                    const divProduto = document.createElement('div');
                    divProduto.classList.add('produto');
                    divProduto.innerHTML = `
                        <p><b>Produto:</b> ${produto.nome}</p>
                        <p><b>Preço:</b> R$ ${produto.preco.toFixed(2)}</p>
                    `;
                    listaPedidos.appendChild(divProduto);
                });
            }
        };
    </script>
</body>
</html>
