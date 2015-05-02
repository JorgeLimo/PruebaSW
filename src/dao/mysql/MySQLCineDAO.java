package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import bean.CineBean;
import dao.interfaces.CineDAO;
import daofactory.MySqlDaoFactory;

public class MySQLCineDAO extends MySqlDaoFactory implements CineDAO{

	@Override
	public Vector<CineBean> all() 
	{
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM cine");
			
			Vector<CineBean> cine = null;
			cine = new Vector<CineBean>();
			
			while(rs.next()){
			
				CineBean bean = new CineBean();
				bean.setId_cine(rs.getInt("id_cine"));
				bean.setId_cine_padre(rs.getInt("id_cine_padre"));
				bean.setNombre(rs.getString("nombre"));
				bean.setDireccion(rs.getString("direccion"));
			
				cine.add(bean);
			}
			stmt.close();
			return cine;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean delete(int id_cine) {		
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			int i= stmt.executeUpdate("DELETE FROM cine WHERE id_cine = "+id_cine);
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
	public CineBean find(int id_cine) {
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM cine WHERE id_cine = "+id_cine);
			
			while(rs.next()){
				CineBean bean = new CineBean();
				bean.setId_cine(rs.getInt("id_cine"));
				bean.setId_cine_padre(rs.getInt("id_cine_padre"));
				bean.setNombre(rs.getString("nombre"));
				bean.setDireccion(rs.getString("direccion"));
				stmt.close();
				return bean;
			}
			stmt.close();
			return null;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean save(CineBean cine) {
		try{
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			int i = 0;
			if(cine.getId_cine() == 0)
				i= stmt.executeUpdate("INSERT INTO cine (nombre, direccion) VALUES ('"+cine.getNombre()+"', '"+cine.getDireccion()+"')");
			else
				i = stmt.executeUpdate("UPDATE cine SET nombre = '"+cine.getNombre()+"', direccion = '"+cine.getDireccion()+"' WHERE id_cine = "+cine.getId_cine());
				
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
