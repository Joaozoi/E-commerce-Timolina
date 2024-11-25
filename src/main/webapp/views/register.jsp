<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Registro</title>
</head>
<body>
    <h1>Cadastro de Cliente</h1>
    <form action="/TIMOLINAZOIO/RegisterServlet" method="post">
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" required><br><br>

        <label for="senha">Senha:</label>
        <input type="password" name="senha" id="senha" required><br><br>

        <label for="nome">Nome:</label>
        <input type="text" name="nome" id="nome" required><br><br>

        <label for="endereco">Endereço:</label>
        <input type="text" name="endereco" id="endereco" required><br><br>

        <button type="submit">Cadastrar</button>
    </form>
    <p><a href="login.jsp">Já tem uma conta? Faça login aqui</a></p>
</body>
</html>
