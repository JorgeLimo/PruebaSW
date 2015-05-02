package models;

import java.util.Vector;

public class Precio 
{
	private int id_precio;
	private double precio;
	private String nombre;
	private String foto;
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getId_precio() {
		return id_precio;
	}

	public void setId_precio(int id_precio) {
		this.id_precio = id_precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Precio() {
		// TODO Auto-generated constructor stub
	}

	public Vector<Precio> getPrecios(boolean combo)
	{
		try {
			Vector<Precio> precios = new Vector<Precio>();
			Precio precio = new Precio();
			
			if(combo)
			{
				precio.setId_precio(0);
				precio.setPrecio(20.50);
				precio.setNombre("Adulto");
				precios.add(precio);
				
				precio = new Precio();
				precio.setId_precio(1);
				precio.setPrecio(15.50);
				precio.setNombre("Niño");
				precios.add(precio);
				
				precio = new Precio();
				precio.setId_precio(2);
				precio.setPrecio(17.50);
				precio.setNombre("Tercera Edad");
				precios.add(precio);
			}
			else
			{
				precio.setId_precio(0);
				precio.setPrecio(20.50);
				precio.setNombre("Cancha Grande y 2 Gaseosas grandes");
				precio.setFoto("http://dealicioso.com.ph/wp-content/uploads/2012/09/1210.jpg");
				precios.add(precio);
				
				precio = new Precio();
				precio.setId_precio(1);
				precio.setPrecio(15.50);
				precio.setNombre("Cancha chica y gaseosa");
				precio.setFoto("http://asset4.zankyou.com/images/gift/200/8780/434/320/-/80a/ec1/9dd/tmp__51352e_Popcorn_and_so.jpg");
				precios.add(precio);
				
			}
			
			return precios;
		} catch (Exception e) {
			return null;
		}
	}
	
}
