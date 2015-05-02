package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ClienteBean;
import bean.FuncionBean;
import dao.interfaces.ClienteDAO;
import dao.interfaces.FuncionDAO;
import daofactory.DaoFactory;

/**
 * Servlet implementation class FuncionRegistrar
 */
@WebServlet("/FuncionRegistrar")
public class FuncionRegistrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuncionRegistrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		PrintWriter out = response.getWriter();
		try {
			int peliculaId	= Integer.parseInt(request.getParameter("pelicula"));
			int cineId = Integer.parseInt(request.getParameter("cine"));
			String tipoFUn 	= request.getParameter("tipo");

			String fe=request.getParameter("fecha");
	 
			//Timestamp fechaTime = Timestamp.valueOf("2012-02-07 06:44:54");
			
		 
			
			
			String año="";
			String mes="";
			String dia="";
			String hora="";
			
			año=fe.substring(0,4);
			mes=fe.substring(5,7);
			dia=fe.substring(8,10);
			hora=fe.substring(11,16);
			String fecha_nueva=año+"-"+mes+"-"+dia+" "+hora+":00";

		     Timestamp fechaTime = Timestamp.valueOf(fecha_nueva);
	        System.out.print(fecha_nueva);
	        
	        
	         
	        
			FuncionBean funcion = new FuncionBean();
			funcion.setId_pelicula(peliculaId);
			funcion.setId_cine(cineId);
			funcion.setTipo(tipoFUn);
			funcion.setFecha_hora(fechaTime);
			
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			FuncionDAO funcionDao = dao.getFuncionDao();
			boolean r = funcionDao.save(funcion);
			
			if(r){
				request.setAttribute("mensaje", "registro satisfactorio");
			}else{
				request.setAttribute("mensaje", "ocurrio un error");
			}
			
			//getServletContext().getRequestDispatcher("/Home").forward(request, response); es para mandar respuestas
			response.sendRedirect("Home");
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	
	
	}

}
