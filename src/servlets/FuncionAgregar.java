package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CineBean;
import bean.PeliculaBean;
import daofactory.DaoFactory;

/**
 * Servlet implementation class FuncionAgregar
 */
@WebServlet("/FuncionAgregar")
public class FuncionAgregar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuncionAgregar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
		PrintWriter out = response.getWriter();
		try {			
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			List<CineBean> cineSala = dao.getCineDao().all();
			if(cineSala!=null){
				System.out.print("si entro");
			}
			
			request.setAttribute("cineListar", cineSala);
			
			
			
			DaoFactory dao2 = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			Vector<PeliculaBean> pelicula = dao2.getPeliculaDao().all();
			request.setAttribute("peliculaListar", pelicula);
			
			
			
			//luegoo!!!
			getServletContext().getRequestDispatcher("/web/funciones/agregarFunciones.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			out.print(e.getMessage());
		}
	
	
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

		
	
	}

}
