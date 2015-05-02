<%@page import="bean.ClienteBean"%>
<%@page import="java.util.Vector"%>
<%@ include file="../header.jsp" %>
<a href="ClienteAgregar" class="btn btn-primary">Agregar Cliente</a>
<%
	Vector<ClienteBean> cliente = (Vector<ClienteBean>)request.getAttribute("cliente");
%>
<table class="table table-bordered table-condensed">
	<tr>
		<th>Apellido, Nombre</th>
		<th>Correo</th>
		<th>Acciones</th>
	</tr>
<% for(int i = 0; i < cliente.size(); ++i){ %>
	<tr>
		<td><%= cliente.get(i).getApellido() %>, <%= cliente.get(i).getNombre() %></td>
		<td><%= cliente.get(i).getCorreo() %></td>
		<td><a href="ClienteEditar?id=<%= cliente.get(i).getId_cliente() %>" class="glyphicon glyphicon-edit"></a> <a onclick="return confirm('Esta seguro de eliminar?')" href="ClienteEliminar?id=<%= cliente.get(i).getId_cliente() %>" class="glyphicon glyphicon-remove"></a></td>
	</tr>
<%} %>

</body>
</html>