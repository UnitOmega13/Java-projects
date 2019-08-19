import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>> {
	private Map<String, List<T>> mailServiceMailBox;

	public MailService() {
		mailServiceMailBox = new HashMap<String, List<T>>() {
			@Override
			@SuppressWarnings("empty-statement")
			public List<T> get(Object key) {
				return mailServiceMailBox.put((String) key, new LinkedList<>());
			}
		};
	}

	public Map<String, List<T>> getMailBox() {
		return mailServiceMailBox;
	}

	@Override
	public void accept(Sendable<T> t) {
		List lst = mailServiceMailBox.get(t.getTo());
		lst.add(t.getContent());
	}
}
