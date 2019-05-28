package UnitOmega13;

public class ExpressionChecker {

	double number1, number2, number3;

	public boolean check(double value1, double value2, double value3){
		number1 = value1;
		number2 = value2;
		number3 = value3;
		if( number1 + number2 == number3){
			return true;
		}
		return false;
	}
}
