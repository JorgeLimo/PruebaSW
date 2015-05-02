<%@ include file="header.jsp" %>
<% String error_mensaje = (String)request.getAttribute("mensaje"); 
	if(error_mensaje != null){
%>
	<div class="alert alert-danger" role="alert"><%= error_mensaje %></div>
<%	}%>