class Palindrome {
	public boolean isPalindrome(String stringForCheck) {
		String regex = "[^A-Za-z0-9]";
		String cleanString = stringForCheck.replaceAll(regex, "");
		String revertString = new StringBuilder(cleanString).reverse().toString();
		if (revertString.equalsIgnoreCase(cleanString)) {
			return true;
		}
		return false;
	}
}
