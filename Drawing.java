package UnitOmega13;

public class Drawing {
	private char[][] part1;
	private int maxSize;
	public void drawStars(int maxNumberOfStars) {
		this.maxSize = maxNumberOfStars;
		if (maxSize%2 == 0) {
			everySecLine();
		}else {
			everythirdLine();
		}
		printStars();
	}
	private void printStars() {
		for (int printline = 0; printline < maxSize/2 + 1; printline++) {
			printLines(printline);
		}
		for (int ToPrint = maxSize/2-1; ToPrint >=0; ToPrint--) {
			printLines(ToPrint);
		}
	}
	private void printLines(int index) {
		for (int icell = 0; icell < maxSize; icell++) {
			System.out.print(part1[index][icell]);
		}
		System.out.println();
	}
	public void everySecLine() {
		maxSize++;
		everythirdLine();
		for (int unevenLine = 1; unevenLine < maxSize/2+1; unevenLine++) {
			part1[unevenLine][maxSize/2] = ' ';
		}

	}
	public void everythirdLine() {
		part1 = new char[maxSize/2+1][maxSize];
		int newStar = maxSize / 2;
		int numberOfStars = 1;
		for (int lineInCompleted = 0; lineInCompleted < maxSize/2 + 1; lineInCompleted++) {
			for (int completedStars = 0; completedStars < numberOfStars; completedStars++) {
				part1[lineInCompleted][newStar++] = '*';
			}
			if (numberOfStars+2 <= maxSize) {
				numberOfStars +=2;
				newStar = (maxSize-numberOfStars)/2;
			}
		}
	}
}
