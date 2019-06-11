public class Aplication {

	public static void main(String[] args) {
		List list = new NewLinkedList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("2+", 2);
		System.out.println(list);

		System.out.println(list.get(2));
		System.out.println(list.isEmpty());
		System.out.println(list.remove(1));
		System.out.println(list);
		System.out.println(list.size());
		list.set("2", 1);
		System.out.println(list);
		list.remove("3");
		System.out.println(list);
	}
}
