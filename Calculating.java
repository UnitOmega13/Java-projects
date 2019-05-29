package unitOmega13;

public class Calculating {

	public long exponentiation(int number, int power) {
		int result = 1;
		for (int originalNumber = 0; originalNumber < power; originalNumber++) {
			result *= number;
		}
		return result;
	}
}
