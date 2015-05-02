package dao.mysql;

import java.sql.Connection;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import bean.SyncBean;
import dao.interfaces.SyncDAO;
import daofactory.MySqlDaoFactory;

public class MySQLSyncDAO extends MySqlDaoFactory implements SyncDAO{

	public MySQLSyncDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save(SyncBean sync) {
		try{
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar calendar = Calendar.getInstance();
			
			int i = 0;
				i= stmt.executeUpdate("INSERT INTO sincronizar (id_pelicula, id_cine, id_proveedor_pelicula, nombre_proveedor_pelicula, creado) VALUES ('"+sync.getId_pelicula()+"', '"+sync.getId_cine()+"', '"+sync.getId_proveedor_pelicula()+"', '"+sync.getNombre_proveedor_pelicula()+"', '"+dateFormat.format(calendar.getTime())+"')");
			
			stmt.close();
			if(i==1){
				return true;
			}
			return false;
		}catch(Exception exc){
			System.out.println(exc.getMessage());
			return false;
		}
	}

}
