package factory;

import dao.PlayerDao;
import dao.PlayerDaoImpl;

public class PlayerDaoFactory {

	private static PlayerDao instance;

	public static PlayerDao getPlayerDao() {
		if (instance == null) {
			instance = new PlayerDaoImpl();
		}
		return instance;
	}
}
