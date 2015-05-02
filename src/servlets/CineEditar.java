package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CineBean;
import dao.interfaces.CineDAO;
import dao.mysql.MySQLSyncDAO;
import daofactory.DaoFactory;

/**
 * Servlet implementation class CineEditar
 */
@WebServlet("/CineEditar")
public class CineEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CineEditar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			int id_cine = Integer.parseInt(request.getParameter("id"));
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			CineBean cine = dao.getCineDao().find(id_cine);
			
			request.setAttribute("cine", cine);
			
			getServletContext().getRequestDispatcher("/web/cines/formEditar.jsp").forward(request, response);
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
			String nombre		= request.getParameter("nombre");
			String direccion	= request.getParameter("direccion");
			int id_cine			= Integer.parseInt(request.getParameter("id"));
			
			CineBean cine = new CineBean();
			cine.setNombre(nombre);
			cine.setDireccion(direccion);
			cine.setId_cine(id_cine);
			
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			CineDAO cineDao = dao.getCineDao();
			boolean r = cineDao.save(cine);
			
			if(r){
				request.setAttribute("mensaje", "Cine editado satisfactoriamente");
			}else{
				request.setAttribute("mensaje", "ocurrio un error");
			}
			
			getServletContext().getRequestDispatcher("/web/mensaje.jsp").forward(request, response);
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}
