package UnitOmega13;

public class Leap_year_task {

	int numberOfLeepYears, numberOfEvery4year, numberOfevery100year, numberOfEvery400Year;

	public int numberOfLeepYears(int value){
		numberOfEvery4year = value / 4;
		numberOfevery100year = value / 100;
		numberOfEvery400Year = value / 400;
		numberOfLeepYears = numberOfEvery4year - numberOfevery100year + numberOfEvery400Year;
		return numberOfLeepYears;
	}
}
