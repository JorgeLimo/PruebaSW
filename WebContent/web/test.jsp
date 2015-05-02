<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% String raiz = (String)request.getAttribute("raiz"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Cinepapaya Boletería</title>
	
	<link rel="stylesheet" href="<%=raiz %>/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=raiz %>/css/bootstrap-theme.min.css">
	
	<script src="<%=raiz %>/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<table class="table table-striped">
		<thead>
		<tr>
			<th>Producto</th>
			<th>Descripción</th>
			<th>Precio</th>
			<th>Cantidad</th>
			<th>Subtotal</th>
		</tr>
		</thead>
		<tbody>
		<tr>
			<td>Combo 1</td>
			<td></td>
			<td>Otto</td>
			<td>@mdo</td>
			<td>@mdo</td>
		</tr>
		<tr>
			<td>2</td>
			<td>Jacob</td>
			<td>Thornton</td>
			<td>@fat</td>
			<td>@mdo</td>
		</tr>
		<tr>
			<td>3</td>
			<td>Larry</td>
			<td>the Bird</td>
			<td>@twitter</td>
			<td>@mdo</td>
		</tr>
		</tbody>
	</table>		
</div>
</body>
</html>