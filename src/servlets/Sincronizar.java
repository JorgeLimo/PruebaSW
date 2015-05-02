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

import models.Peliculas;
import bean.SyncBean;
import bean.TicketBean;
import dao.interfaces.PeliculaDAO;
import dao.interfaces.SyncDAO;
import dao.interfaces.TicketDAO;
import daofactory.DaoFactory;

/**
 * Servlet implementation class Sincronizar
 */
@WebServlet("/Sincronizar")
public class Sincronizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sincronizar() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Vector<Peliculas> peliculas = new Peliculas().getPeliculas();
			
			request.setAttribute("peliculas", peliculas);
			getServletContext().getRequestDispatcher("/web/peliculas.jsp").forward(request, response);
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			String[] id 			= request.getParameterValues("id");
			String[] nombre_cine 	= request.getParameterValues("nombre_cine");
			String[] pelicula 		= request.getParameterValues("pelicula");
			String[] tipo 			= request.getParameterValues("tipo");
			
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			SyncDAO syncDao = dao.getSyncDao();
			PeliculaDAO pelDao = dao.getPeliculaDao();
			
			boolean flag = false;
			for(int i = 0; i < id.length; ++i)
			{
				if(pelicula[i].length() > 0)
				{
					SyncBean sync = new SyncBean();
					sync.setId_cine(1);
					sync.setId_pelicula(pelDao.find(pelicula[i]).get(0).getId_pelicula());
					sync.setId_proveedor_pelicula(id[i]);
					sync.setNombre_proveedor_pelicula(nombre_cine[i]);
					sync.setTipo(tipo[i]);
					System.out.println(pelicula[i]);
					flag = syncDao.save(sync);
				}
				else
				{
					flag = false;
				}
			}
			if(flag)
			{
				request.setAttribute("mensaje", "Sincronización completa.");
			}
			else
			{
				request.setAttribute("mensaje", "Hubo un error al intentar hacer la sincronización. Revise que ingresó todos los campos. Inténtelo nuevamente.");
			}
			
			getServletContext().getRequestDispatcher("/web/mensaje.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("mensaje", "Hubo un error al intentar hacer la sincronización. Sobrepasó conexiones");
			getServletContext().getRequestDispatcher("/web/mensaje.jsp").forward(request, response);
		}
	}

}
