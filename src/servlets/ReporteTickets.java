package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ClienteBean;
import bean.TicketBean;
import daofactory.DaoFactory;

/**
 * Servlet implementation class ReporteTickets
 */
@WebServlet("/ReporteTickets")
public class ReporteTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReporteTickets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {			
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			Vector<TicketBean> ticket = dao.getTicketDao().all();
			
			request.setAttribute("ticket", ticket);
			getServletContext().getRequestDispatcher("/web/tickets/listar.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			out.print(e.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
