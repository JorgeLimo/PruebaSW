<%@page import="bean.CineBean"%>
<%@page import="java.util.Vector"%>
<%@ include file="../header.jsp" %>
<a href="CineAgregar" class="btn btn-primary">Agregar Cine</a>
<%
	Vector<CineBean> cine = (Vector<CineBean>)request.getAttribute("cine");
%>
<table class="table table-bordered table-condensed">
	<tr>
		<th>Nombre</th>
		<th>Dirección</th>
		<th>Acciones</th>
	</tr>
<% for(int i = 0; i < cine.size(); ++i){ %>
	<tr>
		<td><%= cine.get(i).getNombre() %></td>
		<td><%= cine.get(i).getDireccion() %></td>
		<td><a href="CineEditar?id=<%= cine.get(i).getId_cine() %>" class="glyphicon glyphicon-edit"></a> <a onclick="return confirm('Esta seguro de eliminar?')" href="CineEliminar?id=<%= cine.get(i).getId_cine() %>" class="glyphicon glyphicon-remove"></a></td>
	</tr>
<%} %>

</body>
</html>