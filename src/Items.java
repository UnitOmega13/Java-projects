public class Items {
	private String name;
	private String nickName;
	private int age;

	Items(String name, String subName, int age) {
		this.name = name;
		this.nickName = subName;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubName() {
		return nickName;
	}

	public void setSubName(String subName) {
		this.nickName = subName;
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
				", subName='" + nickName + '\'' +
				", age=" + age +
				'}';
	}
}
