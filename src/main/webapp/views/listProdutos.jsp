<%@ taglib uri="jakarta.servlet.jsp.jstl.core" prefix="c" %>
<%@ page import="br.sp.senac.model.Produto" %>

<html>
<head>
    <title>Lista de Produtos</title>
</head>
<body>
    <h1>Lista de Produtos</h1>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Preço</th>
            <th>Categoria</th>
            <th>Marca</th>
            <th>Estoque</th>
        </tr>

        <!-- Usando JSTL para iterar sobre a lista de produtos -->
        <c:if test="${not empty produtos}">
            <c:forEach var="produto" items="${produtos}">
                <tr>
                    <td>${produto.id}</td>
                    <td>${produto.nome}</td>
                    <td>${produto.descricao}</td>
                    <td>${produto.preco}</td>
                    <td>${produto.categoria}</td>
                    <td>${produto.marca}</td>
                    <td>${produto.estoque}</td>
                </tr>
            </c:forEach>
        </c:if>

        <!-- Caso a lista de produtos esteja vazia -->
        <c:if test="${empty produtos}">
            <tr>
                <td colspan="7">Nenhum produto encontrado.</td>
            </tr>
        </c:if>
    </table>
</body>
</html>
