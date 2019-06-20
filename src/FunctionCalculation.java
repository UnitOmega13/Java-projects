import java.util.function.DoubleUnaryOperator;

public class FunctionCalculation {
	public static double integrate(DoubleUnaryOperator f, double a, double b) {
		int n = 10_000_000;
		double differential = (b - a) * 1.0 / n;
		double integral = 0;
		for (int number = 0; number < n; number++) {
			double x = a + number * differential;
			integral += f.applyAsDouble(x) * differential;
		}
		return integral;
	}
}
