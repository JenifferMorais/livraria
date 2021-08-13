<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>

<title>MyBooks</title>
<link rel="canonical"
	href="https://www.wrappixel.com/templates/myadmin-lite/" />


<link rel="icon" type="image/png" sizes="16x16"
	href="/projetoweb/images/favicon.png">

<link
	href="/projetoweb/bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link
	href="/projetoweb/bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">


<link href="/projetoweb/css/style.min.css" rel="stylesheet">
<link href="/projetoweb/css/complement.css" rel="stylesheet">

<script>
	function imgError(image) {
		image.onerror = "";
		image.src = "/projetoweb/images/books/livro.png";
		return true;
	}
	
	function user(image) {
		image.onerror = "";
		image.src = "/projetoweb/images/users/usuario.png";
		return true;
	}
</script>

<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>
	<!-- Preloader -->
	<div class="preloader">
		<div class="cssload-speeding-wheel"></div>
	</div>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<a class="navbar-toggle hidden-sm hidden-md hidden-lg "
					href="javascript:void(0)" data-toggle="collapse"
					data-target=".navbar-collapse"><i class="ti-menu"></i></a>
				<div class="top-left-part">
					<a class="logo" href="/projetoweb/livros/home"><i
						class="glyphicon glyphicon-book"></i>&nbsp;<span class="hidden-xs">MyBooks</span></a>
				</div>
				<ul class="nav navbar-top-links navbar-left hidden-xs">
					<li><a href="javascript:void(0)"
						class="open-close hidden-xs hidden-lg waves-effect waves-light"><i
							class="ti-arrow-circle-left ti-menu"></i></a></li>
				</ul>
				<ul class="nav navbar-top-links navbar-right pull-right">
					<li>
						<form onsubmit="searchUsers(this)" role="search"
							class="app-search hidden-xs">
							<input type="text" placeholder="Search..." class="form-control">
							<a href=""><i class="ti-search"></i></a>
						</form>
					</li>
					<li class="menu-container"><a class="profile-pic" href="/projetoweb/usuario/perfil">
							<img src="/projetoweb/images/users/${imgUsuario}.jpg" alt="user-img" onerror="user(this);"
							width="36" class="img-circle"><b class="hidden-xs"><c:out
									value="${nomeUsuario}" /></b>
					</a>
						<div class="menu-body">
							<div>
								<ul>
									<li><a href="/projetoweb/usuario/logoff">Sair</a></li>
								</ul>
							</div>
						</div></li>
				</ul>
			</div>
			<!-- /.navbar-header -->
			<!-- /.navbar-top-links -->
			<!-- /.navbar-static-side -->
		</nav>
		<div class="navbar-default sidebar nicescroll" role="navigation">
			<div class="sidebar-nav navbar-collapse ">
				<ul class="nav" id="side-menu">
					<li class="sidebar-search hidden-sm hidden-md hidden-lg">
						<div class="input-group custom-search-form">
							<input type="text" class="form-control" placeholder="Search..."
								id="search-input"> <span class="input-group-btn">
								<button class="btn btn-default" type="button" id="search-button">
									<i class="ti-search"></i>
								</button>
							</span>
						</div>

					</li>
					<li><a href="/projetoweb/livros/home" class="waves-effect">Livros</a></li>
					<li><a href="/projetoweb/usuario/perfil" class="waves-effect">Gerenciar
							Perfil</a></li>
				</ul>
				<div class="center p-20">
					<span class="hide-menu"><a
						href="http://wrappixel.com/templates/myadmin/" target="_blank"
						class="btn btn-info btn-block btn-rounded waves-effect waves-light">Home</a></span>
				</div>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row bg-title">
					<div class="col-lg-12"></div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- row -->
				<div class="row">
					<form class="form-horizontal form-material" method="post"
						action="/projetoweb/livros/update">
						<div class="col-md-4 col-xs-12">
							<div class="white-box">
								<div class="user-bg">
									<img width="100%" alt="user"
										src="/projetoweb/images/large/img1.jpg">
									<div class="overlay-box">
										<div class="user-content">
											<a href="javascript:void(0)"><img
												src="/projetoweb/images/books/${livro.imagem}.jpg"
												onerror="imgError(this);" class="thumb-lg  " alt="img"></a>
											<h4 class="text-white">${livro.nome}</h4>
											<h5 class="text-white">${livro.autor}</h5>

										</div>
									</div>
								</div>
								<div class="user-btm-box">
									<label class="col-md-12">Imagem</label>
									<div class="col-md-12">
										${livro.imagem}
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-8 col-xs-12">
							<div class="white-box">

								<div class="form-group">
									<label class="col-md-12">Nome</label>
									<div class="col-md-12">
										${livro.nome}
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-12">Autor</label>
									<div class="col-md-12">
										${livro.autor}
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Valor</label>
									<div class="col-md-12">
										${livro.valor}
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Descrição</label>
									<div class="col-md-12">
										${livro.descricao}
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-12">ISBN</label>
									<div class="col-md-12">
										${livro.ISBN}
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-sm-12">

										<button
											onclick="return confirm('Deseja confirmar as alterações?');"
											class="btn btn-success" type="submit">Atualizar</button>
									</div>
								</div>

							</div>
						</div>
					</form>
				</div>
				<!-- /.container-fluid -->
			</div>
		</div>

		<!-- /#page-wrapper -->
		<footer class="footer text-center">
			2020 &copy; Myadmin brought to you by <a
				href="https://www.wrappixel.com/">wrappixel.com</a>
		</footer>
	</div>
	<!-- /#wrapper -->
	<!-- jQuery -->
	<script src="/projetoweb/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script
		src="/projetoweb/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Menu Plugin JavaScript -->
	<script
		src="/projetoweb/bower_components/metisMenu/dist/metisMenu.min.js"></script>
	<!--Nice scroll JavaScript -->
	<script src="/projetoweb/js/jquery.nicescroll.js"></script>
	<!--Wave Effects -->
	<script src="/projetoweb/js/waves.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="/projetoweb/js/myadmin.js"></script>
	<script src="/projetoweb/js/function.js"></script>
</body>

</html>