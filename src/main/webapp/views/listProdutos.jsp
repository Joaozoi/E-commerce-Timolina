<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.sp.senac.model.Produto" %> 

<html>
<head>
    <title>Lista de Produtos</title>
</head>
<body>
    <h1>Lista de Produtos</h1>
    
    <% 
        // Verificando se há uma mensagem e exibindo-a
        String mensagem = (String) request.getAttribute("mensagem");
        if (mensagem != null && !mensagem.isEmpty()) {
    %>
        <p><%= mensagem %></p>
    <% } %>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Preço</th>
                <th>Categoria</th>
                <th>Marca</th>
                <th>Estoque</th>
            </tr>
        </thead>
        <tbody>
            <% 
                // Obtendo a lista de produtos do atributo da requisição
                List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
                if (produtos != null) {
                    for (Produto produto : produtos) {
            %>
                <tr>
                    <td><%= produto.getId() %></td>
                    <td><%= produto.getNome() %></td>
                    <td><%= produto.getDescricao() %></td>
                    <td><%= produto.getPreco() %></td>
                    <td><%= produto.getCategoria() %></td>
                    <td><%= produto.getMarca() %></td>
                    <td><%= produto.getEstoque() %></td>
                </tr>
            <% 
                    }
                }
            %>
        </tbody>
    </table>
</body>
</html>
