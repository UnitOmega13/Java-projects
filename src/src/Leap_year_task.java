public class Leap_year_task {
	public int leapYearCount(int year) {
		int numberOfEvery4year = year / 4;
		int numberOfevery100year = year / 100;
		int numberOfEvery400Year = year / 400;
		return numberOfEvery4year - numberOfevery100year + numberOfEvery400Year;
	}
}
