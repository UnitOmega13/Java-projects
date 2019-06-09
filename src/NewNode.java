public class NewNode<T> {
	public NewNode<T> previous;
	public NewNode<T> next;
	public T value;

	public NewNode(T value) {
		this.value = value;
	}

	public void setPrevious(NewNode previous) {
		this.previous = previous;
	}

	public void setNext(NewNode next) {
		this.next = next;
	}
}
