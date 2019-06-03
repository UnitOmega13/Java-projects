import com.sun.org.apache.xml.internal.serializer.SerializationHandler;
import com.sun.org.apache.xml.internal.serializer.Serializer;
import com.sun.org.apache.xml.internal.serializer.SerializerBase;
import com.sun.xml.internal.ws.developer.Serialization;
import com.sun.xml.internal.ws.developer.SerializationFeature;

public class CloneCarTest implements Cloneable {
	private String name;
	private String color;
	private int maxSpeed;
	private int capacity;

	public CloneCarTest(String name, String color, int maxSpeed, int capacity) {
		this.name = name;
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}


	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public CloneCarTest(CloneCarTest newCloneCarTest) throws CloneNotSupportedException {
		this(newCloneCarTest.getName(), newCloneCarTest.getColor(), newCloneCarTest.getMaxSpeed(), newCloneCarTest.getCapacity());
	}

	@Override
	public String toString() {
		return "CloneCarTest{" +
				"name='" + name + '\'' +
				", color='" + color + '\'' +
				", maxSpeed=" + maxSpeed +
				", capacity=" + capacity +
				'}';
	}
}
