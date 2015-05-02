<%@ include file="header.jsp" %>
<%@ include file="movieInfo.jsp" %>
	<div class="panel panel-primary col-md-8">
		<form action="TicketResumen" method="post" onsubmit="return validateForm();">
			<h2>Proceso de Compra - Método de Pago</h2><br clear="all" /><br clear="all" />
			<div class="alert alert-info" role="alert">*Recomendado.</div>
			<div class="radio">
		  		<label>
		    		<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
		    		Tarjeta de Crédito
		  		</label>
			</div>
	  		<br clear="all" /><br clear="all" />
			<p class="text-right">
				<a class="btn btn-danger" onclick="return confirm('Esta seguro de cancelar?')" href="Home">Cancelar</a>
				<button name="ticket" id="clickPrice" class="btn-large clickSubmit btn btn-primary" type="submit">Siguiente</button>
			</p>
	</div>	
</div>
<script>
function validateForm(){
	if(!$("[name=\"optionsRadios\"]").is(':checked'))
	{
		alert("Seleccione un medio de Pago");
		return false;
	}
	else
	{
		return true;	
	}
}
</script>
</body>
</html>