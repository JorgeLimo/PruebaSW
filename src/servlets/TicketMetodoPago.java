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

import bean.ClienteBean;
import bean.FuncionBean;
import bean.TicketBean;
import bean.TicketExtraBean;
import dao.interfaces.ClienteDAO;
import dao.interfaces.FuncionDAO;
import daofactory.DaoFactory;

/**
 * Servlet implementation class TicketMetodoPago
 */
@WebServlet("/TicketMetodoPago")
public class TicketMetodoPago extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketMetodoPago() {
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
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");
			
			TicketBean ticket = (TicketBean)session.getAttribute("ticket");
        	//TicketBean ticket = (TicketBean) request.getParamenter("ticket");
			
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			ClienteDAO clienteDao = dao.getClienteDao();
			ClienteBean cliente = clienteDao.login(usuario, password);
			
			request.setAttribute("funcion", ticket.getFuncion());
			if(cliente == null)
			{
				request.setAttribute("error_mensaje", "Por favor, corrija los siguientes errores de ingreso: Usuario no registrado");
				getServletContext().getRequestDispatcher("/web/ticketDatos.jsp").forward(request, response);
			}
			else
			{
				ticket.setCliente(cliente);
				session.setAttribute("ticket", ticket);
				
				getServletContext().getRequestDispatcher("/web/ticketMetodoPago.jsp").forward(request, response);
			}
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}
