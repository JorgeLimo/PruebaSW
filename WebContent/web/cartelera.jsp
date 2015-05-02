<%@page import="bean.CineBean"%>
<%@page import="bean.FuncionBean"%>
<%@page import="java.util.Vector"%>
<%@ include file="header.jsp" %>
<%Vector<CineBean> cines = (Vector<CineBean>)request.getAttribute("cines"); 
	Vector<FuncionBean> funcion = (Vector<FuncionBean>)request.getAttribute("funciones");%>
<h1>Selección de Función</h1>
<form action="Home" method="get">
<input type="hidden" name="accion" value="listar">


	<select onchange="this.form.submit()" name="slt_tipo" size="1" id="slt_tipo" style="border-radius:10px; width:200px; height:22px">
		<option value="0">------Seleccionar------</option>
	    <% for(int i=0; i<cines.size(); i++){ %>
		<option value="<%=cines.get(i).getId_cine()%>"><%=cines.get(i).getNombre()%></option>
		<% } %>
	</select>

</form>
<br>
<br>
<%if(funcion!=null){%>
<div class="row">
<%
	for(int i = 0; i < funcion.size(); i++){
%>
  <div class="col-sm-6 col-md-3">
    <div class="thumbnail">
      <img src="<%=funcion.get(i).getPelicula().getPoster() %>" width="200px">
      <div class="caption">
        <h3><%=funcion.get(i).getPelicula().getNombre() %> - <%= funcion.get(i).getTipo() %></h3>
        <p><%= funcion.get(i).getFecha_hora() %></p>
        <p><a href="Ticket?i=<%=funcion.get(i).getId_funcion() %>" class="btn btn-primary" role="button">Comprar Boletos</a> <a href="Ticket?i=<%=funcion.get(i).getId_funcion() %>&c" class="btn btn-default" role="button">Comprar Confitería</a></p>
      </div>
    </div>
  </div>
<%} %>
</div>
<%}%>