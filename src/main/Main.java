import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int index = 0;
		StringBuilder stringBuilder = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		ArrayDeque<Integer> numbers = new ArrayDeque<>();
		while (scanner.hasNextInt()) {
			if (index % 2 == 0) {
				scanner.nextInt();
			} else {
				numbers.add(scanner.nextInt());
			}
			index++;
		}
		for (index = 0; index < numbers.size(); ) {
			stringBuilder.append(numbers.getLast()).append(" ");
			numbers.removeLast();
		}
		System.out.print(stringBuilder.toString());
	}
}
