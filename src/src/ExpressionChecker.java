public class ExpressionChecker {
	private static final double CHECKVALUE = 1E-4;
	public boolean doubleExpression(double a, double b, double c) {
		return Math.abs((a + b) - c) < CHECKVALUE;
	}
}
