package bean;

import java.sql.Timestamp;

public class SyncBean {

	private int id_sincronizar;
	private int id_pelicula;
	private int id_cine;
	private String id_proveedor_pelicula;
	private String nombre_proveedor_pelicula;
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre_proveedor_pelicula() {
		return nombre_proveedor_pelicula;
	}
	public void setNombre_proveedor_pelicula(String nombre_proveedor_pelicula) {
		this.nombre_proveedor_pelicula = nombre_proveedor_pelicula;
	}
	private Timestamp creado;
	public int getId_sincronizar() {
		return id_sincronizar;
	}
	public void setId_sincronizar(int id_sincronizar) {
		this.id_sincronizar = id_sincronizar;
	}
	public int getId_pelicula() {
		return id_pelicula;
	}
	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}
	public int getId_cine() {
		return id_cine;
	}
	public void setId_cine(int id_cine) {
		this.id_cine = id_cine;
	}
	public String getId_proveedor_pelicula() {
		return id_proveedor_pelicula;
	}
	public void setId_proveedor_pelicula(String id_proveedor_pelicula) {
		this.id_proveedor_pelicula = id_proveedor_pelicula;
	}
	public Timestamp getCreado() {
		return creado;
	}
	public void setCreado(Timestamp creado) {
		this.creado = creado;
	}

}
