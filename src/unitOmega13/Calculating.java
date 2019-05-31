class Calculating {

	long exponentiation(int number, int degree) {
		int result = 1;
		for (int originalNumber = 0; originalNumber < degree; originalNumber++) {
			result *= number;
		}
		return result;
	}
}
