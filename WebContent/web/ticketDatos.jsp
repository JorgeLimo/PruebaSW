<%@ include file="header.jsp" %>
<%@ include file="movieInfo.jsp" %>
	<div class="panel panel-primary col-md-8">
	<h2>Proceso de Compra - Ingresa a tu Cuenta</h2>
	<% String error_mensaje = (String)request.getAttribute("error_mensaje"); 
		if(error_mensaje != null){
	%>
	<div class="alert alert-danger" role="alert"><%= error_mensaje %></div>
	<%	}%>
		<form action="TicketMetodoPago" method="post">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Usuario</label>
				<div class="col-sm-10">
      				<input type="text" name="usuario" class="form-control" id="inputEmail3" placeholder="usuario">
    			</div>
  			</div>
  			<br clear="all" /><br clear="all" />
	  		<div class="form-group">
	    		<label for="inputPassword3" class="col-sm-2 control-label">Contraseña</label>
	    		<div class="col-sm-10">
	      			<input type="password" name="password" class="form-control" id="inputPassword3" placeholder="Password">
	    		</div>
	  		</div>
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