package UnitOmega13;

public class Game {

	Boolean gameBool1, gameBool2, gameBool3, gameBool4;

	public boolean gameStart(String string1, String string2, String string3, String string4){
		gameBool1 = Boolean.parseBoolean(string1);
		gameBool2 = Boolean.parseBoolean(string2);
		gameBool3 = Boolean.parseBoolean(string3);
		gameBool4 = Boolean.parseBoolean(string4);
		if((gameBool1 == gameBool2) & (gameBool3 == gameBool4)){
			return true;
		}else if((gameBool1 == gameBool3) & (gameBool2 == gameBool4)){
			return true;
		}else if((gameBool1 == gameBool4) & (gameBool2 == gameBool3)) {
			return true;
		}
			return false;
	}
}
