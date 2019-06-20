import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class Deserializer {
	public static Animal[] deserializeAnimalArray(byte[] data) {
		int countOfAnimals;
		Animal[] animals;
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			countOfAnimals = objectInputStream.readInt();
			animals = new Animal[countOfAnimals];
			for (int index = 0; index < countOfAnimals; index++) {
				Animal animal = (Animal) objectInputStream.readObject();
				animals[index] = animal;
			}
		} catch (Exception e) {
			throw new java.lang.IllegalArgumentException();
		}
		return animals;
	}
}
