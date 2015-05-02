package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CineBean;
import bean.ClienteBean;
import dao.interfaces.CineDAO;
import dao.interfaces.ClienteDAO;
import daofactory.DaoFactory;

/**
 * Servlet implementation class ClienteEditar
 */
@WebServlet("/ClienteEditar")
public class ClienteEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteEditar() {
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
			ClienteBean cliente = dao.getClienteDao().find(id_cliente);
			
			request.setAttribute("cliente", cliente);
			
			getServletContext().getRequestDispatcher("/web/clientes/formEditar.jsp").forward(request, response);
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
			String nombre 	= request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String correo 	= request.getParameter("correo");
			String clave 	= request.getParameter("clave");
			int id		 	= Integer.parseInt(request.getParameter("id"));
			
			ClienteBean cliente = new ClienteBean();
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setCorreo(correo);
			cliente.setClave(clave);
			cliente.setId_cliente(id);
			
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			ClienteDAO clienteDao = dao.getClienteDao();
			boolean r = clienteDao.save(cliente);
			
			if(r){
				request.setAttribute("mensaje", "Cliente editado satisfactoriamente");
			}else{
				request.setAttribute("mensaje", "ocurrio un error");
			}
			
			getServletContext().getRequestDispatcher("/web/mensaje.jsp").forward(request, response);
		
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}
