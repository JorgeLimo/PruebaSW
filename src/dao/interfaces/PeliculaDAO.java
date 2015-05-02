package dao.interfaces;

import java.util.Vector;

import bean.PeliDesc;
import bean.PeliculaBean;

public interface PeliculaDAO {
	public boolean save(PeliculaBean pelicula);
	public boolean delete(int id_pelicula);
	public Vector<PeliculaBean> all();
	public Vector<PeliculaBean> find(String nombre);
	public PeliculaBean find(int id);
	public PeliDesc mostrar(int peli);
	
}
