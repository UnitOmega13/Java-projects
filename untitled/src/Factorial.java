package src;

import java.math.BigInteger;

class Factorial {

	public static BigInteger factorial(int value) {
		BigInteger result = BigInteger.valueOf(1);
		for (int i = value; i >= 1; i--) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}
}

