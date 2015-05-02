package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.TarjetaCredito;
import bean.ClienteBean;
import bean.FuncionBean;
import bean.TicketBean;
import dao.interfaces.ClienteDAO;
import dao.interfaces.FuncionDAO;
import dao.interfaces.TicketDAO;
import daofactory.DaoFactory;
import servlets.Mensajeria;;
/**
 * Servlet implementation class TicketFinal
 */
@WebServlet("/TicketFinal")
public class TicketFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketFinal() {
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
			String tc = request.getParameter("tc");
			String cvc = request.getParameter("cvc");
			String mes = request.getParameter("mes");
			String anno = request.getParameter("ann");
			String terms = request.getParameter("terms");
			String correo= request.getParameter("txt_correo");
			TicketBean ticket = (TicketBean)session.getAttribute("ticket");
			
			request.setAttribute("funcion", ticket.getFuncion());
			request.setAttribute("ticket", ticket);
			
			if(terms == null)
			{
				request.setAttribute("error_mensaje", "Debe aceptar los términos y condiciones.");
				getServletContext().getRequestDispatcher("/web/ticketResumen.jsp").forward(request, response);
			
			
			}
			else
			{
				TarjetaCredito tcService = new TarjetaCredito();
				String rp = tcService.validar(tc, cvc, mes, anno);
				
				if(rp == null)
				{
					ticket.setEstado("pagado");
					
					DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
					TicketDAO tickets = dao.getTicketDao();
					tickets.save(ticket);
					
					int al1 = (int)(Math.round(Math.random() * (999-1)+1)) +999; 
					int al2 = (int)(Math.round(Math.random() * (999-1)+1)) +999; 
					String numero="A"+al1+"C"+al2;
					Mensajeria MensajeriaEnviar=new Mensajeria();
					MensajeriaEnviar.enviarMensaje(correo,"SU NUMERO DE TICKET ES: "+numero);	
					getServletContext().getRequestDispatcher("/web/ticketFinal.jsp").forward(request, response);
				
				//akaaaaaaaaaaaaaaaaa
				}
				else
				{
					request.setAttribute("error_mensaje", rp);
					getServletContext().getRequestDispatcher("/web/ticketResumen.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}
