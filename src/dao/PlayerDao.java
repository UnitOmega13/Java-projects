package dao;

import lib.Dao;
import model.Player;

import java.util.List;

public interface PlayerDao {

	void add(Player player);
	List<Player> getAll();

}
