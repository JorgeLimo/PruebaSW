package dao.interfaces;

import java.util.Vector;

import bean.TicketBean;

public interface TicketDAO {
	public int save(TicketBean ticket);
	public boolean delete(int id_ticket);
	public Vector<TicketBean> all() throws Exception;
	public TicketBean find(int id_ticket);
}
