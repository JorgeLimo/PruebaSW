package dao.interfaces;

import java.util.Vector;

import bean.FuncionBean;

public interface FuncionDAO {
	public boolean save(FuncionBean funcion);
	public boolean delete(int id_funcion);
	public Vector<FuncionBean> all();
	public Vector<FuncionBean> all(int cod);
	public Vector<FuncionBean> funcionxCine(int cine);
	public FuncionBean find(int id_funcion);
}
