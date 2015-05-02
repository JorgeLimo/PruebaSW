package dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import bean.ClienteBean;
import dao.interfaces.ClienteDAO;
import daofactory.MySqlDaoFactory;

public class MySQLClienteDAO extends MySqlDaoFactory implements ClienteDAO{

	@Override
	public Vector<ClienteBean> all() {
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM cliente");
			Vector<ClienteBean> cliente = null;
			cliente = new Vector<ClienteBean>();
			while(rs.next()){
				ClienteBean bean = new ClienteBean();
				bean.setId_cliente(rs.getInt("id_cliente"));
				bean.setNombre(rs.getString("nombre"));
				bean.setApellido(rs.getString("apellido"));
				bean.setCorreo(rs.getString("correo"));				
				
				cliente.add(bean);
			}
			stmt.close();
			return cliente;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean delete(int id_cliente) {
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			int i= stmt.executeUpdate("DELETE FROM cliente WHERE id_cliente = "+id_cliente);
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
	public ClienteBean find(int id_cliente) {
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM cliente WHERE id_cliente = "+id_cliente);
			
			while(rs.next()){
				ClienteBean bean = new ClienteBean();
				bean.setId_cliente(rs.getInt("id_cliente"));
				bean.setNombre(rs.getString("nombre"));
				bean.setApellido(rs.getString("apellido"));
				bean.setCorreo(rs.getString("correo"));				
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
	public boolean save(ClienteBean cliente) {
		try{
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar calendar = Calendar.getInstance();
			
			int i = 0;
			if(cliente.getId_cliente() == 0)
				i= stmt.executeUpdate("INSERT INTO cliente (nombre, apellido, correo, clave, creado) VALUES ('"+cliente.getNombre()+"','"+cliente.getApellido()+"','"+cliente.getCorreo()+"','"+cliente.getClave()+"', '"+dateFormat.format(calendar.getTime())+"')");
			else
				i= stmt.executeUpdate("UPDATE cliente SET nombre = '"+cliente.getNombre()+"', apellido = '"+cliente.getApellido()+"', correo = '"+cliente.getCorreo()+"', clave ='"+cliente.getClave()+"' WHERE id_cliente = "+cliente.getId_cliente());
			
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
	public ClienteBean login(String correo, String clave) {
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM cliente WHERE usuario = '"+correo+"' AND clave = '"+clave+"'");
			
			while(rs.next()){
				ClienteBean bean = new ClienteBean();
				bean.setId_cliente(rs.getInt("id_cliente"));
				bean.setNombre(rs.getString("nombre"));
				bean.setApellido(rs.getString("apellido"));
				bean.setCorreo(rs.getString("correo"));				
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

}
