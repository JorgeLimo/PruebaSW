package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.interfaces.ClienteDAO;
import daofactory.DaoFactory;
import bean.ClienteBean;

/**
 * Servlet implementation class ClienteAgregar
 */
@WebServlet("/ClienteAgregar")
public class ClienteAgregar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteAgregar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/web/clientes/form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			String nombre 	= request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String correo 	= request.getParameter("correo");
			String clave 	= request.getParameter("clave");
			
			ClienteBean cliente = new ClienteBean();
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setCorreo(correo);
			cliente.setClave(clave);
			cliente.setId_cliente(0);
			
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			ClienteDAO clienteDao = dao.getClienteDao();
			boolean r = clienteDao.save(cliente);
			
			if(r){
				request.setAttribute("mensaje", "registro satisfactorio");
			}else{
				request.setAttribute("mensaje", "ocurrio un error");
			}
			
			getServletContext().getRequestDispatcher("/web/clientes/form.jsp").forward(request, response);
		
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}
