public class Aplication {

	public static void main(String[] args) {
		NewHashMap<Integer, Items> newHashMap = new NewHashMap<>();
		newHashMap.put(1, new Items("Square", "Green", 3));
		newHashMap.put(2, new Items("Scope", "Red", 9));
		newHashMap.put(3, new Items("Triangle", "Blue", 5));
		System.out.println(newHashMap.get(3));
	}
}
