package src;

import src.RobotConnection;
import src.RobotConnectionException;
import src.RobotConnectionManager;

public class RobotMove {
	public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY){
	RobotConnection robotConnection;
		for (int connection = 0; connection < 3; connection++) {
			try {
				robotConnection = robotConnectionManager.getConnection();
			} catch (RobotConnectionException e) {
				continue;
			}
			try {
				robotConnection.moveRobotTo(toX, toY);
				return;
			} catch (RobotConnectionException e) {
			} finally {
				try {
					robotConnection.close();
				} catch (RobotConnectionException e) {
				}
			}
		}
		throw new RobotConnectionException("ERROR!");
	}
}
