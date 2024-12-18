<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Página Inicial</title>
    <link rel="stylesheet" href="../styles/MenuCliente.css">
    <script>
        function adicionarAoCarrinho(nome, preco) {
            const carrinho = JSON.parse(localStorage.getItem('carrinho')) || [];
            carrinho.push({ nome, preco });
            localStorage.setItem('carrinho', JSON.stringify(carrinho));
            alert(`${nome} foi adicionado ao carrinho.`);
            window.location.href = "meusPedidos.jsp";
        }

        function filtrarProdutos() {
            const termoPesquisa = document.querySelector('.search-bar input').value.toLowerCase();
            const produtos = document.querySelectorAll('.product');

            produtos.forEach(produto => {
                const nomeProduto = produto.querySelector('p').textContent.toLowerCase();
                
                if (nomeProduto.includes(termoPesquisa)) {
                    produto.style.display = 'block';
                } else {
                    produto.style.display = 'none';
                }
            });
        }
    </script>
</head>
<body>
    <header>
        <div class="logo">Timolina</div>
        <div class="search-bar">
            <input type="text" placeholder="Pesquise por produtos" oninput="filtrarProdutos()">
            <button class="search-button" onclick="filtrarProdutos()">🔍</button>
        </div>
        <div class="user-options">
            <a href="login.jsp">Entre</a>
            <a href="register.jsp">Registre-se</a>
            <a href="meusPedidos.jsp">Meus Pedidos</a>
        </div>
    </header>

    <main>
        <section class="ofertas">
            <h2>Ofertas da semana</h2>
            
            <div class="product">
                <img src="../imgs/coca.png" alt="Coca Cola Lata" width="100">
                <p>Coca Cola lata 269ml</p>
                <p>R$ 4,00</p>
                <button onclick="adicionarAoCarrinho('Coca Cola lata 269ml', 4.00)">ADICIONAR</button>
            </div>

            <div class="product">
                <img src="../imgs/coca.png" alt="Coca Cola Lata" width="100">
                <p>Coca Cola lata 269ml</p>
                <p>R$ 4,00</p>
                <button onclick="adicionarAoCarrinho('Coca Cola lata 269ml', 4.00)">ADICIONAR</button>
            </div>
            
            <div class="product">
                <img src="../imgs/coca.png" alt="Coca Cola Lata" width="100">
                <p>Coca Cola lata 269ml</p>
                <p>R$ 4,00</p>
                <button onclick="adicionarAoCarrinho('Coca Cola lata 269ml', 4.00)">ADICIONAR</button>
            </div>
            
            <div class="product">
                <img src="../imgs/coca.png" alt="Coca Cola Lata" width="100">
                <p>Coca Cola lata 269ml</p>
                <p>R$ 4,00</p>
                <button onclick="adicionarAoCarrinho('Coca Cola lata 269ml', 4.00)">ADICIONAR</button>
            </div>
        </section>
    </main>
</body>
</html>
