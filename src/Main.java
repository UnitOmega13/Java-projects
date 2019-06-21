import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		StringBuilder builder = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			builder.append(scanner.nextLine());
			builder.append(" ");
		}
		String text = builder.toString().replaceAll("[^a-zA-Zа-яА-Я0-9]", " ");
		Map<String, Integer> wordsByNumber = new HashMap<>();
		scanner = new Scanner(text);
		while (scanner.hasNext()) {
			String word = scanner.next().toLowerCase();
			if (wordsByNumber.containsKey(word)) {
				wordsByNumber.put(word, wordsByNumber.get(word) + 1);
			} else {
				wordsByNumber.put(word, 1);
			}
		}
		Map<Integer, List<String>> numberByWords = new HashMap<>();
		for (Map.Entry<String, Integer> entry : wordsByNumber.entrySet()) {
			String word = entry.getKey();
			Integer number = entry.getValue();
			if (!numberByWords.containsKey(number)) {
				numberByWords.put(number, new ArrayList<>());
			}
			numberByWords.get(number).add(word);
		}
		List<String> allWords = new ArrayList<>();
		numberByWords.keySet().stream()
				.sorted(Comparator.reverseOrder())
				.forEach(key -> {
					List<String> words = numberByWords.get(key);
					words.stream().sorted().forEach(value -> {
						if (allWords.size() >= 10) {
							return;
						}
						allWords.add(value);
					});
				});
		allWords.forEach(System.out::println);
	}
}
