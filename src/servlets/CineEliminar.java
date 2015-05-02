package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daofactory.DaoFactory;

/**
 * Servlet implementation class CineEliminar
 */
@WebServlet("/CineEliminar")
public class CineEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CineEliminar() {
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
			boolean flag = dao.getCineDao().delete(id_cine);
			
			if(flag){
				request.setAttribute("mensaje", "Cine eliminado satisfactoriamente");
			}else{
				request.setAttribute("mensaje", "Ocurrio un error");
			}
			
			getServletContext().getRequestDispatcher("/web/mensaje.jsp").forward(request, response);
			
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
