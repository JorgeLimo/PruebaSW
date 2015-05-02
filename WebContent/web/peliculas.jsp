<%@ include file="header.jsp" %>

<%@page import="java.util.Vector"%>
<%@page import="models.Peliculas"%>
<h1>Actualizar Cartelera</h1>
	<div class="panel panel-primary col-md-12">
	<form action="" method="post">
		<table class="table table-bordered table-condensed">
			<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Nombre Cinepapaya</th>
				<th>Tipo Cinepapaya</th>
			</tr>
			</thead>
			<tbody>
			<%
				Vector<Peliculas> peliculas = (Vector)request.getAttribute("peliculas");
			%>
			<% for(int i = 0; i < peliculas.size(); i++){ %>
				<tr>
					<td><%= peliculas.get(i).getId() %><input type="hidden" name="id" value="<%= peliculas.get(i).getId() %>" /></td>
					<td><%= peliculas.get(i).getNombre() %><input type="hidden" name="nombre_cine" value="<%= peliculas.get(i).getNombre() %>" /></td>
					<td><input type="text" class="topic_title" name="pelicula"/></td>
					<td><input type="text" name="tipo" /></td>
				</tr>
			<% } %>
			</tbody>
		</table>
		<button name="ticket" id="clickPrice" class="btn-large clickSubmit btn btn-primary" type="submit">Siguiente</button>
	</form>
	</div>	      
</div>
<script>
$(document).ready(function(){
	$( ".topic_title" ).autocomplete({
		source: "PeliculsList",
	});
}); 
</script>