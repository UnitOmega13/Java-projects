package unitOmega13;

public class MatchCalculator {
	private int firstTeamGoal;
	private int secondTeamGoal;
	private int gamerFirstResult;
	private int gamerSecondResulr;
	boolean almostGuessed;
	boolean guessed;

	public boolean countResult(int firstTeamGoal, int secondTeamGoal, int gamerFirstResult, int gamerSecondResulr) {
		this.firstTeamGoal = firstTeamGoal;
		this.secondTeamGoal = secondTeamGoal;
		this.gamerFirstResult = gamerFirstResult;
		this.gamerSecondResulr = gamerSecondResulr;
		if (firstTeamGoal < 0 || STeamgoal < 0 || gamerFirstResult < 0 || gamerSecondResulr < 0) {
			throw new IllegalArgumentException("Number of goals should be 0 or bigger than 0");
		}

		int differenceGoals;
		int differencePlayerGoals;
		differenceGoals = firstTeamGoal - secondTeamGoal;
		differencePlayerGoals = gamerFirstResult - gamerSecondResulr;
		if (differenceGoals > 0 && differencePlayerGoals > 0) {
			almostGuessed true;
		} else if (differenceGoals < 0 && differencePlayerGoals < 0) {
			almostGuessed true;
		}
		if (firstTeamGoal == gamerFirstResult && secondTeamGoal == gamerSecondResulr) {
			guessed = true;
		} else {
			guessed = false;
		}

		if (Guessed()) {
			System.out.println("2");
		} else if (almostGuessed()) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}


}
