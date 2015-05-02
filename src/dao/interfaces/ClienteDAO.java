package dao.interfaces;

import java.util.Vector;

import bean.ClienteBean;

public interface ClienteDAO {
	public boolean save(ClienteBean cliente);
	public boolean delete(int id_cliente);
	public Vector<ClienteBean> all();
	public ClienteBean find(int id_cliente);
	public ClienteBean login(String correo, String clave);
}
