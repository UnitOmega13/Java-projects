import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int choice;
		int matchNum1;
		int matchNum2;
		int matchNum3;
		int matchNum4;
		int numberOfStars;
		int number;
		int degree;
		MatchCalculator calculator = new MatchCalculator();
		Drawing drawing = new Drawing();
		Calculating exponental = new Calculating();
		System.out.println("Choose task:");
		System.out.println("1 - Match Calculator");
		System.out.println("2 - Rhombus Printer");
		System.out.println("3 - Number exponentiation");
		Scanner scanner = new Scanner(System.in);
		choice = scanner.nextInt();
		if (choice > 3) {
			System.out.println("This task does`t exists.");
		} else if (choice < 1) {
			System.out.println("Sorry you need to choose from 1 to 3.");
		} else {
			switch (choice) {
				case 1:
					System.out.println("Please input numbers for task");
					matchNum1 = scanner.nextInt();
					matchNum2 = scanner.nextInt();
					matchNum3 = scanner.nextInt();
					matchNum4 = scanner.nextInt();
					calculator.countResult(matchNum1,matchNum2,matchNum3,matchNum4);
					break;
				case 2:
					System.out.println("Please input max number of stars in line");
					numberOfStars = scanner.nextInt();
					drawing.drawStars(numberOfStars);
					break;
				case 3:
					System.out.println("Please input number and degree");
					number = scanner.nextInt();
					degree = scanner.nextInt();
					System.out.println(exponental.exponentiation(number, degree));
					break;
				default:
					break;
			}
		}
	}
}
