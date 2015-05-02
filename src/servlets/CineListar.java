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

import bean.CineBean;
import daofactory.DaoFactory;

/**
 * Servlet implementation class CineListar
 */
@WebServlet("/CineListar")
public class CineListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CineListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {			
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			Vector<CineBean> cineSala = dao.getCineDao().all();
			
			request.setAttribute("cine", cineSala);
			getServletContext().getRequestDispatcher("/web/cines/listar.jsp").forward(request, response);
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
