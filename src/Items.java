public class Items {
	private String name;
	private String subName;
	private int age;

	Items(String name, String subName, int age) {
		this.name = name;
		this.subName = subName;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Items{" +
				"name='" + name + '\'' +
				", subName='" + subName + '\'' +
				", age=" + age +
				'}';
	}
}
