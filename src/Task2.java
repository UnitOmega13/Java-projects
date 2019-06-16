public class Task2 {
	public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
		Set<T> symmetricDifference = new HashSet<T>(set1);
		Set<T> tempSymetricalDifference = new HashSet<T>(set1);
		symmetricDifference.addAll(set2);
		tempSymetricalDifference.retainAll(set2);
		symmetricDifference.removeAll(tempSymetricalDifference);
		return symmetricDifference;
	}
}
