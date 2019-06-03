package src;

public abstract class TooLongTextAnalyzer implements TextAnalyzer {
	private int maxLength;

	public TooLongTextAnalyzer(int threshold) {
		this.maxLength = threshold;
	}
}
