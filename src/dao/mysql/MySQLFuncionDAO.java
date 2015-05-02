package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import bean.CineBean;
import bean.FuncionBean;
import bean.PeliculaBean;
import dao.interfaces.FuncionDAO;
import daofactory.MySqlDaoFactory;

public class MySQLFuncionDAO extends MySqlDaoFactory implements FuncionDAO{

	@Override
	public Vector<FuncionBean> all() {
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM funcion a INNER JOIN pelicula b ON a.id_pelicula = b.id_pelicula INNER JOIN cine c ON a.id_cine = c.id_cine");
			
			Vector<FuncionBean> funcion = null;
			funcion = new Vector<FuncionBean>();
			while(rs.next()){
				FuncionBean bean = new FuncionBean();
				bean.setId_funcion(rs.getInt("id_funcion"));
				
				PeliculaBean pelicula = new PeliculaBean();
				pelicula.setId_pelicula(rs.getInt("id_pelicula"));
				pelicula.setPoster(rs.getString("b.poster"));
				pelicula.setNombre(rs.getString("b.nombre"));
				bean.setPelicula(pelicula);
				
				bean.setTipo(rs.getString("tipo"));
				bean.setFecha_hora(rs.getTimestamp("fecha_hora"));
				
				CineBean cine = new CineBean();
				cine.setId_cine(rs.getInt("id_pelicula"));
				cine.setNombre(rs.getString("c.nombre"));
				bean.setCine(cine);
							
				funcion.add(bean);
			}
			stmt.close();
			return funcion;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean delete(int id_funcion) {
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			int i= stmt.executeUpdate("DELETE FROM funcion WHERE id_cliente = "+id_funcion);
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
	public FuncionBean find(int id_funcion) {
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM funcion a INNER JOIN pelicula b ON a.id_pelicula = b.id_pelicula INNER JOIN cine c ON a.id_cine = c.id_cine WHERE id_funcion = "+id_funcion);
			
			while(rs.next()){
				FuncionBean bean = new FuncionBean();
				bean.setId_funcion(rs.getInt("id_funcion"));
				
				PeliculaBean pelicula = new PeliculaBean();
				pelicula.setId_pelicula(rs.getInt("id_pelicula"));
				pelicula.setPoster(rs.getString("b.poster"));
				pelicula.setNombre(rs.getString("b.nombre"));
				bean.setPelicula(pelicula);
				
				bean.setTipo(rs.getString("tipo"));
				bean.setFecha_hora(rs.getTimestamp("fecha_hora"));
				
				CineBean cine = new CineBean();
				cine.setId_cine(rs.getInt("id_pelicula"));
				cine.setNombre(rs.getString("c.nombre"));
				bean.setCine(cine);
							
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
	public boolean save(FuncionBean funcion) {
		try{
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			int i = 0;
			if(funcion.getId_funcion() == 0)
				
				i= stmt.executeUpdate("INSERT INTO funcion (id_pelicula, id_cine, tipo,fecha_hora) VALUES ('"+funcion.getId_pelicula()+"','"+funcion.getId_cine()+"','"+funcion.getTipo()+"','"+funcion.getFecha_hora()+"')");
			else
			{
				boolean status = delete(funcion.getId_funcion());
				if(status)
				{
					funcion.setId_funcion(0);
					boolean status_funcion = save(funcion);
					if(status_funcion)
						return true;
					else
						return false;
				}
			}
			stmt.close();
			
			if(i==1){
				return true;
			}
			return false;
		}catch(Exception exc){
			System.out.println("Excepcion del mysql \n"+exc.getMessage());
			return false;
		}
	}
	
	@Override
	public Vector<FuncionBean> funcionxCine(int cine) {
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM funcion a INNER JOIN pelicula b ON a.id_pelicula = b.id_pelicula INNER JOIN cine c ON a.id_cine = c.id_cine WHERE id_cine='"+cine+"'");
			
			Vector<FuncionBean> funcion = null;
			funcion = new Vector<FuncionBean>();
			while(rs.next()){
				FuncionBean bean = new FuncionBean();
				bean.setId_funcion(rs.getInt("id_funcion"));
				
				PeliculaBean pelicula = new PeliculaBean();
				pelicula.setId_pelicula(rs.getInt("id_pelicula"));
				pelicula.setPoster(rs.getString("b.poster"));
				pelicula.setNombre(rs.getString("b.nombre"));
				bean.setPelicula(pelicula);
				
				bean.setTipo(rs.getString("tipo"));
				bean.setFecha_hora(rs.getTimestamp("fecha_hora"));
				
				CineBean cine = new CineBean();
				cine.setId_cine(rs.getInt("id_pelicula"));
				cine.setNombre(rs.getString("c.nombre"));
				bean.setCine(cine);
							
				funcion.add(bean);
			}
			stmt.close();
			return funcion;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public Vector<FuncionBean> all(int cod) {
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM funcion a INNER JOIN pelicula b ON a.id_pelicula = b.id_pelicula INNER JOIN cine c ON a.id_cine = c.id_cine where c.id_cine="+cod);
			
			Vector<FuncionBean> funcion = null;
			funcion = new Vector<FuncionBean>();
			while(rs.next()){
				FuncionBean bean = new FuncionBean();
				bean.setId_funcion(rs.getInt("id_funcion"));
				
				PeliculaBean pelicula = new PeliculaBean();
				pelicula.setId_pelicula(rs.getInt("id_pelicula"));
				pelicula.setPoster(rs.getString("b.poster"));
				pelicula.setNombre(rs.getString("b.nombre"));
				bean.setPelicula(pelicula);
				
				bean.setTipo(rs.getString("tipo"));
				bean.setFecha_hora(rs.getTimestamp("fecha_hora"));
				
				CineBean cine = new CineBean();
				cine.setId_cine(rs.getInt("id_pelicula"));
				cine.setNombre(rs.getString("c.nombre"));
				bean.setCine(cine);
							
				funcion.add(bean);
			}
			stmt.close();
			return funcion;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

}
