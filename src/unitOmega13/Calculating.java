public class Calculating {

	long exponentiation(int number, int power) {
		int result = 1;
		for (int originalNumber = 0; originalNumber < power; originalNumber++) {
			result *= number;
		}
		return result;
	}
}
