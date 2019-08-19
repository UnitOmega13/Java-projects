public class Items {
	private String name;
	private String attributes;
	private int square;

	Items(String name, String subName, int age) {
		this.name = name;
		this.attributes = subName;
		this.square = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubName() {
		return attributes;
	}

	public void setSubName(String subName) {
		this.attributes = subName;
	}

	public int getAge() {
		return square;
	}

	public void setAge(int age) {
		this.square = age;
	}

	@Override
	public String toString() {
		return "Items{" +
				"name='" + name + '\'' +
				", subName='" + attributes + '\'' +
				", age=" + square +
				'}';
	}
}
