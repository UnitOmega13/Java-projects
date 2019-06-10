import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class ArrayList<T> implements ListForTask<T> {
	private static final int CAPACITY_OF_ARRAY = 10;
	public T[] newOwnArray;
	private int arraySize;

	public ArrayList() {
		this.newOwnArray = (T[]) new Object[CAPACITY_OF_ARRAY];
	}

	@Override
	public void add(T value) {
		if (arraySize >= newOwnArray.length - 1) {
			newOwnArray = Arrays.copyOf(newOwnArray, newOwnArray.length + (newOwnArray.length >> 1));
		}
		newOwnArray[arraySize++] = value;
	}

	@Override
	public void add(T value, int index) {
		arraySize++;
		if (indexOutOfBounds(index)) {
			if (arraySize >= newOwnArray.length - 1) {
				newOwnArray = Arrays.copyOf(newOwnArray, newOwnArray.length + (newOwnArray.length >> 1));
			}
			System.arraycopy(newOwnArray, index, newOwnArray, index + 1, newOwnArray.length - index - 1);
			newOwnArray[index] = value;
		}
	}


	@Override
	public void addAll(ListForTask<T> list) {
		int startPositionIndex = arraySize;
		for (int i = 0; i < list.size(); i++) {
			add(list.get(i), startPositionIndex + i);
		}
	}

	@Override
	public T get(int index) {
		if (indexOutOfBounds(index)) {
			return newOwnArray[index];
		}
		return null;
	}

	@Override
	public void set(T value, int index) {
		newOwnArray[index] = indexOutOfBounds(index) ? value : null;
	}

	@Override
	public T remove(int index) {
		if (!indexOutOfBounds(index)) {
			T elementToBeDeleted = newOwnArray[index];
			removerElementFromArray(index);
			return elementToBeDeleted;
		}
		return null;
	}

	@Override
	public T remove(T t) {
		for (int i = 0; i < newOwnArray.length; i++) {
			if (newOwnArray[i].equals(t)) {
				removerElementFromArray(i);
				return t;
			}
		}
		return null;
	}

	@Override
	public int size() {
		return arraySize;
	}

	@Override
	public boolean isEmpty() {
		return arraySize == 0;
	}

	private void removerElementFromArray(int index) {
		System.arraycopy(newOwnArray, index + 1, newOwnArray, index, newOwnArray.length - index - 1);
		newOwnArray = Arrays.copyOf(newOwnArray, newOwnArray.length - 1);
		arraySize--;
	}

	private boolean indexOutOfBounds(int index) {
		if (index >= arraySize || index < 0) {
			throw new ArrayIndexOutOfBoundsException("Index does not exist");
		}
		return true;
	}
}
