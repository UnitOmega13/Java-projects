public class ExpressionChecker {
	static final float checkFloat = 1E-4;

	public boolean doubleExpression(double a, double b, double c) {
		return Math.abs((a + b) - c) < checkFloat;
	}
}
