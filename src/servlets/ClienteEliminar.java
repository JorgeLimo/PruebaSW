package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daofactory.DaoFactory;

/**
 * Servlet implementation class ClienteEliminar
 */
@WebServlet("/ClienteEliminar")
public class ClienteEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteEliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {	
			int id_cliente = Integer.parseInt(request.getParameter("id"));
			
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			boolean flag = dao.getClienteDao().delete(id_cliente);
			
			if(flag){
				request.setAttribute("mensaje", "Cliente eliminado");
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
