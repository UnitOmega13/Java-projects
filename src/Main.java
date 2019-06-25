import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		Stream.of(text.toLowerCase().split("[\\p{Punct}\\s]+"))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.sorted(Map.Entry.<String, Long>comparingByValue()
						.reversed()
						.thenComparing(Map.Entry.comparingByKey()))
				.limit(10)
				.map(Map.Entry::getKey)
				.forEachOrdered(System.out::println);
	}
}
