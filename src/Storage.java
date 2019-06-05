import java.util.ArrayList;

class Storage{
	private ArrayList<Integer> listOfKeys = new ArrayList<>();
	private ArrayList<Object> listOfValues = new ArrayList<>();

	Object get(int key) {
		return listOfValues.get(key - 1);
	}


	void put(int key, Object value) {
		listOfKeys.add(key);
		listOfValues.add(value);

	}
}
