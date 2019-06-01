public class SquareRootFinder {
	public double sqrt(double x) {
		if (x < 0) {
			throw new IllegalArgumentException("Expected not negative number");
		}
		return Math.sqrt(x);
	}
}
