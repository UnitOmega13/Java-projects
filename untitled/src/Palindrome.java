package src;

class Palindrome {
	public boolean isPalindrome(String text) {
		String regex = "[^A-Za-z0-9]";
		String cleanString = text.replaceAll(regex, "");
		String revertString = new StringBuilder(cleanString).reverse().toString();
		return revertString.equalsIgnoreCase(cleanString);
	}
}
