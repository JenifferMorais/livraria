<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Login</title>

</head>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="/projetoweb/css/styleLogin.css" rel="stylesheet">
<!------ Include the above in your HEAD tag ---------->

<body>


	<div id="login">
		<h3 class="text-center text-white pt-5"></h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form action="/projetoweb/usuario/logar" id="login-form"
							class="form" method="post">
							<br>
							<h3 class="text-center text-info">Login</h3>
							
							 <br>
							<c:if test="${erro ne null }">
								<div class="erro">
									<c:out value="${erro}"></c:out>
								</div>
							</c:if>
							<br>
							<div class="form-group">
								<label for="email" class="text-info">Email:</label><br> <input
									type="email" name="email" data-ls-module="charCounter"
									maxlength="100" id="email" class="form-control">
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Senha:</label><br>
								<input type="password" name="password" id="password"
									data-ls-module="charCounter" maxlength="100"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="remember-me" class="text-info"><span><input
										id="remember-me" name="remember-me" type="checkbox"></span> <span>Lembrar
										usuário</span></label><br>

								<button type="submit" class="btn btn-info btn-md">Enviar</button>
							</div>
							<div id="register-link" class="text-right">
								<a href="http://localhost:8080/projetoweb/usuario/cadastrar"
									class="text-info">Registre-se aqui!</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>