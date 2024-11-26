<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Produto - Timolina</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/CadastroProduto.css">

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

    <main>
        <h2>Adicionar produto</h2>
       <form action="${pageContext.request.contextPath}/ProdutoServlet" method="post">
    <label for="nome">Nome:</label>
    <input type="text" name="nome" id="nome" required>
    
    <label for="descricao">Descrição:</label>
    <textarea name="descricao" id="descricao"></textarea>
    
    <label for="preco">Preço:</label>
    <input type="text" name="preco" id="preco" required>
    
    <label for="categoria">Categoria:</label>
    <input type="text" name="categoria" id="categoria">
    
    <label for="marca">Marca:</label>
    <input type="text" name="marca" id="marca">
    
    <label for="estoque">Estoque:</label>
    <input type="number" name="estoque" id="estoque" value="0">
    
    <button type="submit">Cadastrar Produto</button>
</form>



       
     
    </main>

</body>
</html>