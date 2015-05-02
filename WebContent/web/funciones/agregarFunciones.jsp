<%@page import="bean.CineBean"%>
<%@page import="bean.PeliculaBean"%>
<%@ include file="../header.jsp" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Vector"%>

<%



	Vector<CineBean> cine = (Vector<CineBean>)request.getAttribute("cineListar");
Vector<PeliculaBean> pelicula = (Vector<PeliculaBean>)request.getAttribute("peliculaListar");
%>


<meta http-equiv="content-type" content="text/html; charset=utf-8"/>

<link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css"/>
	

	
	<form action="FuncionRegistrar" method="post" name="form">
		<h2>Agregar Funcion</h2><br clear="all" /><br clear="all" />
		<div class="form-group">
			<label for="nombre" class="col-sm-2 control-label">Nombre Pelicula</label>
			
			<select name="pelicula" id="pelicula" >
			<option>Seleccione</option>
			<%	for(int i=0;i<pelicula.size();i++){ %>
            <option value=<%=pelicula.get(i).getId_pelicula()%>><%= pelicula.get(i).getNombre() %></option>
	         <% } %>
	         </select>
       
	  	</div>
		
		<div class="form-group">
	  		<label for="direccion" class="col-sm-2 control-label">Nombre Cine</label>
	  		
	  		<select name="cine" id="cine">
			<option>Seleccione</option>
			<%	for(int i=0;i<cine.size();i++){ %>
            <option value=<%=cine.get(i).getId_cine()%>><%= cine.get(i).getNombre() %></option>
	         <% } %>
	         </select>
		</div>
		
	  		<label for="fecha" class="col-sm-2 control-label">Hora y fecha</label>
	  		
	     	<input type="text" class="some_class" value="" id="some_class_1" name="fecha"/>
	   

		
		<div>
		 &nbsp;
		 </div>
		<div class="form-group">	
			<label for="tipo" class="col-sm-2 control-label">Tipo funcion</label>
	  		


			<select name="tipo" id="tipo">
			<option>Seleccione</option>
		
            <option value="Digital Idioma Original">Digital Idioma Original</option>
             <option value="3D">3D</option>
              <option value="4D">4D</option>
              <option value="HD">HD</option>
              <option value="FULL HD">FULL HD</option>
	        
	         </select>


	  		
		</div>
			<button  name="ticket" id="clickPrice" class="btn-large clickSubmit btn btn-primary" type="submit">Guardar</button>
			
		
	</form>
</body>

<script src="js/jquery.js"></script>
<script src="js/jquery.datetimepicker.js"></script>
<script src="js/date.js"></script>

</html>