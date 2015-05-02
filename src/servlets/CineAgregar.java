package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.interfaces.CineDAO;
import daofactory.DaoFactory;
import bean.CineBean;

/**
 * Servlet implementation class CineAgregar
 */
@WebServlet("/CineAgregar")
public class CineAgregar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CineAgregar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/web/cines/form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			String nombre		= request.getParameter("nombre");
			String direccion	= request.getParameter("direccion");
			if(nombre.length() == 0 || direccion.length() == 0)
			{
				request.setAttribute("mensaje", "Debe ingresar todos los campos");
			}
			else
			{	
				CineBean cine = new CineBean();
				cine.setNombre(nombre);
				cine.setDireccion(direccion);
				cine.setId_cine(0);
				
				DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
				CineDAO cineDao = dao.getCineDao();
				boolean r = cineDao.save(cine);
				
				if(r){
					request.setAttribute("mensaje", "registro satisfactorio");
				}else{
					request.setAttribute("mensaje", "ocurrio un error");
				}
			}
			getServletContext().getRequestDispatcher("/web/cines/form.jsp").forward(request, response);
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}
