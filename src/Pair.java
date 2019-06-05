import java.util.Objects;

public class Pair<T, K> {

	private T first;
	private K second;

	private Pair(T first, K second) {
		this.first = first;
		this.second = second;
	}

	private T getFirst() {
		return first;
	}

	private K getSecond() {
		return second;
	}

	public static <T, K> Pair<T, K> of(T first, K second) {
		return new Pair<>(first, second);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		Pair<?, ?> pair = (Pair<?, ?>) object;
		return Objects.equals(getFirst(), pair.getFirst()) &&
				Objects.equals(getSecond(), pair.getSecond());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getFirst(), getSecond());
	}
}
