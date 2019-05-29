public class AsciiCharSequence implements CharSequence {
	private byte[] stringReplace;

	private AsciiCharSequence(byte[] content) {
		this.stringReplace = content;
	}

	@Override
	public int length() {
		return stringReplace.length;
	}

	@Override
	public char charAt(int index) {
		return (char) stringReplace[index];
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		byte[] result = new byte[end - start];
		if (end - start >= 0) System.arraycopy(stringReplace, start, result, start - start, end - start);
		return new AsciiCharSequence(result);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(stringReplace.length);
		for (byte b : stringReplace) {
			result.append((char) b);
		}
		return result.toString();
	}
}
