<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Detalhes do Produto</title>
</head>
<body>
    <h1>${produto.nome}</h1>
    <p>${produto.descricao}</p>
    <p>Preço: ${produto.preco}</p>

    
    <a href="carrinho.jsp?produtoId=${produto.id}">Adicionar ao Carrinho</a><br>

    <a href="listProdutos.jsp">Voltar para a lista de produtos</a>
</body>
</html>
