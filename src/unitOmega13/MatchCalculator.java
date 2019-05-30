package unitOmega13;

class MatchCalculator {

	void countResult(int firstTeamGoal, int secondTeamGoal, int gamerFirstResult, int gamerSecondResult) {
		if (firstTeamGoal < 0 || secondTeamGoal < 0 || gamerFirstResult < 0 || gamerSecondResult < 0) {
			throw new IllegalArgumentException("Number of goals should be 0 or bigger than 0");
		}

		int differenceGoals;
		int differencePlayerGoals;
		differenceGoals = firstTeamGoal - secondTeamGoal;
		differencePlayerGoals = gamerFirstResult - gamerSecondResult;
		return (firstTeamGoal == gamerFirstResult && secondTeamGoal == gamerSecondResult) ? 2 :
				(differenceGoals > 0 && differencePlayerGoals > 0 )||
						(differenceGoals < 0 && differencePlayerGoals < 0 ) ||
						(differenceGoals == 0 && differencePlayerGoals == 0 ) ? 1 : 0;
		System.out.println(resultOfGame);
	}
}
