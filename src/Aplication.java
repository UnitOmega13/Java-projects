public class Aplication {

	public static void main(String[] args) {
		Storage<String> storageOfStrings = new Storage<>();
		storageOfStrings.add("element 1");
		storageOfStrings.add("element 2");
		storageOfStrings.add("element 3");
		System.out.println(storageOfStrings);

		Storage<Items> storageOfItems = new Storage<>();
		storageOfItems.add(new Items("Max","Max",25));
		storageOfItems.add(new Items("Max","Max",26));
		storageOfItems.add(new Items("Max","Max",27));
		System.out.println(storageOfItems);

		Storage<String> storageOfStringsSecond = new Storage<>();
		storageOfStringsSecond.add("element 2.1");
		storageOfStringsSecond.add("element 2.2");
		storageOfStringsSecond.add("element 2.3");
		System.out.println(storageOfStrings);

		storageOfStrings.addAll(storageOfStringsSecond);
		System.out.println(storageOfStrings);

		storageOfStrings.add("element with index", 66);
		System.out.println(storageOfStrings);

		System.out.println(storageOfItems.get(2));
		System.out.println("Storage is empty? : " + storageOfStrings.isEmpty());
		System.out.println("Storege size : " + storageOfStrings.size());

		storageOfItems.remove(1);
		System.out.println(storageOfItems);

		storageOfStrings.remove("element 1");
		System.out.println(storageOfStrings);

		storageOfStrings.set("element 2", 0);
		System.out.println(storageOfStrings);
	}
}
