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
							<img src="/projetoweb/images/users/${imgUsuario}.jpg" alt="user-img" onerror="imgError(this);"
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
					<li><a href="/projetoweb/usuario" class="waves-effect">Gerenciar
							Usuários</a></li>
					<li><a href="/projetoweb/livros" class="waves-effect"></i>Gerenciar
							Livros</a></li>
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
					<div class="col-lg-12">
						<h4 class="page-title">Gerenciar livros</h4>
						<ol class="breadcrumb">
							<li><a href="#">Dashboard</a></li>
							<li class="active">Livro</li>
						</ol>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- row -->

				<div class="row">

					<div class='col-sm-8 col-md-8'>

						<table class='table'>
							<thead>
								<tr>
									<th>ID</th>
									<th>Nome</th>
									<th>Valor</th>
									<th>Autor</th>
									<th>ISBN</th>
									<th>Quantidade</th>

									
									<c:if test="${admin eq true}">
									<th></th>
										<th><a href="/projetoweb/livros/cadastrar"
											class="btn btn-success">Novo</a></th>
									</c:if>
								</tr>
							</thead>


							<tbody id="user-list">
								<c:forEach var="livro" items="${livros}">
									<tr>
										<td><c:out value="${livro.id}" /></td>
										<td><c:out value="${livro.nome}" /></td>
										<td><c:out value="${livro.valor}" /></td>
										<td><c:out value="${livro.autor}" /></td>
										<td><c:out value="${livro.ISBN}" /></td>
										<td><c:out value="${livro.quantidade}" /></td>
										<td></td>
										<c:if test="${admin eq true}">
											<td><a class="btn btn-success"
												href="/projetoweb/livros/${livro.id }"> Editar</a></td>

											<td>
												<form action="/projetoweb/livros" method="POST">
													<input type="hidden" name="_method" value="DELETE"><input
														type="hidden" name="id" value="${livro.id}" /> <input
														onclick="return confirm('Tem certeza de que deseja excluir este item?');"
														class="btn btn-success" value="Excluir" type="submit" />
												</form>
											</td>
										</c:if>

									</tr>
								</c:forEach>
							</tbody>

						</table>



					</div>
				</div>
			</div>
			<!-- /.container-fluid -->
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