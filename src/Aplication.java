import java.util.ArrayList;
import java.util.LinkedList;

public class Aplication {

	public static void main(String[] args) {
		List l = new NewLinkedList<>();
		l.add("1");
		l.add("2");
		l.add("3");
		l.add("2+", 2);
		System.out.println(l);
	}
}
