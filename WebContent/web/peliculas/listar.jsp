<%@page import="bean.PeliculaBean"%>
<%@page import="java.util.Vector"%>
<%@ include file="../header.jsp" %>
<a href="PeliculaAgregar" class="btn btn-primary">Agregar Película</a>
<%
	Vector<PeliculaBean> pelicula = (Vector<PeliculaBean>)request.getAttribute("pelicula");
%>
<table class="table table-bordered table-condensed">
	<tr>
		<th>Nombre</th>
		<th>Acciones</th>
	</tr>
<% for(int i = 0; i < pelicula.size(); ++i){ %>
	<tr>
		<td><%= pelicula.get(i).getNombre() %></td>
		<td><a href="PeliculaEditar?id=<%= pelicula.get(i).getId_pelicula() %>" class="glyphicon glyphicon-edit"></a> <a onclick="return confirm('Esta seguro de eliminar?')" href="PeliculaEliminar?id=<%= pelicula.get(i).getId_pelicula() %>" class="glyphicon glyphicon-remove"></a></td>
	</tr>
<%} %>

</body>
</html>