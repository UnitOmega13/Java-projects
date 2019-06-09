public class NewLinkedList<T> implements List<T> {
	private NewNode<T> firstNewNode;
	private NewNode<T> lastNewNode;
	private int length = 0;

	@Override
	public void add(T value) {
		NewNode<T> newNode = new NewNode<>(value);
		if (isEmpty()) {
			firstNewNode = newNode;
			lastNewNode = newNode;
		} else {
			lastNewNode.setNext(newNode);
			newNode.setPrevious(lastNewNode);
			lastNewNode = newNode;
		}
		length++;
	}

	@Override
	public void add(T value, int index) {
		validIndex(index);
		NewNode<T> newNode = new NewNode<>(value);
		if (index == 0) {
			firstNewNode.setPrevious(newNode);
			newNode.setNext(firstNewNode);
			firstNewNode = newNode;
		} else if (index == length) {
			add(newNode.value);
		} else {
			NewNode<T> prevNewNode = getNode(index);
			prevNewNode.next.setPrevious(newNode);
			newNode.next = prevNewNode.next;
			newNode.previous = prevNewNode;
			prevNewNode.next = newNode;
		}
		length++;
	}

	@Override
	public void addAll(List<T> list) {
		for (int i = 0; i < list.size(); i++) {
			add(list.get(i));
		}
	}

	public void addAll(NewLinkedList<T> newLinkedList) {
		lastNewNode.setNext(newLinkedList.firstNewNode);
		newLinkedList.firstNewNode.setPrevious(this.lastNewNode);
		length = length + newLinkedList.size();
	}

	@Override
	public T get(int index) {
		return getNode(index).value;
	}

	@Override
	public void set(T value, int index) {
		validIndex(index);
		getNode(index).value = value;
	}

	@Override
	public T remove(int index) {
		if (!isEmpty()) {
			validIndex(index);
			if (index == 0) {
				return removeFirst();
			}
			if (index == length - 1) {
				return removeLast();
			}
			NewNode<T> removedNewNode = getNode(index);
			removedNewNode.next.setPrevious(removedNewNode.previous);
			removedNewNode.previous.setNext(removedNewNode.next);
			length--;
			return removedNewNode.value;
		}
		return null;
	}

	@Override
	public T remove(T o) {
		NewNode<T> newNode = firstNewNode;
		if (o.equals(firstNewNode.value)) {
			return removeFirst();
		}
		if (o.equals(lastNewNode.value)) {
			return removeLast();
		}
		while (newNode != lastNewNode) {
			if (newNode.value == o) {
				newNode.previous.setNext(newNode.next);
				newNode.next.setPrevious(newNode.previous);
				length--;
				return newNode.value;
			}
			newNode = newNode.next;
		}
		return null;
	}

	@Override
	public int size() {
		return length;
	}

	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	private void validIndex(int index) {
		if (index < 0 || index > length - 1) {
			throw new IndexOutOfBoundsException(index + "is not valid index");
		}
	}

	private NewNode<T> getNode(int index) {
		NewNode<T> newNode = firstNewNode;
		for (int i = 0; i < index; i++) {
			newNode = newNode.next;
		}
		return newNode;
	}

	private T removeFirst() {
		NewNode<T> removedNewNode = firstNewNode;
		firstNewNode = firstNewNode.next;
		firstNewNode.setPrevious(null);
		length--;
		return removedNewNode.value;
	}

	private T removeLast() {
		NewNode<T> removedNewNode = lastNewNode;
		lastNewNode = lastNewNode.previous;
		lastNewNode.setNext(null);
		length--;
		return removedNewNode.value;
	}

	@Override
	public String toString() {
		NewNode<T> newNode = firstNewNode;
		StringBuilder stringBuilder = new StringBuilder("NewLinkedLisr{");
		for (int i = 0; i < length; i++) {
			stringBuilder.append(newNode.value).append(" ");
			newNode = newNode.next;
		}
		stringBuilder.append("}");
		return stringBuilder.toString();
	}
}