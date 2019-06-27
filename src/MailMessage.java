public class MailMessage implements Sendable<String> {
	private String sender;
	private String destination;
	private String packageType;

	@Override
	public String getFrom() {
		return sender;
	}

	@Override
	public String getTo() {
		return destination;
	}

	@Override
	public String getContent() {
		return packageType;
	}

	public MailMessage(String sender, String destination, String packageType) {
		this.sender = sender;
		this.destination = destination;
		this.packageType = packageType;
	}
}