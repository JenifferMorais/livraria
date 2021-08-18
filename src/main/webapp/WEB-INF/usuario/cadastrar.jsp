<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Cadastro</title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link href="/projetoweb/css/styleLogin.css" rel="stylesheet">
<!------ Include the above in your HEAD tag ---------->
</head>
<body>
	<div id="login">
		<h3 class="text-center text-white pt-5"></h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form action="/projetoweb/usuario/cadastrar" id="login-form"
							class="form" method="post" >
							<h3 class="text-center text-info">Registrar-se</h3>
							<div class="form-group">
								<label for="username" class="text-info">Nome:</label><br>
								<input data-ls-module="charCounter" maxlength="100" type="text" name="nome" id="nome" required="required"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="telefone" class="text-info">Telefone:</label><br>
								<input type="text" data-ls-module="charCounter" maxlength="11" name="telefone" id="telefone" required="required"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="username" class="text-info">Email:</label><br>
								<input data-ls-module="charCounter" maxlength="100" type="email" name="email" id="email" required="required"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Senha:</label><br>
								<input data-ls-module="charCounter" maxlength="100" type="password" name="password" id="password" required="required"
									class="form-control">
							</div>
							<div class="form-group">
							<br>
								<button type="submit" class="btn btn-info btn-md">Enviar</button>
							</div>
							<div id="register-link" class="text-right">
								<a href="http://localhost:8080/projetoweb/usuario/logar"
									class="text-info">Já é um usuário?</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>