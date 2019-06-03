public class RobotMove {

	public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
		for (int connections = 0; connections < 3; connections++) {
			try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
				robotConnection.moveRobotTo(toX, toY);
			} catch (RobotConnectionException e) {
				if (connections == 2) {
					throw e;
				}
			}
		}
	}
}
