import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class RandomStream {

	public static IntStream pseudoRandomStream(int seed) {
		return IntStream.iterate(seed, number -> number * number / 10 % 1000);
	}
}
