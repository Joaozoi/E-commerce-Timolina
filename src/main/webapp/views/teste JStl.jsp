<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.sp.senac.model.Produto" %> 



<%@ page import="br.sp.senac.model.Produto" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
    <title>Teste JSTL</title>
</head>
<body>
    <c:if test="${true}">
        <p>O JSTL está funcionando corretamente!</p>
    </c:if>
    
    
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
                </c:forEach>c:forEach>
</body>
</html>
