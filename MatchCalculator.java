package UnitOmega13;

public class MatchCalculator {
	private int FTeamgoal;
	private int STeamgoal;
	private int GamerFirst;
	private int GamerSecond;
	public int countResult(int FTeamgoal, int STeamgoal, int GamerFirst, int GamerSecond){
		this.FTeamgoal = FTeamgoal;
		this.STeamgoal = STeamgoal;
		this.GamerFirst = GamerFirst;
		this.GamerSecond = GamerSecond;
		checkData();
		if (Guessed()) {
			return 2;
		}else if (almostGuessed()) {
			return 1;
		}else{
			return 0;
		}
	}
	private boolean Guessed() {
		if (FTeamgoal == GamerFirst && STeamgoal == GamerSecond) {
			return true;
		}
		return false;
	}
	private boolean almostGuessed() {
		int differenceGoals, differencePlayerGoals;
		differenceGoals = FTeamgoal - STeamgoal;
		differencePlayerGoals = GamerFirst - GamerSecond;
		if ( differenceGoals > 0 && differencePlayerGoals > 0 ) {
			return true;
		}else if(differenceGoals < 0 && differencePlayerGoals < 0  ){
			return true;
		}
	}
	private void checkData(){
		if (FTeamgoal < 0 || STeamgoal < 0 || GamerFirst < 0 || GamerSecond < 0) {
			throw new IllegalArgumentException("Number of goals should be 0 or bigger than 0");
		}
	}
}
