public class Salary implements Sendable<Integer> {
	private String job;
	private String name;
	private Integer salary;

	public Salary(String job, String name, Integer salary) {
		this.job = job;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String getTo() {
		return name;
	}

	@Override
	public String getFrom() {
		return job;
	}

	@Override
	public Integer getContent() {
		return salary;
	}
}
