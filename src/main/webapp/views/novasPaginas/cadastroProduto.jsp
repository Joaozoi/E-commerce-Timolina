<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <form action="/TIMOLINAZOIO/ProdutoServlet" method="post" enctype="multipart/form-data">
            <label for="nome">Nome</label>
            <input type="text" id="nome" name="nome" required>

            <label for="valor">Valor</label>
            <input type="number" id="valor" name="valor" required placeholder="R$">

            <label for="categoria">Categoria</label>
            <input type="text" id="categoria" name="categoria" required>

            <label for="marca">Marca</label>
            <input type="text" id="marca" name="marca" required>

            <label for="imagem">Imagem</label>
            <input type="file" id="imagem" name="imagem" required>

            <button type="submit">Cadastrar</button>
        </form>

       
     
    </main>

</body>
</html>