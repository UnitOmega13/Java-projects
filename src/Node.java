class Node<K, V> {
	K keyValue;
	V itemValue;
	Node<K, V> next;

	Node(K keyValue, V itemValue) {
		this.keyValue = keyValue;
		this.itemValue = itemValue;
	}

	boolean hasNext() {
		return this.next != null;
	}
}