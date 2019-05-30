public class Game {

	public boolean gameStart(boolean gameBool1, boolean gameBool2, boolean gameBool3, boolean gameBool4) {
		return (gameBool1 == gameBool2) & (gameBool3 == gameBool4) ||
				(gameBool1 == gameBool3) & (gameBool2 == gameBool4) ||
				(gameBool1 == gameBool4) & (gameBool2 == gameBool3);
	}
}
