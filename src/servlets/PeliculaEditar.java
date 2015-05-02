package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PeliculaBean;
import dao.interfaces.PeliculaDAO;
import daofactory.DaoFactory;

/**
 * Servlet implementation class PeliculaEditar
 */
@WebServlet("/PeliculaEditar")
public class PeliculaEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeliculaEditar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			PeliculaBean pelicula = dao.getPeliculaDao().find(id);
			
			request.setAttribute("pelicula", pelicula);
			getServletContext().getRequestDispatcher("/web/peliculas/formEditar.jsp").forward(request, response);
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
			String nombre = request.getParameter("nombre");
			String sinopsis = request.getParameter("sinopsis");
			String poster = request.getParameter("poster");
			int id = Integer.parseInt(request.getParameter("id"));
			
			PeliculaBean pelicula = new PeliculaBean();
			pelicula.setNombre(nombre);
			pelicula.setSinopsis(sinopsis);
			pelicula.setPoster(poster);
			pelicula.setId_pelicula(id);
			
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			PeliculaDAO peliculaDao = dao.getPeliculaDao();
			boolean r = peliculaDao.save(pelicula);
			
			if(r){
				request.setAttribute("mensaje", "Actualización satisfactoria");
			}else{
				request.setAttribute("mensaje", "ocurrio un error");
			}
			
			getServletContext().getRequestDispatcher("/web/mensaje.jsp").forward(request, response);
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}	
	}
}
