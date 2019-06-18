import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class Task1 {

	public static IntStream pseudoRandomStream(int seed) {
		IntSupplier generator = new IntSupplier() {
			int current = 0;

			int mid(int index) {
				if (index == 0) return seed;
				int midElement = mid(index - 1);
				midElement *= midElement;
				int result = 0;
				int count = 0;
				int res;
				while (midElement > 0) {
					res = midElement % 10;
					count++;
					if (count >= 2 && count <= 4) result += res * Math.pow(10, count - 2);
					midElement /= 10;
				}

				return result;
			}

			public int getAsInt() {
				return mid(current++);
			}
		};

		IntStream natural = IntStream.generate(generator);

		return natural;
	}
}

