<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Lista de Produtos</title>
</head>
<body>
    <h1>Lista de Produtos</h1>
    <table>
        <thead>
            <tr>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Preço</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
           
            <c:forEach var="produto" items="${produtos}">
                <tr>
                    <td>${produto.nome}</td>
                    <td>${produto.descricao}</td>
                    <td>${produto.preco}</td>
                    <td><a href="detalhesProduto.jsp?id=${produto.id}">Detalhes</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="home.jsp">Voltar à página inicial</a>
</body>
</html>
