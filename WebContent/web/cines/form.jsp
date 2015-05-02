<%@ include file="../header.jsp" %>
<% String error_mensaje = (String)request.getAttribute("mensaje"); 
		if(error_mensaje != null){
	%>
	<div class="alert alert-danger" role="alert"><%= error_mensaje %></div>
	<%	}%>

	<form action="CineAgregar" method="post">
		<h2>Agregar Cine</h2><br clear="all" /><br clear="all" />
		<div class="form-group">
			<label for="nombre" class="col-sm-2 control-label">Nombre</label>
			<div class="col-sm-10">
	    		<input type="text" name="nombre" class="form-control" id="nombre" placeholder="Nombre">
	    	</div>
	  	</div>
		<br clear="all" /><br clear="all" />
		<div class="form-group">
	  		<label for="direccion" class="col-sm-2 control-label">Dirección</label>
	  		<div class="col-sm-10">
	     			<input type="text" name="direccion" class="form-control" id="direccion" placeholder="Dirección">
	  		</div>
		</div>
		<p class="text-right">
			<button name="ticket" id="clickPrice" class="btn-large clickSubmit btn btn-primary" type="submit">Guardar</button>
			
		</p>
	</form>
</body>
</html>