public interface Sendable<T> {
	public String getTo();

	public String getFrom();

	public T getContent();
}
