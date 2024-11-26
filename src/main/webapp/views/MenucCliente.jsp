<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Página Inicial</title>
    <link rel="stylesheet" href="../styles/MenuCliente.css">
</head>
<body>
    
    
    <header>
        <div class="logo">Timolina</div>
       
        <div class="search-bar">
            <input type="text" placeholder="Pesquise por produtos">
            <button class="search-button"></button>
        </div>
        <div class="user-options">
            <a href="login.jsp">Entre </a>
            <a href="register.jsp">Registre-se </a>
            
            
            <a href="meusPedidos.jsp">Meus Pedidos </a>
        </div>
    </header>

    <main>
        <section class="ofertas">
            <h2>Ofertas da semana</h2>
            <div class="carousel">
                <button class="arrow left"></button>
                <div class="product">
                    <img src="../imgs/coca.png" alt="Coca Cola Lata" width="100">
                    <p>Coca Cola lata 269ml</p>
                    <p>R$ 4,00</p>
                    <button>ADICIONAR</button>
                </div>
                <div class="product">
                    <img src="../imgs/coca.png" alt="Coca Cola Lata" width="100">
                    <p>Coca Cola lata 269ml</p>
                    <p>R$ 4,00</p>
                    <button>ADICIONAR</button>
                </div>
                <div class="product">
                    <img src="../imgs/coca.png" alt="Coca Cola Lata" width="100">
                    <p>Coca Cola lata 269ml</p>
                    <p>R$ 4,00</p>
                    <button>ADICIONAR</button>
                </div>
                <div class="product">
                    <img src="../imgs/coca.png" alt="Coca Cola Lata" width="100">
                    <p>Coca Cola lata 269ml</p>
                    <p>R$ 4,00</p>
                    <button>ADICIONAR</button>
                </div>
                <button class="arrow right"></button>
            </div>
            <button class="ver-mais">VER MAIS</button>
        </section>
    </main>
</body>
</html>
    


