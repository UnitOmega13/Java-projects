import java.util.function.DoubleUnaryOperator;

public class Task2 {
	public static double integrate(DoubleUnaryOperator f, double a, double b) {
		int n = 1000000;
		double dx = (b - a) * 1.0 / n;
		double integral = 0;
		double  x;
		for(int number = 0; number < n ; number++){
			x = a + number * dx;
			integral += f.applyAsDouble(x)*dx;
		}
		return integral;
	}
}
