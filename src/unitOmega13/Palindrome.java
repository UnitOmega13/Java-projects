package UnitOmega13;

public class Palindrome {
	public boolean ispPlindrome(String stringForCheck) {
		String cleanString = stringForCheck.toUpperCase().replaceAll("[\\-+.^:,]", "");
		String revertString = new StringBuilder(cleanString).reverse().toString();
		if (revertString.equals(stringForCheck)) {
			System.out.println("True");
			return true;
		} else {
			System.out.println("False");
		}
		return false;
	}
}
