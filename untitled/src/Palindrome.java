class Palindrome {
	void ispPlindrome(String stringForCheck) {
		String cleanString = stringForCheck.toUpperCase().replaceAll("[\\-+.^:,]", "");
		String revertString = new StringBuilder(cleanString).reverse().toString();
		if (revertString.equals(stringForCheck)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
}
