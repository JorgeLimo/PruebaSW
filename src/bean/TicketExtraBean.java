package bean;

public class TicketExtraBean 
{
	private int id_ticket_extra;
	private int id_ticket;
	private String nombre;
	private Double precio_unitario;
	private int cantidad;
	private String moneda;
	public int getId_ticket_extra() {
		return id_ticket_extra;
	}
	public void setId_ticket_extra(int id_ticket_extra) {
		this.id_ticket_extra = id_ticket_extra;
	}
	public int getId_ticket() {
		return id_ticket;
	}
	public void setId_ticket(int id_ticket) {
		this.id_ticket = id_ticket;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio_unitario() {
		return precio_unitario;
	}
	public void setPrecio_unitario(Double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	
}
