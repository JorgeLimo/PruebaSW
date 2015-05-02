package bean;


import java.sql.Timestamp;
 

public class FuncionBean 
{
	private int id_funcion;
	private PeliculaBean pelicula;
	private CineBean cine;
	private Timestamp fecha_hora;
	private String tipo;
	private int id_pelicula;
	private int id_cine;
	
	
	
	public int getId_cine() {
		return id_cine;
	}
	public void setId_cine(int id_cine) {
		this.id_cine = id_cine;
	}
	public int getId_pelicula() {
		return id_pelicula;
	}
	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}
	public int getId_funcion() {
		return id_funcion;
	}
	public void setId_funcion(int id_funcion) {
		this.id_funcion = id_funcion;
	}
	public PeliculaBean getPelicula() {
		return pelicula;
	}
	public void setPelicula(PeliculaBean pelicula) {
		this.pelicula = pelicula;
	}
	public CineBean getCine() {
		return cine;
	}
	public void setCine(CineBean cine) {
		this.cine = cine;
	}

	
 
 
	public Timestamp getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(Timestamp fecha_hora) {
		this.fecha_hora = fecha_hora;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
