class NewNode<T> {
	NewNode<T> previous;
	NewNode<T> next;
	T value;

	NewNode(T value) {
		this.value = value;
	}

	void setPrevious(NewNode previous) {
		this.previous = previous;
	}

	void setNext(NewNode next) {
		this.next = next;
	}
}
