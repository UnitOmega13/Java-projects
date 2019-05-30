class Drawing {
	private char[][] firstPart;
	private int maxSizeOfStarsInLine;

	void drawStars(int maxNumberOfStars) {
		this.maxSizeOfStarsInLine = maxNumberOfStars;
		if (maxSizeOfStarsInLine % 2 == 0) {
			everySecondLine();
		} else {
			everyThirdLine();
		}
		printStars();
	}

	private void printStars() {
		for (int printLine = 0; printLine < maxSizeOfStarsInLine / 2 + 1; printLine++) {
			printLines(printLine);
		}
		for (int lineSizetoPrint = maxSizeOfStarsInLine / 2 - 1; lineSizetoPrint >= 0; lineSizetoPrint--) {
			printLines(lineSizetoPrint);
		}
	}

	private void printLines(int index) {
		for (int icell = 0; icell < maxSizeOfStarsInLine; icell++) {
			System.out.print(firstPart[index][icell]);
		}
		System.out.println();
	}

	private void everySecondLine() {
		maxSizeOfStarsInLine++;
		everyThirdLine();
		for (int unevenLine = 1; unevenLine < maxSizeOfStarsInLine / 2 + 1; unevenLine++) {
			firstPart[unevenLine][maxSizeOfStarsInLine / 2] = ' ';
		}

	}

	private void everyThirdLine() {
		firstPart = new char[maxSizeOfStarsInLine / 2 + 1][maxSizeOfStarsInLine];
		int newStar = maxSizeOfStarsInLine / 2;
		int numberOfStars = 1;
		for (int lineInCompleted = 0; lineInCompleted < maxSizeOfStarsInLine / 2 + 1; lineInCompleted++) {
			for (int completedStars = 0; completedStars < numberOfStars; completedStars++) {
				firstPart[lineInCompleted][newStar++] = '*';
			}
			if (numberOfStars + 2 <= maxSizeOfStarsInLine) {
				numberOfStars += 2;
				newStar = (maxSizeOfStarsInLine - numberOfStars) / 2;
			}
		}
	}
}
