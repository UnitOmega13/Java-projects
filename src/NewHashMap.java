public class NewHashMap<K, V> {
	private Node<K, V>[] table;
	private int sizeOfTable;
	private static final int TABLE_SIZE = 16;
	private static final double TABLE_MAX_PERCENT_OCCUPANCY = 0.75;

	public void put(K key, V value) {
		if (sizeOfTable == 0) {
			table = new Node[TABLE_SIZE];
		} else if (table.length * TABLE_MAX_PERCENT_OCCUPANCY <= TABLE_SIZE) {
			resizeOfTable();
		}
		Node<K, V> newNode = new Node<>(key, value);
		Node<K, V> currentNode = table[hashKeyIndex(key, table.length)];
		if (currentNode == null) {
			table[hashKeyIndex(key, table.length)] = newNode;
		} else if (currentNode.keyValue == key) {
			currentNode.itemValue = value;
		} else {
			while (currentNode.hasNext()) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}
		sizeOfTable++;
	}

	public V get(K key) {
		Node<K, V> currentNode = table[hashKeyIndex(key, table.length)];
		if (currentNode == null) {
			return null;
		}
		while (!currentNode.keyValue.equals(key) && currentNode.hasNext()) {
			currentNode = currentNode.next;
		}
		return currentNode.keyValue.equals(key) ? currentNode.itemValue : null;
	}

	private void resizeOfTable() {
		Node[] newTable = new Node[table.length << 1];
		for (Node<K, V> node : table) {
			if (node != null) {
				newTable[hashKeyIndex(node.keyValue, newTable.length)] = node;
			}
		}
	}

	private int hashKeyIndex(K key, int tableLength) {
		return (tableLength - 1) & key.hashCode();
	}
	private class Node<K, V> {
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
}
