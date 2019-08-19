public class Aplication {

	public static void main(String[] args) {
		Storage newStorageItem = new Storage();
		newStorageItem.put(1,new Items("Max","Hruslov",25));
		System.out.println(newStorageItem.get(1));
	}
}
