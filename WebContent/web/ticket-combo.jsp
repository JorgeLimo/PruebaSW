<%@ include file="header.jsp" %>
<%@ include file="movieInfo.jsp" %>

<%@page import="models.Precio"%>
<%@page import="java.util.Vector"%>

	<div class="panel panel-primary col-md-8">
	<h2>Proceso de Compra - Cantidad de Productos</h2>
		<form action="#" method="post" >
			<table class="table table-bordered table-condensed">
	                <thead>
	               	<tr>
	               		<th>Foto</th>
	                    <th>Tipo</th>
	                    <th colspan="3">Cantidad</th>
	                    <th>Precio</th>
	                    <th>Sub Total</th>
	                </tr>
	                </thead>
	                <tbody>
	                <%
	        			Vector<Precio> precios = (Vector)request.getAttribute("precios");
	        		%>
	        		<% for(int i = 0; i < precios.size(); i++){ %>
	        			<tr>
	        				<td><img src="<%= precios.get(i).getFoto() %>" width="100px" /></td>
	        				<td><%= precios.get(i).getNombre() %></td>
		        			<td class="text-center" width="40">
								<button type="button" class="btn btn-black minus">-</button>
							</td>
							<td class="text-center" width="40">
								<input readonly="true" type="text" style="width:40px" class="count" data-precios="<%= precios.get(i).getPrecio() %>" data-nombre="<%=precios.get(i).getNombre() %>" data-index="<%=precios.get(i).getId_precio() %>" name="precios" index="Price_<%=i %>_quantity" value="0">
							</td>
							<td class="text-center" width="40">
								<button type="button" class="btn btn-black plus">+</button>
							</td>
							<td> S/.  <%= precios.get(i).getPrecio() %></td>
							<td>
								S/. <input type="text" class="amountTotal" readonly="true" style="width:80px" id="amount_ticket_<%=precios.get(i).getId_precio() %>" value="0">
							</td>
						</tr>
	        		<% } %>
	                <tr>
	                    <th colspan="2" style="text-align:right" id="countResult"></th>
	                    <th style="text-align:center" id="count">0</th>
	                    <th colspan="2"></th>
	                    <th>Total S/.<span id="amount">0</span></th>
	                </tr>

	            </tbody>
	        </table>	
                <p class="text-right">
                    <a class="btn btn-danger" onclick="return confirm('Esta seguro de cancelar?')" href="Home">Cancelar</a>
                    <button name="ticket" id="clickPrice" class="btn-large clickSubmit btn btn-primary" type="submit" onclick="return false;">Siguiente</button>                    
                </p>
            </form>
		</div>	
	</div>

</div>

<script type="text/javascript">
    var prices=[
		<% for(int i = 0; i < precios.size(); i++){ %>
			"<%= precios.get(i).getPrecio()  %>"
			<% if(i < precios.size()-1){ %>
			,
			<% } %>
		<% } %>
	];
    //CONTADOR DE ENTRADAS
    $(document).ready(function(){
        total();
        countShow();

        $('.plus').click(function(){
            var value = $(this);
            a=value.parent().parent().find('.count');

            if(quantity() < 10){
                a.val((parseInt(a.val())+1));
                index=a.attr('data-index');
                objprice=prices[index];
                amount=objprice*a.val();
                $('#amount_ticket_'+index).val(amount);
            }

            total();
            countShow();
        });
        $('.minus').click(function(){

            var value = $(this);
            a=value.parent().parent().find('.count');
            if(a.val() > 0){
                a.val((parseInt(a.val())-1));
                index=a.attr('data-index');
                objprice=prices[index];
                amount=objprice*a.val();
                $('#amount_ticket_'+index).val(amount);
            }
            total();
            countShow();
        });

        
        $('#clickPrice').click(function(event){
            if(quantity() == 0){
                alert('Tiene que seleccionar productos');
                event.preventDefault();
            }
            else
            {
            	var precios = [];
            	var i = 0;
            	$('input[name="precios"]').each(function(){
            		precios[i] = $(this).attr("data-index")+"-"+$(this).attr("data-nombre")+"-"+$(this).attr("data-precios")+"-"+$(this).val();
            	    i++;
            	})
            	postIt("TicketDatos", precios);
            	return false;
            }
        });
        


    });


    function quantity()
    {
        var sum = 0;
        $(".count").each(function(){
            sum+=parseInt($(this).val());
        });
        return sum;
    }
    function total()
    {
        var sum = 0;
        $(".amountTotal").each(function(){
            sum+=parseFloat($(this).val());
        });
        $('#amount').html(sum);
    }
    function countShow()
    {
        var sum = 0;
        $(".count").each(function(){
            sum+=parseInt($(this).val());
        });
        $("#count").html(sum);

        if(sum == 10){
            $('#countResult').html('cantidad máxima');
        }else{
            $('#countResult').html('');
        }
    }
    
    function postIt(url, data){

        $('body').append($('<form/>', {
          id: 'jQueryPostItForm',
          method: 'POST',
          action: url
        }));

        for(var i in data){
          $('#jQueryPostItForm').append($('<input/>', {
            type: 'text',
            name: 'precios',
            value: data[i]
          }));
        }

       $('#jQueryPostItForm').submit();
    }
</script>
</body>
</html>