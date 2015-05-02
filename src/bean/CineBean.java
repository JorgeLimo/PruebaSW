package bean;

public class CineBean 
{
	private int id_cine;
	private int id_cine_padre;
	private String nombre;
	private String direccion;
	
	public int getId_cine() {
		return id_cine;
	}
	public void setId_cine(int id_cine) {
		this.id_cine = id_cine;
	}
	public int getId_cine_padre() {
		return id_cine_padre;
	}
	public void setId_cine_padre(int id_cine_padre) {
		this.id_cine_padre = id_cine_padre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
