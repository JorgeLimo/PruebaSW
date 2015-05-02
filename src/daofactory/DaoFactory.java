package daofactory;

import bean.PeliculaBean;
import dao.interfaces.CineDAO;
import dao.interfaces.ClienteDAO;
import dao.interfaces.FuncionDAO;
import dao.interfaces.PeliculaDAO;
import dao.interfaces.SyncDAO;
import dao.interfaces.TicketDAO;

public abstract class DaoFactory {
	public static final int MYSQL 		=1;
	public static final int SQLSERVER 	=2;
	public static final int ORACLE 		=3;
	
    public abstract CineDAO getCineDao();
    public abstract ClienteDAO getClienteDao();
    public abstract FuncionDAO getFuncionDao();
    public abstract PeliculaDAO getPeliculaDao();
    public abstract TicketDAO getTicketDao();
    public abstract SyncDAO getSyncDao();
	
	public static DaoFactory getDAOFactory(int factory){
		switch (factory) {
			case MYSQL:
				return new MySqlDaoFactory();
			case SQLSERVER:
				//return new SqlServerDaoFactory();
				return null;
			case ORACLE:
				//return new OracleDaoFactory();
				return null;
			default:
				return null;
		}
	}
}
