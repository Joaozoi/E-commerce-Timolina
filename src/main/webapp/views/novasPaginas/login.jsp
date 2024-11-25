<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Login.css">
</head>
<body>
<div class="container">
        <h1 class="title">Timolina</h1> 
        <h2>Login</h2>
       
        

        	<form action="/TIMOLINAZOIO/LoginServlet" method="post"> <!-- Linkar corretamente e fazer um if para levar para tela de funcionario -->
            <label for="email">Informe seu E-mail:</label>
            <input type="email" name="email" required><br>

            <label for="senha">Informe sua senha:</label>
            <input type="password" name="senha" required><br>

            <a href="" class="forgot-password">Esqueci minha senha</a> 
            
            <a href="${pageContext.request.contextPath}/views/MenuFuncionario.jsp"><button type="submit">Entrar</button></a>
            
            
        </form>
        
      <div class="register-link">
    <p>Novo no Timolina?</p>
    <a href="${pageContext.request.contextPath}/views/novasPaginas/registrar.jsp">Crie sua conta Timolina</a> 
</div>

    </div>

</body>
</html>