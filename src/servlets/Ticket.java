package servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Precio;
import bean.*;
import dao.interfaces.FuncionDAO;
import dao.interfaces.PeliculaDAO;
import daofactory.DaoFactory;

/**
 * Servlet implementation class Ticket
 */
@WebServlet("/Ticket")
public class Ticket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ticket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("i");
		String c = request.getParameter("c");
		
		int cod = Integer.parseInt(id);
		boolean combo = true;
		if(c != null)
		{
			combo = false;
		}
		
		HttpSession session = request.getSession();		
		
		DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
		FuncionDAO funcionDao = dao.getFuncionDao();
		FuncionBean funcion = funcionDao.find(Integer.parseInt(id));
		
		System.out.println(funcion.getCine());
		System.out.println(funcion.getFecha_hora());
		System.out.println(funcion.getId_cine());
		
		
		TicketBean ticket = new TicketBean();
		ticket.setFuncion(funcion);
		session.setAttribute("ticket", ticket);
		
		Precio precio = new Precio();
		Vector<Precio> precios = new Vector<Precio>();
		precios = precio.getPrecios(combo);
		
		DaoFactory dao2 = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
		PeliculaDAO peli = dao2.getPeliculaDao();
		PeliDesc dsc = peli.mostrar(cod);
		
		System.out.println(dsc.getDesc());
		System.out.println(dsc.getUrl());
		
		request.setAttribute("funcion", funcion);
		request.setAttribute("precios", precios);
		request.setAttribute("desc", dsc);
		
		if(combo)
			getServletContext().getRequestDispatcher("/web/ticket.jsp").forward(request, response);
		else
			getServletContext().getRequestDispatcher("/web/ticket-combo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
