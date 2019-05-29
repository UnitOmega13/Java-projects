package UnitOmega13;

public class ComentCheck{

	abstract class KeywordAnalyzer implements TextAnalyzer {
		protected abstract String[] getKeywords();

		protected abstract Label getLabel();

		public Label processText(String text) {
			String[] keywords = getKeywords();
			for (String keyword : keywords) {
				if (text.contains(keyword)) {
					return getLabel();
				}
			}
			return Label.OK;
		}

	}

	class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
		private String[] keywords;

		public SpamAnalyzer(String[] keywords) {
			this.keywords = keywords;
		}

		@Override
		protected String[] getKeywords() {
			return keywords;
		}

		@Override
		protected Label getLabel() {
			return Label.SPAM;
		}
	}

	class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
		private final String[] KEYWORDS = {":(", "=(", ":|"};

		@Override
		protected String[] getKeywords() {
			return KEYWORDS;
		}

		@Override
		protected Label getLabel() {
			return Label.NEGATIVE_TEXT;
		}

	}

	class TooLongTextAnalyzer implements TextAnalyzer {
		private int maxLength;

		public TooLongTextAnalyzer(int threshold) {
			this.maxLength = threshold;
		}

		@Override
		public Label processText(String text) {
			if (text.length() > maxLength)
				return Label.TOO_LONG;
			else
				return Label.OK;
		}
	}
	public Label checkLabels(TextAnalyzer[] analyzers, String text) {
		for (int i = 0; i < analyzers.length; i++)
			if (analyzers[i].processText(text) != Label.OK)
				return analyzers[i].processText(text);
		return Label.OK;
	}
}
