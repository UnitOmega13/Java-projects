import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int choice;
		ArraySorter arraySorter = new ArraySorter();
		RobotMove robotMove = new RobotMove();
		RoleSorter roleSorter = new RoleSorter();
		Factorial factorial = new Factorial();
		Palindrome palindrome = new Palindrome();
		System.out.println("Choose task:");
		System.out.println("1 - Array combine and sort");
		System.out.println("2 - Role Sorter");
		System.out.println("3 - Robot mover");
		System.out.println("4 - Redefinition of methods");
		System.out.println("5 - Factorial");
		System.out.println("6 - Palindrome check");
		Scanner scanner = new Scanner(System.in);
		choice = scanner.nextInt();
		if (choice > 6) {
			System.out.println("This task does`t exists.");
		} else if (choice < 1) {
			System.out.println("Sorry you need to choose from 1 to 6.");
		} else {
			switch (choice) {
				case 1:
					int[] array1 = {0, 8, 4};
					int[] array2 = {3, 5, 2};
					arraySorter.arraySorter(array1, array2);
					break;
				case 2:
					String rolesInput = null;
					try {
						rolesInput = roleSorter.readFile("RolesForTask.txt", StandardCharsets.UTF_8);
						String[] roles = rolesInput.split("\n");
						String textLinesInput = roleSorter.readFile("TextLinesForRoles.txt", StandardCharsets.UTF_8);
						String[] textLines = textLinesInput.split("\n");
						System.out.print(roleSorter.printTextPerEveryRole(roles, textLines));
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 3:
					int x = 5;
					int y = -6;
					robotMove.moveRobotTo(x, y);
					break;
				case 4:
					ComplexNumber a = new ComplexNumber(2, 4);
					ComplexNumber b = new ComplexNumber(4, 3);
					System.out.println(a.equals(b));
					break;
				case 5:
					int numberForFractal = 3;
					factorial.factorialFinder(numberForFractal);
					break;
				case 6:
					String stringForCheck = "Madam, I'm Adam!";
					palindrome.isPalindrome(stringForCheck);
					break;
				default:
					break;
			}

		}
	}
}
