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

import bean.FuncionBean;
import bean.TicketBean;
import bean.TicketExtraBean;
import dao.interfaces.FuncionDAO;
import dao.interfaces.TicketDAO;
import daofactory.DaoFactory;

/**
 * Servlet implementation class TicketResumen
 */
@WebServlet("/TicketResumen")
public class TicketResumen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketResumen() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("ticket") == null)
			{
				response.sendRedirect("Ticket?i=2");
			}
			
			TicketBean ticket = (TicketBean)session.getAttribute("ticket");
			ticket.setEstado("reservado");
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			TicketDAO ticketDao = dao.getTicketDao();
			int id = ticketDao.save(ticket);
			
			ticket.setId_ticket(id);
			
			session.setAttribute("ticket", ticket);
						
			request.setAttribute("funcion", ticket.getFuncion());
			request.setAttribute("ticket", ticket);
			
			getServletContext().getRequestDispatcher("/web/ticketResumen.jsp").forward(request, response);
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}
