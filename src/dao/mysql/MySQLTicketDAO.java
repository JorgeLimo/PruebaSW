package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import bean.CineBean;
import bean.FuncionBean;
import bean.PeliculaBean;
import bean.TicketBean;
import dao.interfaces.TicketDAO;
import daofactory.MySqlDaoFactory;

public class MySQLTicketDAO extends MySqlDaoFactory implements TicketDAO{

	@Override
	public Vector<TicketBean> all() throws Exception {
		try {
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM ticket a INNER JOIN funcion b ON a.id_funcion = b.id_funcion INNER JOIN pelicula c ON c.id_pelicula = b.id_pelicula INNER JOIN cine d ON d.id_cine = b.id_cine WHERE estado = 'pagado'");
			
			Vector<TicketBean> ticket = null;
			ticket = new Vector<TicketBean>();
			
			while(rs.next()){
				TicketBean t = new TicketBean();
				t.setCliente_apellido(rs.getString("a.cliente_apellido"));
				t.setCliente_correo(rs.getString("a.cliente_correo"));
				t.setCliente_nombre(rs.getString("a.cliente_nombre"));
				t.setId_ticket(rs.getInt("a.id_ticket"));
				
				FuncionBean funcion = new FuncionBean();
				PeliculaBean pelicula = new PeliculaBean();
				pelicula.setNombre(rs.getString("c.nombre"));
				funcion.setPelicula(pelicula);
				CineBean cine = new CineBean();
				cine.setNombre(rs.getString("d.nombre"));
				funcion.setCine(cine);
				funcion.setFecha_hora(rs.getString("b.fecha_hora"));
				t.setFuncion(funcion);
				t.setTotal(rs.getInt("total"));
				t.setCreado(rs.getDate("creado"));
				
				ticket.add(t);
			}
			
			stmt.close();
			return ticket;	
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public boolean delete(int idTicket) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TicketBean find(int idTicket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(TicketBean ticket) {
		try{
			Connection con = MySqlDaoFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			int id = 0;
			if(ticket.getId_ticket() == 0)
			{
				id= stmt.executeUpdate("INSERT INTO ticket (id_funcion, id_cliente, cliente_nombre, cliente_apellido, cliente_correo, estado, total, creado) VALUES ('"+ticket.getFuncion().getId_funcion()+"', '"+ticket.getCliente().getId_cliente()+"', '"+ticket.getCliente().getNombre()+"', '"+ticket.getCliente().getApellido()+"', '"+ticket.getCliente().getCorreo()+"', 'reservado', '10', NOW())", Statement.RETURN_GENERATED_KEYS);
				
				for(int i = 0; i < ticket.getTicket_extra().size(); ++i)
				{
					int	a= stmt.executeUpdate("INSERT INTO ticket_extra (id_ticket, nombre, precio_unitario, cantidad, moneda) VALUES ("+id+", '"+ticket.getTicket_extra().get(i).getNombre()+"', '"+ticket.getTicket_extra().get(i).getPrecio_unitario()+"', '"+ticket.getTicket_extra().get(i).getCantidad()+"', 'PEN')");
				}	
			}
			else
			{
				stmt.executeUpdate("UPDATE ticket SET estado = '"+ticket.getEstado()+"' WHERE id_ticket = "+ticket.getId_ticket(), Statement.RETURN_GENERATED_KEYS);
				id = ticket.getId_ticket();
			}
			
			stmt.close();
			
			return id;
		}catch(Exception exc){
			System.out.println(exc.getMessage());
			return 0;
		}
	}

}
