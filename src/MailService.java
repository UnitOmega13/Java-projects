import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>> {
	private final Map<String, List<T>> msMailBox;

	public MailService() {
		msMailBox = new HashMap<String, List<T>>() {
			@Override
			@SuppressWarnings("empty-statement")
			public List<T> get(Object key) {
				if (msMailBox.containsKey(key)) {
					return msMailBox.getOrDefault(key, null);
				} else {
					List<T> lst = new LinkedList<>();
					msMailBox.put((String) key, lst);
					return lst;

				}
			}
		};
	}

	public Map<String, List<T>> getMailBox() {
		return msMailBox;
	}

	@Override
	public void accept(Sendable<T> t) {
		List lst = msMailBox.get(t.getTo());
		lst.add(t.getContent());
	}
}