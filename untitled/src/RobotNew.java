import java.util.Random;

public class RobotNew {
	private String[] listDirections = {"DOWN", "UP", "RIGHT", "LEFT"};
	private Random random = new Random();
	private String randomdirection;

	String getDirection() {
		int INDEXn = random.nextInt(listDirections.length);
		for (int i2 = 0; i2 < INDEXn; i2++) {
			randomdirection = (String) (listDirections[INDEXn]);
		}
		return randomdirection;
	}

	public int getX() {
		return 3;
	}

	public int getY() {
		return 2;
	}

	public void turnLeft() {
	}

	public void turnRight() {
	}

	public void stepForward() {
	}
}
