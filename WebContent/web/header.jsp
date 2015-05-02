<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Cinepapaya Boletería</title>
	
	<link rel="stylesheet" href="<%=application.getContextPath() %>/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=application.getContextPath() %>/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="<%=application.getContextPath() %>/css/jquery-ui.min.css">
	
	<script src="<%=application.getContextPath() %>/js/jquery.js"></script>
	<script src="<%=application.getContextPath() %>/js/bootstrap.min.js"></script>
	<script src="<%=application.getContextPath() %>/js/jquery-ui.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default navbar-static-top" role="navigation">
  <div class="container">
    	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      <li><img alt="Brand" src="http://www.papaya.pe/themes/cinepapaya-responsive/assets/img/logo.png" width="125px"></li>
        <li><a href="Home">Catelera</a></li>
     <!--    <li><a href="Sincronizar">Actualizar Cartelera</a></li> -->
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Mantener <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="ClienteListar">Clientes</a></li>
            <li class="divider"></li>
            <li><a href="PeliculaListar">Películas</a></li>
            <li class="divider"></li>
            <li><a href="CineListar">Cines</a></li>
             <li class="divider"></li>
            <li><a href="FuncionAgregar">Funciones</a></li>
          
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Reportes <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="ReporteTickets">Tickets Vendidos</a></li>
          </ul>
        </li>
      </ul>
      </div>
  </div>
</nav>
<div class="container">