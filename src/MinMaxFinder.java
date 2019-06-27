import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class MinMaxFinder {
	public static <T> void findMinMax(
			Stream<? extends T> stream,
			Comparator<? super T> order,
			BiConsumer<? super T, ? super T> minMaxConsumer) {

		LinkedList<T> sortedList = new LinkedList<>();
		if (sortedList.isEmpty()) {
			minMaxConsumer.accept(null, null);
		} else {
			minMaxConsumer.accept(sortedList.stream().min(order::compare).get(), sortedList.stream().max(order::compare).get());
		}
	}
}
