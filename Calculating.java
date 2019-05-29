package UnitOmega13;

public class Calculating {

	public long exponentiation(int number, int degree){
		int result = 1;
		for (int originalnumber = 0; originalnumber < degree; originalnumber++) {
			result *= number;

		}
		return result;
	}
}
