public class NewHashMap<K, V> {
	private Node<K, V>[] table;
	private int sizeOfTable;
	private static final int TABLE_SIZE = 16;
	private static final double TABLE_MAX_PERCENT_OCCUPANCY = 0.75;           // Maximal occupancy of table(75%)

	public void put(K key, V value) {
		int occupancy = (int) (table.length * TABLE_MAX_PERCENT_OCCUPANCY);
		if (sizeOfTable == 0) {                                                //Check if hashmap empty, create new
			table = new Node[TABLE_SIZE];                                      //with size = TABLE_SIZE
		} else if (occupancy <= TABLE_SIZE) {                                  //If number of elements more than
			resizeOfTable();                                                   //75% of hashmap size we resize our
		}                                                                      //hashmap with method resizeOfTable.
		Node<K, V> newNode = new Node<>(key, value);                           //Create node with key/value that we
																			   // want to put in hashmap
		Node<K, V> currentNode = table[hashKeyIndex(key, table.length)];       //Create node to check does node exist
																			   //with this key
		if (currentNode == null) {                                             //If does not exist then put new node
			table[hashKeyIndex(key, table.length)] = newNode;                  //put in a cell with a given key
		} else if (currentNode.keyValue == key) {                              //If exist than replace value in cell
			currentNode.itemValue = value;
		}else {
			while (currentNode.hasNext()) {                                    //If other 2 conditions did not worked
				currentNode = currentNode.next;                                //and we have collision, we put new node
			}                                                                  //in LL in the cell
			currentNode.next = newNode;                                        //Else: put new node in cell
		}
		sizeOfTable++;                                                         //Increase number of elements in Hashmap
	}

	public V get(K key) {
		Node<K, V> currentNode = table[hashKeyIndex(key, table.length)];       //Create node to check does node exist
																			   //with this key
		if (currentNode == null) {                                             //If not - return null
			return null;
		}
		while (!currentNode.keyValue.equals(key) && currentNode.hasNext()) {   //Check other cell for this key
			currentNode = currentNode.next;
		}
		return currentNode.keyValue.equals(key) ? currentNode.itemValue : null; //If cell exist: return value in cell
	}                                                                           //If not return null;

	private void resizeOfTable() {
		Node[] newTable = new Node[table.length << 1];                          //Create new Array of nodes with length
		for (Node<K, V> node : table) {                                         // of old table << 1
			if (node != null) {                                                 //Replace new cell with new hashKeyIndex
				newTable[hashKeyIndex(node.keyValue, newTable.length)] = node;  //only if cell is not null
			}
		}
	}

	private int hashKeyIndex(K key, int tableLength) {
		return (tableLength - 1) & key.hashCode();                              //Obtain hashKeyIndex for cell
	}
	private class Node<K, V> {                                                  //Just declaration of Node class
		K keyValue;                                                             // and his methods
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
