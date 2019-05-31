public class SquareRootFinder {
	public double sqrt(double x) {
		if (x < 0) {
			throw new IllegalArgumentException("Expected number, bigger than 0");
		}
		return Math.sqrt(x);
	}
}
