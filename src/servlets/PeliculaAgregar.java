package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.interfaces.PeliculaDAO;
import daofactory.DaoFactory;
import bean.PeliculaBean;

/**
 * Servlet implementation class PeliculaAgregar
 */
@WebServlet("/PeliculaAgregar")
public class PeliculaAgregar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeliculaAgregar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/web/peliculas/form.jsp").forward(request, response);
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
			
			PeliculaBean pelicula = new PeliculaBean();
			pelicula.setNombre(nombre);
			pelicula.setSinopsis(sinopsis);
			pelicula.setPoster(poster);
			pelicula.setId_pelicula(0);
			
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			PeliculaDAO peliculaDao = dao.getPeliculaDao();
			boolean r = peliculaDao.save(pelicula);
			
			if(r){
				request.setAttribute("mensaje", "registro satisfactorio");
			}else{
				request.setAttribute("mensaje", "ocurrio un error");
			}
			
			getServletContext().getRequestDispatcher("/web/peliculas/form.jsp").forward(request, response);
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}
