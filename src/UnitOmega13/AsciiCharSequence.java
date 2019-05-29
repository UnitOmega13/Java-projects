package UnitOmega13;

public class AsciiCharSequence implements CharSequence {
	private byte[] stringReplaceк;

	public AsciiCharSequence(byte[] content) {
		this.stringReplaceк = content;
	}

	@Override
	public int length() {
		return stringReplaceк.length;
	}

	@Override
	public char charAt(int index) {
		return (char)stringReplaceк[index];
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		byte[] result = new byte[end-start];
		for(int i = start; i < end; i++ ){
			result[i-start] = stringReplaceк[i];
		}
		return new AsciiCharSequence(result);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(stringReplaceк.length);
		for(int i = 0; i < stringReplaceк.length; i++ ){
			result.append((char)stringReplaceк[i]);
		}
		return result.toString();
	}
}
