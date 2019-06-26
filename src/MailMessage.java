public class MailMessage implements Sendable<String> {
	private String sFrom;
	private String sTo;
	private String sContent;
	public String getFrom(){
		return sFrom;
	}
	@Override
	public String getTo(){
		return sTo;
	}
	@Override
	public String getContent(){
		return sContent;
	}
	public MailMessage (String From, String To, String Content){
		sFrom = From;
		sTo = To;
		sContent = Content;
	}
}