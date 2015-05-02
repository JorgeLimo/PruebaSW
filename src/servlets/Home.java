package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CineBean;
import bean.ClienteBean;
import bean.FuncionBean;
import bean.PeliculaBean;
import dao.interfaces.ClienteDAO;
import daofactory.DaoFactory;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int cod;String accion;
		
		if(request.getParameter("accion") == null){
			accion = "todo";
		}else{
			accion=request.getParameter("accion");
		}
	
		if(request.getParameter("slt_tipo") == null){
			cod = 1;
		}else{
			cod = Integer.parseInt(request.getParameter("slt_tipo"));
		}
	
		
		if(accion.equals("listar")){
			try {			
				DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
				Vector<FuncionBean> funciones = dao.getFuncionDao().all(cod);
				Vector<CineBean> cines = dao.getCineDao().all();
				request.setAttribute("funciones", funciones);
				request.setAttribute("cines", cines);
				getServletContext().getRequestDispatcher("/web/cartelera.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				out.print(e.getMessage());
			}	
		}
		
		if(accion.equals("todo")){
			try {			
				DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
				Vector<FuncionBean> funciones = dao.getFuncionDao().all();
				Vector<CineBean> cines = dao.getCineDao().all();
				request.setAttribute("funciones", funciones);
				request.setAttribute("cines", cines);
				getServletContext().getRequestDispatcher("/web/cartelera.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				out.print(e.getMessage());
			}
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

			
			String usuario = request.getParameter("user");
			String password = request.getParameter("pass");
			
			DaoFactory dao1 = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			ClienteDAO clienteDao = dao1.getClienteDao();
			ClienteBean cliente = clienteDao.login(usuario, password);
			
			if(cliente == null){
				
				request.setAttribute("error_mensaje", "<div class='alert alert-danger'>Su usuario o contraseña no son validas, por favor ingrese correctamente la informacion</div>");
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			
			}else{
				
				try {			
					DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
					Vector<FuncionBean> funciones = dao.getFuncionDao().all();
					Vector<CineBean> cines = dao.getCineDao().all();
					request.setAttribute("funciones", funciones);
					request.setAttribute("cines", cines);
					getServletContext().getRequestDispatcher("/web/cartelera.jsp").forward(request, response);
				} catch (Exception e) {
					// TODO: handle exception
					out.print(e.getMessage());
					
				}
			}
			
			
			

	
	}

}
