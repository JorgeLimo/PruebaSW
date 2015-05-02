package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import bean.PeliDesc;
import bean.PeliculaBean;
import dao.interfaces.PeliculaDAO;
import daofactory.MySqlDaoFactory;

public class MySQLPeliculaDAO extends MySqlDaoFactory implements PeliculaDAO{

	@Override
	public Vector<PeliculaBean> all() {
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM pelicula");
			
			Vector<PeliculaBean> pelicula = null;
			pelicula = new Vector<PeliculaBean>();
			while(rs.next()){
				PeliculaBean bean = new PeliculaBean();
				bean.setId_pelicula(rs.getInt("id_pelicula"));
				bean.setNombre(rs.getString("nombre"));
				bean.setPoster(rs.getString("poster"));
				bean.setSinopsis(rs.getString("sinopsis"));
				
				pelicula.add(bean);
			}
			stmt.close();
			return pelicula;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean delete(int id_pelicula) {
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			int i= stmt.executeUpdate("DELETE FROM pelicula WHERE id_pelicula = "+id_pelicula);
			stmt.close();
			if(i==1){
				return true;
			}
			
			return false;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	@Override
	public Vector<PeliculaBean> find(String pel) {
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM pelicula WHERE nombre LIKE '%"+pel+"%'");
			
			Vector<PeliculaBean> pelicula = null;
			pelicula = new Vector<PeliculaBean>();
			while(rs.next()){
				PeliculaBean bean = new PeliculaBean();
				bean.setId_pelicula(rs.getInt("id_pelicula"));
				bean.setNombre(rs.getString("nombre"));
				bean.setPoster(rs.getString("poster"));
				bean.setSinopsis(rs.getString("sinopsis"));
				
				pelicula.add(bean);
			}
			stmt.close();
			return pelicula;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}
	
	public PeliculaBean find(int id) {
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM pelicula WHERE id_pelicula = "+id);
			
			while(rs.next()){
				PeliculaBean bean = new PeliculaBean();
				bean.setId_pelicula(rs.getInt("id_pelicula"));
				bean.setNombre(rs.getString("nombre"));
				bean.setPoster(rs.getString("poster"));
				bean.setSinopsis(rs.getString("sinopsis"));
				stmt.close();
				return bean;
			}
			return null;
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean save(PeliculaBean pelicula) {
		try{
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			int i = 0;
			if(pelicula.getId_pelicula() == 0)
				i= stmt.executeUpdate("INSERT INTO pelicula (nombre, poster, sinopsis) VALUES ('"+pelicula.getNombre()+"', '"+pelicula.getPoster()+"', '"+pelicula.getSinopsis()+"')");
			else
				i= stmt.executeUpdate("UPDATE pelicula SET nombre = '"+pelicula.getNombre()+"', poster = '"+pelicula.getPoster()+"', sinopsis = '"+pelicula.getSinopsis()+"' WHERE id_pelicula = "+pelicula.getId_pelicula());
			
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

	@Override
	public PeliDesc mostrar(int peli) {
		
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM pelicula_desc WHERE idpelicula = "+peli);
			
			while(rs.next()){
				PeliDesc obj = new PeliDesc();
				obj.setIdpelidesc(rs.getInt("idpelicula_desc"));
				obj.setIdpeli(rs.getInt("idpelicula"));
				obj.setDesc(rs.getString("descripcion"));
				obj.setUrl(rs.getString("trailer"));
				stmt.close();
				return obj;
			}
			return null;
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
		
	}
	
	

}
