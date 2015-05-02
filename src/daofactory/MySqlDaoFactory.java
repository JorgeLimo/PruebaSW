package daofactory;
import java.sql.Connection;
import java.sql.DriverManager;

import dao.interfaces.CineDAO;
import dao.interfaces.ClienteDAO;
import dao.interfaces.FuncionDAO;
import dao.interfaces.PeliculaDAO;
import dao.interfaces.SyncDAO;
import dao.interfaces.TicketDAO;
import dao.mysql.MySQLCineDAO;
import dao.mysql.MySQLClienteDAO;
import dao.mysql.MySQLFuncionDAO;
import dao.mysql.MySQLPeliculaDAO;
import dao.mysql.MySQLSyncDAO;
import dao.mysql.MySQLTicketDAO;

public class MySqlDaoFactory extends DaoFactory {
	
	public static Connection obtenerConexion(){
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/cb_cinepapaya";
			con = DriverManager.getConnection(url, "root", "root");
		//String url = "jdbc:mysql://mysql23852-pruebasw.jelastic.websolute.net.br/cb_cinepapaya";
			//con = DriverManager.getConnection(url, "root", "gb9fm0bveP");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
		return con;
	}

	@Override
	public CineDAO getCineDao() {
		// TODO Auto-generated method stub
		return new MySQLCineDAO();
	}

	@Override
	public ClienteDAO getClienteDao() {
		// TODO Auto-generated method stub
		return new MySQLClienteDAO();
	}

	@Override
	public FuncionDAO getFuncionDao() {
		// TODO Auto-generated method stub
		return new MySQLFuncionDAO();
	}

	@Override
	public PeliculaDAO getPeliculaDao() {
		// TODO Auto-generated method stub
		return new MySQLPeliculaDAO();
	}

	@Override
	public TicketDAO getTicketDao() {
		// TODO Auto-generated method stub
		return new MySQLTicketDAO();
	}

	@Override
	public SyncDAO getSyncDao() {
		// TODO Auto-generated method stub
		return new MySQLSyncDAO();
	}
}
