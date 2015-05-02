package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.interfaces.FuncionDAO;
import daofactory.DaoFactory;
import bean.FuncionBean;
import bean.TicketBean;
import bean.TicketExtraBean;

/**
 * Servlet implementation class TicketDatos
 */
@WebServlet("/TicketDatos")
public class TicketDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketDatos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("ticket") == null)
			{
				response.sendRedirect("Ticket?i=2");
			}
			
			Vector<TicketExtraBean> ticket_extras = new Vector<TicketExtraBean>();
				
			String[] precios = request.getParameterValues("precios");
			for(int i = 0; i < precios.length; ++i)
			{
				String[] p = precios[i].split("-");//id-nombre-precio-cantidad
				if(Integer.parseInt(p[3]) > 0)
				{
					TicketExtraBean ticket_extra = new TicketExtraBean();
					ticket_extra.setNombre(p[1]);
					ticket_extra.setCantidad(Integer.parseInt(p[3]));
					ticket_extra.setPrecio_unitario(Double.parseDouble(p[2]));
					
					ticket_extras.add(ticket_extra);
				}
			}
			
			TicketBean ticket = (TicketBean)session.getAttribute("ticket");
			ticket.setTicket_extra(ticket_extras);
			
			session.setAttribute("ticket", ticket);
			request.setAttribute("funcion", ticket.getFuncion());
			
			getServletContext().getRequestDispatcher("/web/ticketDatos.jsp").forward(request, response);
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}
