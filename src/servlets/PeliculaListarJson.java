package servlets;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import jdk.nashorn.internal.ir.debug.JSONWriter;
import jdk.nashorn.internal.parser.JSONParser;
import bean.PeliculaBean;
import dao.interfaces.PeliculaDAO;
import dao.interfaces.TicketDAO;
import daofactory.DaoFactory;
import models.Peliculas;

/**
 * Servlet implementation class PeliculsList
 */
@WebServlet("/PeliculsList")
public class PeliculaListarJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeliculaListarJson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			String pel = request.getParameter("term");
			
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			PeliculaDAO pelicula = dao.getPeliculaDao();
			
			Vector<PeliculaBean> pels = pelicula.find(pel);
			JSONArray peliculas = new JSONArray();
			for(int i = 0; i < pels.size(); ++i)
			{
				JSONObject p = new JSONObject();
				p.put("label", pels.get(i).getNombre());
				peliculas.add(p);
			}
			out.print(peliculas);
		} catch (Exception e) {
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
