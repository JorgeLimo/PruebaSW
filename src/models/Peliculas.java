package models;

import java.util.Vector;

public class Peliculas {

	private int id;
	private String nombre;
	private String local;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Peliculas() {
		// TODO Auto-generated constructor stub
	}

	public Vector<Peliculas> getPeliculas()
	{
		try
		{
			Vector<Peliculas> peliculas = new Vector<Peliculas>();
			Peliculas pelicula = new Peliculas();
			pelicula.setId(10);
			pelicula.setNombre("Dragon Ball Doblada");
			pelicula.setLocal("Cinemark Bellavista");
			peliculas.add(pelicula);
			
			pelicula = new Peliculas();
			pelicula.setId(20);
			pelicula.setNombre("Harry Potter Subtitulada");
			pelicula.setLocal("UVK Larcomar");
			peliculas.add(pelicula);
			
			return peliculas;
		}catch(Exception e)
		{
			return null;
		}
	}
}
