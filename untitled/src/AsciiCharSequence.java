package src;

import java.util.Arrays;

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
		if (end - start > 0) {
			System.arraycopy(stringReplace, start, result, start - start, end - start);
		}
		return new AsciiCharSequence(result);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int index = 0; index < stringReplace.length; index++) {
			stringBuilder.append((char) stringReplace[index]);
		}
		return stringBuilder.toString();
	}
}
