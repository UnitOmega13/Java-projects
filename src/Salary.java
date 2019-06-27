public class Salary implements Sendable<Integer> {
	private String job;
	private String name;
	private Integer salary;

	public Salary(String job, String name, Integer salary) {
		job = job;
		name = name;
		salary = salary;
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
