package dao;

import db.PlayerStorage;
import model.Player;

import java.util.List;

public class PlayerDaoImpl implements PlayerDao{


	@Override
	public void add(Player player) {
		PlayerStorage.PLAYERS.add(player);
	}

	@Override
	public List<Player> getAll() {
		return PlayerStorage.PLAYERS;
	}
}
