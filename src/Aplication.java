public class Aplication {

	public static void main(String[] args) {
		NewHashMap<Integer, Items> newHashMap = new NewHashMap<>();
		newHashMap.put(1, new Items("Square", "Green", 3));
		newHashMap.put(2, new Items("Scope", "Red", 9));
		newHashMap.put(3, new Items("Triangle", "Blue", 5));
		newHashMap.put(4, new Items("Square", "Green", 3));
		newHashMap.put(6, new Items("Scope", "Red", 9));
		newHashMap.put(7, new Items("Triangle", "Blue", 5));
		newHashMap.put(8, new Items("Square", "Green", 3));
		newHashMap.put(9, new Items("Scope", "Red", 9));
		newHashMap.put(10, new Items("Triangle", "Blue", 5));
		newHashMap.put(11, new Items("Square", "Green", 3));
		newHashMap.put(12, new Items("Scope", "Red", 9));
		newHashMap.put(13, new Items("Triangle", "Blue", 5));
		newHashMap.put(14, new Items("Square", "Green", 3));
		newHashMap.put(15, new Items("Scope", "Red", 9));
		newHashMap.put(16, new Items("Triangle", "Blue", 5));
		newHashMap.put(17, new Items("Square", "Green", 3));
		newHashMap.put(18, new Items("Scope", "Red", 9));
		newHashMap.put(19, new Items("Triangle", "Blue", 5));
		System.out.println(newHashMap.get(3));
		System.out.println(newHashMap.get(2));
		System.out.println(newHashMap.get(1));
		System.out.println(newHashMap.get(0));
		System.out.println(newHashMap.get(4));
		System.out.println(newHashMap.get(5));
		System.out.println(newHashMap.get(6));
		System.out.println(newHashMap.get(7));
		System.out.println(newHashMap.get(8));
		System.out.println(newHashMap.get(9));
		System.out.println(newHashMap.get(10));
		System.out.println(newHashMap.get(11));
		System.out.println(newHashMap.get(12));
		System.out.println(newHashMap.get(13));
		System.out.println(newHashMap.get(14));
		System.out.println(newHashMap.get(15));
		System.out.println(newHashMap.get(16));
		System.out.println(newHashMap.get(17));
		System.out.println(newHashMap.get(18));
		System.out.println(newHashMap.get(19));
	}
}
