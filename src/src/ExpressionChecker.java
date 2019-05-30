public class ExpressionChecker {

	public boolean check(double value1, double value2, double value3) {
		return Math.abs((value1 + value2) - value3) < 1E-4;
	}
}
