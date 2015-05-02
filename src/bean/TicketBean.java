package bean;

import java.util.Date;
import java.util.Vector;

public class TicketBean 
{
	private int id_ticket;
	private FuncionBean funcion;
	private ClienteBean cliente;
	private String cliente_nombre;
	private String cliente_apellido;
	private String cliente_correo;
	private String estado;
	private float total;
	private Date creado;
	
	private Vector<TicketExtraBean> ticket_extra;
	
	public Vector<TicketExtraBean> getTicket_extra() {
		return ticket_extra;
	}
	public void setTicket_extra(Vector<TicketExtraBean> ticket_extra) {
		this.ticket_extra = ticket_extra;
	}
	public int getId_ticket() {
		return id_ticket;
	}
	public void setId_ticket(int id_ticket) {
		this.id_ticket = id_ticket;
	}
	public FuncionBean getFuncion() {
		return funcion;
	}
	public void setFuncion(FuncionBean funcion) {
		this.funcion = funcion;
	}
	public ClienteBean getCliente() {
		return cliente;
	}
	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}
	public String getCliente_nombre() {
		return cliente_nombre;
	}
	public void setCliente_nombre(String cliente_nombre) {
		this.cliente_nombre = cliente_nombre;
	}
	public String getCliente_apellido() {
		return cliente_apellido;
	}
	public void setCliente_apellido(String cliente_apellido) {
		this.cliente_apellido = cliente_apellido;
	}
	public String getCliente_correo() {
		return cliente_correo;
	}
	public void setCliente_correo(String cliente_correo) {
		this.cliente_correo = cliente_correo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Date getCreado() {
		return creado;
	}
	public void setCreado(Date creado) {
		this.creado = creado;
	}
}
