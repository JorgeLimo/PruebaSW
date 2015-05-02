<%@page import="bean.FuncionBean"%>
<%@page import="bean.CineBean"%>
<%@page import="bean.PeliculaBean"%>
<%@page import="bean.PeliDesc"%>
<%@page import="java.util.Vector"%>

<%
	FuncionBean funcion = (FuncionBean)request.getAttribute("funcion");
	PeliDesc dsc = (PeliDesc)request.getAttribute("desc");
%>
	
	<div class="col-md-3">        
		<div class="panel panel-default">
		    <div class="panel-body">
		                                      
		        <div class="panel-panel-default">
		            <div class="panel-body">
		                <img src="<%= funcion.getPelicula().getPoster() %>" height="452" width="300" alt="" class="img-responsive thumbnail center-block">
		            </div>
		        </div>		    
		        <div class="panel panel-default th-bg-snow">
		            <div class="panel-body  btn-warning">
		                <div class="panel panel-default">
		                    <div class="panel-body btn-default">
		                        <dl style="margin:0" class="th-dt-title">
		                            <dd><strong><%= funcion.getCine().getNombre() %></strong></dd>
		                            <dd><strong>Fecha y hora: </strong><%= funcion.getFecha_hora() %></dd>
		                            <dd><strong><%= funcion.getPelicula().getNombre() %></strong></dd>
		                            <dd><%= funcion.getTipo() %></dd>
		                        </dl>
		                    </div>
		                </div>
		            </div>
		        </div>			    
			</div>
		</div>      
	</div>