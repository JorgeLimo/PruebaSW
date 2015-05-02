<%@page import="bean.TicketBean"%>
<%@page import="java.util.Vector"%>
<%@ include file="../header.jsp" %>
<%
	Vector<TicketBean> ticket = (Vector<TicketBean>)request.getAttribute("ticket");
%>
<table class="table table-bordered table-condensed">
	<tr>
		<th>Número de ticket</th>
		<th>Cliente</th>
		<th>Nombre</th>
		<th>Película</th>
		<th>Fecha de función</th>
		<th>Local</th>
		<th>Total</th>
		<th>Fecha de venta</th>
	</tr>
<% for(int i = 0; i < ticket.size(); ++i){ %>
	<tr>
		<td><%= ticket.get(i).getId_ticket() %></td>
		<td><%= ticket.get(i).getCliente_correo() %></td>
		<td><%= ticket.get(i).getCliente_apellido() %>, <%=ticket.get(i).getCliente_nombre() %></td>
		<td><%= ticket.get(i).getFuncion().getPelicula().getNombre() %></td>
		<td><%= ticket.get(i).getFuncion().getFecha_hora() %></td>
		<td><%= ticket.get(i).getFuncion().getCine().getNombre() %></td>
		<td><%= ticket.get(i).getTotal() %></td>
		<td><%= ticket.get(i).getCreado() %></td>
	</tr>
<%} %>

</body>
</html>