<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form action="/TIMOLINAZOIO/LoginServlet" method="post">
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" required><br><br>

        <label for="senha">Senha:</label>
        <input type="password" name="senha" id="senha" required><br><br>

        <button type="submit">Entrar</button>
    </form>
    <p><a href="register.jsp">Ainda não tem conta? Registre-se aqui</a></p>
</body>
</html>
