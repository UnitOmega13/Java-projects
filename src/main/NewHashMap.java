import java.util.NoSuchElementException;

public class NewHashMap<K, V> {
	private Node<K, V>[] table;
	private int sizeOfTable;
	private static final int TABLE_SIZE = 16;
	private static final double TABLE_MAX_PERCENT_OCCUPANCY = 0.75;

	void put(K key, V value) {
		if (sizeOfTable == 0) {
			table = new Node[TABLE_SIZE];
		} else if (table.length * TABLE_MAX_PERCENT_OCCUPANCY <= TABLE_SIZE) {
			resizeOfTable();
		}
		int hashKeyIndex = hashKeyIndex(key, table.length);
		Node<K, V> newNode = new Node<>(key, value);
		Node<K, V> currentNode = table[hashKeyIndex];
		if (currentNode == null) {
			table[hashKeyIndex] = newNode;
		} else if (currentNode.keyValue.equals(key)) {
			currentNode.itemValue = value;
		} else {
			while (currentNode.hasNext() && !currentNode.keyValue.equals(key)) {
				currentNode = currentNode.next;
			}
			if (currentNode.keyValue.equals(key)) {
				currentNode.itemValue = value;
			}
			currentNode.next = newNode;
		}
		sizeOfTable++;
	}

	V get(K key) {
		int hashKeyIndex = hashKeyIndex(key, table.length);
		Node<K, V> currentNode = table[hashKeyIndex];
		if (currentNode == null) {
			return null;
		}
		while (!currentNode.keyValue.equals(key) && currentNode.hasNext()) {
			currentNode = currentNode.next;
		}
		return currentNode.keyValue.equals(key) ? currentNode.getItemValue() : null;
	}

	private Node<K, V>[] resizeOfTable() {
		Node<K, V> collisionNode;
		Node[] newTable = new Node[table.length << 1];
		for (Node<K, V> node : table) {
			if (node != null) {
				newTable[hashKeyIndex(node.keyValue, newTable.length)] = node;
				if (node.hasNext()) {
					while (node.hasNext()) {
						collisionNode = node.next;
						newTable[hashKeyIndex(collisionNode.keyValue, newTable.length)] = node;
					}
				}
			}
		}
		return newTable;
	}

	public void clear() {
		Node<K,V>[] nodes;
		if ((nodes = table) != null && sizeOfTable > 0) {
			sizeOfTable = 0;
			for (int index = 0; index < nodes.length; ++index)
				nodes[index] = null;
		}
	}

	Node<K, V> getNode(K key) {
		Node<K, V> node = table[hashKeyIndex(key, table.length)];
		if (node == null) {
			throw new NoSuchElementException("Node with this does not exist!");
		}
		while (!node.getKeyValue().equals(key) && node.hasNext()) {
			node = node.next;
		}
		if (!node.getKeyValue().equals(key)) {
			throw new NoSuchElementException("Current key does not exist");
		}
		return node;
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

		public K getKeyValue() {
			return keyValue;
		}

		public V getItemValue() {
			return itemValue;
		}

		boolean hasNext() {
			return this.next != null;
		}
	}
}
