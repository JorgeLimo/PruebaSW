<%@page import="bean.PeliculaBean"%>
<%@ include file="../header.jsp" %>
<%
	PeliculaBean pelicula = (PeliculaBean)request.getAttribute("pelicula");
%>
	<form action="PeliculaEditar" method="post">
		<h2>Editar Película</h2><br clear="all" /><br clear="all" />
		<div class="form-group">
			<label for="nombre" class="col-sm-2 control-label">Nombre</label>
			<div class="col-sm-10">
	    		<input type="text" name="nombre" class="form-control" id="nombre" placeholder="Nombre" value="<%=pelicula.getNombre() %>">
	    	</div>
	  	</div>
		<br clear="all" /><br clear="all" />
		<div class="form-group">
	  		<label for="sinopsis" class="col-sm-2 control-label">Sinopsis</label>
	  		<div class="col-sm-10">
	     			<textarea class="form-control" rows="3" name="sinopsis"><%=pelicula.getSinopsis() %></textarea>
	  		</div>
		</div>
		<br clear="all" /><br clear="all" />
		<div class="form-group">
			<label for="poster" class="col-sm-2 control-label">Poster</label>
			<div class="col-sm-10">
	    		<input type="text" name="poster" class="form-control" id="poster" placeholder="url"  value="<%=pelicula.getPoster() %>">
	    	</div>
	  	</div>
		<p class="text-right">
		<input type="hidden" name="id"  value="<%=pelicula.getId_pelicula() %>"/>
			<button name="ticket" id="clickPrice" class="btn-large clickSubmit btn btn-primary" type="submit">Guardar</button>
			
		</p>
	</form>
</body>
</html>