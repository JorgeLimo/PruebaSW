<%@ include file="../header.jsp" %>
<% String error_mensaje = (String)request.getAttribute("mensaje"); 
		if(error_mensaje != null){
	%>
	<div class="alert alert-danger" role="alert"><%= error_mensaje %></div>
	<%	}%>

	<form action="ClienteAgregar" method="post">
		<h2>Agregar Cliente</h2><br clear="all" /><br clear="all" />
		<div class="form-group">
			<label for="nombre" class="col-sm-2 control-label">Nombre</label>
			<div class="col-sm-10">
	    		<input type="text" name="nombre" class="form-control" id="nombre" placeholder="Nombre">
	    	</div>
	  	</div>
		<br clear="all" /><br clear="all" />
		<div class="form-group">
			<label for="apellido" class="col-sm-2 control-label">Apellido</label>
			<div class="col-sm-10">
	    		<input type="text" name="apellido" class="form-control" id="apellido" placeholder="Apellido">
	    	</div>
	  	</div>
		<br clear="all" /><br clear="all" />
		<div class="form-group">
			<label for="correo" class="col-sm-2 control-label">Correo</label>
			<div class="col-sm-10">
	    		<input type="text" name="correo" class="form-control" id="correo" placeholder="Correo">
	    	</div>
	  	</div>
	  	<br clear="all" /><br clear="all"/>
	  	<div class="form-group">
			<label for="clave" class="col-sm-2 control-label">Clave</label>
			<div class="col-sm-10">
	    		<input type="password" name="clave" class="form-control" id="clave" placeholder="clave">
	    	</div>
	  	</div>
		<p class="text-right">
			<button name="ticket" id="clickPrice" class="btn-large clickSubmit btn btn-primary" type="submit">Guardar</button>
			
		</p>
	</form>
<script>
function validateEmail(email) 
{
    var re = /\S+@\S+\.\S+/;
    return re.test(email);
}
$(document).ready(function(){
	$("[type=\"submit\"]").click(function(){
		if(!validateEmail($('#correo').val()))
		{
			alert("El correo no es válido");
			return false;
		}
		if(!($("#clave").val().length > 5 && $("#clave").val().length < 11))
		{
			alert("La contraseña debe tener más de 6 caracteres y menos de 11");
			return false;
		}
		
		return true;
	});
});
</script>
</body>
</html>