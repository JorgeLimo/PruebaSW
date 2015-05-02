<%@page import="bean.TicketBean"%>
<%@ include file="header.jsp" %>
<%@ include file="movieInfo.jsp" %>

<%
	TicketBean ticket = (TicketBean)request.getAttribute("ticket");
%>
	<div class="panel panel-primary col-md-8">
	<h2>Proceso de Compra - Resumen de Compra</h2>
	<% String error_mensaje = (String)request.getAttribute("error_mensaje"); 
		if(error_mensaje != null){
	%>
	<div class="alert alert-danger" role="alert"><%= error_mensaje %></div>
	<%	}%>
		<form action="TicketFinal" method="post">
		
		
			<h2>Datos de Cliente</h2>
			<table class="table table-bordered table-condensed">
			
				<tr>
					<th>Nombre</th>
					<td><%= ticket.getCliente().getNombre() %></td>
					<th>Apellido</th>
					<td><%= ticket.getCliente().getApellido() %></td>
					
				</tr>
				<tr>
					<th>Correo</th>
					<td colspan="3"><%= ticket.getCliente().getCorreo() %></td>
						<input name="txt_correo"   type="hidden" value=<%= ticket.getCliente().getCorreo()%>> 
				</tr>
			</table>
			<hr />
			<h2>Ticket</h2>
			<table class="table table-bordered table-condensed">
				<tr>
					<th>Nombre</th>
					<th>Cantidad</th>
					<th>Precio Unitario</th>
					<th>Total</th>
				</tr>
				<% 
					double totalPagar = 0;
					for(int i = 0; i < ticket.getTicket_extra().size(); ++i){ 
						totalPagar+= ticket.getTicket_extra().get(i).getCantidad()*ticket.getTicket_extra().get(i).getPrecio_unitario();
				%>
				<tr>
					<td><%= ticket.getTicket_extra().get(i).getNombre() %></td>
					<td><%= ticket.getTicket_extra().get(i).getCantidad() %></td>
					<td><%= ticket.getTicket_extra().get(i).getPrecio_unitario() %></td>
					<% double total = (ticket.getTicket_extra().get(i).getPrecio_unitario()*ticket.getTicket_extra().get(i).getCantidad()); %>
					<td><%= total %></td>
				</tr>
				<%} %>
				<tr>
					<th colspan="3">Total a Pagar</th>
					<td><%=totalPagar %></td>
				</tr>
			</table>
			<hr />
			<h2>Datos de Función</h2>
			<table class="table table-bordered table-condensed">
				<tr>
					<th>Película</th>
					<td><%= ticket.getFuncion().getPelicula().getNombre() %></td>
					<th>Tipo de exhibición</th>
					<td><%= ticket.getFuncion().getTipo() %></td>
				</tr>
				<tr>
					<th>Fecha y hora</th>
					<td><%= ticket.getFuncion().getFecha_hora() %></td>
					<th>Local</th>
					<td><%= ticket.getFuncion().getCine().getNombre() %></td>
				</tr>
			</table>
			<hr />
			<h2>Datos de tarjeta</h2>
			<table class="table table-bordered table-condensed">
				<tr>
					<th>Tarjeta de Crédito <img style="margin-left:10px"  src="<%=application.getContextPath() %>/assets/img/car.jpg"></th>
					<td><input type="text" name="tc" /></td>
				</tr>
				<tr>
					<th>CVC</th>
					<td><input type="text" name="cvc" /></td>
				</tr>
				<tr>
					<th>Fecha de expiración</th>
					<td>
						<select name="mes">
							<option value="0">Mes</option>
							<option value="1">Enero</option>
							<option value="2">Febrero</option>
							<option value="3">Marzo</option>
							<option value="4">Abril</option>
							<option value="5">Mayo</option>
							<option value="6">Junio</option>
							<option value="7">Julio</option>
							<option value="8">Agosto</option>
							<option value="9">Septiembre</option>
							<option value="10">Octubre</option>
							<option value="11">Noviembre</option>
							<option value="12">Diciembre</option>
						</select>
						<select name="anno">
							<option value="0">Año</option>
							<option value="2014">2014</option>
							<option value="2015">2015</option>
							<option value="2016">2016</option>
							<option value="2017">2017</option>
							<option value="2018">2018</option>
						</select>
					</td>
				</tr>
			</table>
			<label><input type="checkbox" name="terms" />Acepto los términos y condiciones de compra.</label>
	  		<br clear="all" /><br clear="all" />
			<p class="text-right">
				<a class="btn btn-danger" onclick="return confirm('Esta seguro de cancelar?')" href="Home">Cancelar</a>
				<button name="ticket" id="clickPrice" class="btn-large clickSubmit btn btn-primary" type="submit">Siguiente</button>
			</p>
		</form>
	</div>	
</div>
</body>
</html>