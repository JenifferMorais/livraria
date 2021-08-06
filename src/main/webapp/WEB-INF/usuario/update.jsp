<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords"
        content="wrappixel, admin dashboard, html css dashboard, web dashboard, bootstrap 4 admin, bootstrap 4, css3 dashboard, bootstrap 4 dashboard, severny admin bootstrap 4 dashboard, frontend, responsive bootstrap 4 admin template, my admin design, my admin dashboard bootstrap 4 dashboard template">
    <meta name="description"
        content="My Admin is powerful and clean admin dashboard template, inpired from Bootstrap Framework">
    <meta name="robots" content="noindex,nofollow">
    <title>My Admin Template by WrapPixel</title>
    <link rel="canonical" href="https://www.wrappixel.com/templates/myadmin-lite/" />
    
    <link rel="icon" type="image/png" sizes="16x16" href="/projetoweb/images/favicon.png">
    
    <link href="/projetoweb/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <link href="/projetoweb/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
   
    <link href="/projetoweb/css/style.min.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
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
        <nav class="navbar navbar-default navbar-static-top" style="margin-bottom: 0">
            <div class="navbar-header"> <a class="navbar-toggle hidden-sm hidden-md hidden-lg "
                    href="javascript:void(0)" data-toggle="collapse" data-target=".navbar-collapse"><i
                        class="ti-menu"></i></a>
                <div class="top-left-part"><a class="logo" href="dashboard.html"><i
                            class="glyphicon glyphicon-fire"></i>&nbsp;<span class="hidden-xs">My Admin</span></a></div>
                <ul class="nav navbar-top-links navbar-left hidden-xs">
                    <li><a href="javascript:void(0)" class="open-close hidden-xs hidden-lg waves-effect waves-light"><i
                                class="ti-arrow-circle-left ti-menu"></i></a></li>
                </ul>
                <ul class="nav navbar-top-links navbar-right pull-right">
                    <li>
                        <form role="search" class="app-search hidden-xs">
                            <input type="text" placeholder="Search..." class="form-control">
                            <a href=""><i class="ti-search"></i></a>
                        </form>
                    </li>
                    <li>
                        <a class="profile-pic" href="#"> <img src="/projetoweb/images/users/hritik.jpg" alt="user-img" width="36"
                                class="img-circle"><b class="hidden-xs"><c:out value="${nomeUsuario}"/></b> </a>
                    </li>
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
                            <input type="text" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button"><i class="ti-search"></i> </button>
                            </span>
                        </div>
                    </li>
                  
                    <li><a href="/projetoweb/usuario" class="waves-effect"><i
							class="ti-layout fa-fw"></i>Gerenciar Usuários</a></li>
					<li><a href="/projetoweb/livros" class="waves-effect"><i
							class="ti-layout fa-fw"></i>Gerenciar Livros</a></li>
                   
                </ul>
                <div class="center p-20">
                    <span class="hide-menu"><a href="http://wrappixel.com/templates/myadmin/" target="_blank"
                            class="btn btn-info btn-block btn-rounded waves-effect waves-light">Home
                     </a></span>
                </div>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.sidebar-collapse -->
    
    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-12">
                    <h4 class="page-title">Editar usuário</h4>
                    <ol class="breadcrumb">
                        <li><a href="#">Dashboard</a></li>
                        <li class="active">Usuário</li>
                    </ol>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- row -->
            <div class="row">
                <div class="col-md-4 col-xs-12">
                    <div class="white-box">
                        <div class="user-bg"> <img width="100%" alt="user" src="/projetoweb/images/large/img1.jpg">
                            <div class="overlay-box">
                                <div class="user-content">
                                    <a href="javascript:void(0)"><img src="/projetoweb/images/users/genu.jpg"
                                            class="thumb-lg img-circle" alt="img"></a>
                                    <h4 class="text-white">${usuario.nome}</h4>
                                    <h5 class="text-white">${usuario.email}</h5>
                                </div>
                            </div>
                        </div>
                        <div class="user-btm-box">
                            
                        </div>
                    </div>
                </div>
                <div class="col-md-8 col-xs-12">
                    <div class="white-box">
                        <form class="form-horizontal form-material" method ="post" action="/projetoweb/usuario/update">
                            <div class="form-group">
                                <label class="col-md-12">Nome</label>
                                <div class="col-md-12">
                                    <input type="text" value="${usuario.nome}" name="nome"
                                        class="form-control form-control-line"> </div>
                            </div>
                            <div class="form-group">
                                <label for="example-email" class="col-md-12">Email</label>
                                <div class="col-md-12">
                                    <input type="email" value="${usuario.email}"
                                        class="form-control form-control-line" name="email" id="example-email">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Password</label>
                                <div class="col-md-12">
                                    <input type="password" value="${usuario.password}" name="password" class="form-control form-control-line">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Telefone</label>
                                <div class="col-md-12">
                                    <input type="text" value="${usuario.telefone}" name="telefone"
                                        class="form-control form-control-line"> </div>
                            </div>
                            
                           
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <input type="hidden" name="_method" value="PUT">
                                    <input type="hidden" name="id" value="${usuario.id}" /> 
                                    <button class="btn btn-success" type="submit">Atualizar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>
<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->
<footer class="footer text-center"> 2020 &copy; Myadmin brought to you by <a
	href="https://www.wrappixel.com/">wrappixel.com</a> </footer>
</div>
<!-- /#wrapper -->
<!-- jQuery -->
<script src="/projetoweb/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="/projetoweb/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Menu Plugin JavaScript -->
<script src="/projetoweb/bower_components/metisMenu/dist/metisMenu.min.js"></script>
<!--Nice scroll JavaScript -->
<script src="/projetoweb/js/jquery.nicescroll.js"></script>
<!--Wave Effects -->
<script src="/projetoweb/js/waves.js"></script>
<!-- Custom Theme JavaScript -->
<script src="/projetoweb/js/myadmin.js"></script>
</body>

</html>