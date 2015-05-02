<%@page import="bean.ClienteBean"%>
<%@ include file="../header.jsp" %>
<%
	ClienteBean cliente = (ClienteBean)request.getAttribute("cliente");
%>
	<form action="ClienteEditar" method="post">
		<h2>Editar Cliente</h2><br clear="all" /><br clear="all" />
		<div class="form-group">
			<label for="nombre" class="col-sm-2 control-label">Nombre</label>
			<div class="col-sm-10">
	    		<input type="text" name="nombre" class="form-control" id="nombre" placeholder="Nombre" value="<%=cliente.getNombre() %>">
	    	</div>
	  	</div>
		<br clear="all" /><br clear="all" />
		<div class="form-group">
			<label for="apellido" class="col-sm-2 control-label">Apellido</label>
			<div class="col-sm-10">
	    		<input type="text" name="apellido" class="form-control" id="apellido" placeholder="Apellido" value="<%=cliente.getApellido() %>">
	    	</div>
	  	</div>
		<br clear="all" /><br clear="all" />
		<div class="form-group">
			<label for="correo" class="col-sm-2 control-label">Correo</label>
			<div class="col-sm-10">
	    		<input type="text" name="correo" class="form-control" id="correo" placeholder="Correo" value="<%=cliente.getCorreo() %>">
	    	</div>
	  	</div>
	  	<br clear="all" /><br clear="all"/>
	  	<div class="form-group">
			<label for="clave" class="col-sm-2 control-label">Clave</label>
			<div class="col-sm-10">
	    		<input type="password" name="clave" class="form-control" id="clave" placeholder="clave"  value="<%=cliente.getClave() %>">
	    	</div>
	  	</div>
		<p class="text-right">
		<input type="hidden" name="id"  value="<%=cliente.getId_cliente() %>"/>
			<button name="ticket" id="clickPrice" class="btn-large clickSubmit btn btn-primary" type="submit">Guardar</button>
			
		</p>
	</form>
</body>
</html>