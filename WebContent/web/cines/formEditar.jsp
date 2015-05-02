<%@page import="bean.CineBean"%>
<%@ include file="../header.jsp" %>
<%
	CineBean cine = (CineBean)request.getAttribute("cine");
%>
	<form action="CineEditar" method="post">
		<h2>Cine</h2><br clear="all" /><br clear="all" />
		<div class="form-group">
			<label for="nombre" class="col-sm-2 control-label">Nombre</label>
			<div class="col-sm-10">
	    		<input type="text" name="nombre" class="form-control" id="nombre" placeholder="Nombre" value="<%= cine.getNombre() %>">
	    	</div>
	  	</div>
		<br clear="all" /><br clear="all" />
		<div class="form-group">
	  		<label for="direccion" class="col-sm-2 control-label">Dirección</label>
	  		<div class="col-sm-10">
	     			<input type="text" name="direccion" class="form-control" id="direccion" placeholder="Dirección" value="<%= cine.getDireccion() %>">
	  		</div>
		</div>
		<p class="text-right">
		<input type="hidden" name="id" value="<%= cine.getId_cine() %>"/>
			<button name="ticket" id="clickPrice" class="btn-large clickSubmit btn btn-primary" type="submit">Guardar</button>
			
		</p>
	</form>
</body>
</html>