public class Salary implements Sendable<Integer> {
	private String sJob;
	private String sName;
	private Integer iSalary;

	public Salary(String Job, String Name, Integer Salary) {
		sJob = Job;
		sName = Name;
		iSalary = Salary;
	}

	@Override
	public String getTo() {
		return sName;
	}

	@Override
	public Integer getContent() {
		return iSalary;
	}
}
