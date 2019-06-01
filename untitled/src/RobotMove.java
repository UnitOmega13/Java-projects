package src;

class RobotMove {

		public static void moveRobot (Robot robot, int toX, int toY){
			int getX = robot.getX();
			int getY = robot.getY();

			if (getX >= toX) {
				while (robot.getDirection() != Direction.LEFT) {
					robot.turnToLeft();
				}
				while (getX != toX) {
					robot.stepForward();
					getX--;
				}
			} else {
				while (robot.getDirection() != Direction.RIGHT) {
					robot.turnToRight();
				}
				while (getX != toX) {
					robot.stepForward();
					getX++;
				}
			}
			if (getY >= toY) {
				while (robot.getDirection() != Direction.DOWN) {
					robot.turnToLeft();
				}
				while (getY != toY) {
					robot.stepForward();
					getY--;
				}
			} else {
				while (robot.getDirection() != Direction.UP) {
					robot.turnToRight();
				}
				while (getY != toY) {
					robot.stepForward();
					getY++;
				}
			}
		}
	}
