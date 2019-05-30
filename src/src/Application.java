import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		int choice;
		int numberOfYears;
		int numberForBitChanger, indexOfBit;
		double expressionNumber1, expressionNumber2, expressionNumber3;
		Game trueFalseGame = new Game();
		ExpressionChecker expressionChecker = new ExpressionChecker();
		Leap_year_task leapYearTask = new Leap_year_task();
		BitChanger bitChanger = new BitChanger();
		System.out.println("Choose task:");
		System.out.println("1 - True/False game");
		System.out.println("2 - Year search");
		System.out.println("3 - Expression check");
		System.out.println("4 - Byte changer");
		Scanner scanner = new Scanner(System.in);
		choice = scanner.nextInt();
		if (choice > 4) {
			System.out.println("This task does`t exists.");
		} else if (choice < 1) {
			System.out.println("Sorry you need to choose from 1 to 4.");
		} else {
			switch (choice) {
				case 1:
					System.out.println("Please put 4 values for game (true or false)");
					boolean gameValue1 = Boolean.parseBoolean(scanner.next());
					boolean gameValue2 = Boolean.parseBoolean(scanner.next());
					boolean gameValue3 = Boolean.parseBoolean(scanner.next());
					boolean gameValue4 = Boolean.parseBoolean(scanner.next());
					System.out.println(trueFalseGame.gameStart(gameValue1, gameValue2, gameValue3, gameValue4));
					break;
				case 2:
					System.out.println("Please put numbers of years");
					numberOfYears = scanner.nextInt();
					System.out.println(leapYearTask.numberOfLeepYears(numberOfYears));
					break;
				case 3:
					System.out.println("Please put 3 numbers for check (double)");
					expressionNumber1 = scanner.nextDouble();
					expressionNumber2 = scanner.nextDouble();
					expressionNumber3 = scanner.nextDouble();
					System.out.println(expressionChecker.check(expressionNumber1, expressionNumber2, expressionNumber3));
					break;
				case 4:
					System.out.println("Please put number for change and Index of bit you want to change");
					numberForBitChanger = scanner.nextInt();
					indexOfBit = scanner.nextInt();
					System.out.println(bitChanger.changeBit(numberForBitChanger, indexOfBit));
					break;
				default:
					break;
			}

		}
	}
}
