class Leap_year_task {

	public int numberOfLeepYears(int value) {
		int numberOfEvery4year = value / 4;
		int numberOfevery100year = value / 100;
		int numberOfEvery400Year = value / 400;
		return numberOfEvery4year - numberOfevery100year + numberOfEvery400Year;
	}
}
