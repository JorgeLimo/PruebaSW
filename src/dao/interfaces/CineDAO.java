package dao.interfaces;

import java.util.List;
import java.util.Vector;

import bean.CineBean;

public interface CineDAO {
	public boolean save(CineBean cine);
	public boolean delete(int id_cine);
	public Vector<CineBean> all();
	public CineBean find(int id_cine);
}
