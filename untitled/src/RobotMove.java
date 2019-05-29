class RobotMove {

	void moveRobotTo(int xCoordinat, int yCoordinat) {
		RobotNew robotNew = new RobotNew();
		StringBuilder moves = new StringBuilder();
		int currentDirrectionX = 0;
		int currentDirrectionY = 0;
		String allMoves;
		String robotDirection = robotNew.getDirection();
		switch (robotDirection) {
			case "UP":
				currentDirrectionY = 1;
				break;
			case "DOWN":
				currentDirrectionY = -1;
				break;
			case "LEFT":
				currentDirrectionX = -1;
				break;
			case "RIGHT":
				currentDirrectionY = 1;
				break;
		}
		if (currentDirrectionY == 1) {
			moves.append("robot.turnRight(); ");
		} else if (currentDirrectionY == -1) {
			moves.append("robot.turnRight(); ");
		}
		if (yCoordinat == 0) {
			if ((currentDirrectionX == -1) & (xCoordinat < 0)) {
				moves.append("robot.stepForward(); ".repeat(Math.max(0, 0 - Math.abs(xCoordinat) + 1)));
			}
		} else if ((currentDirrectionX == -1) & (xCoordinat > 0)) {
			moves.append("robot.turnRight(); ");
			moves.append("robot.turnRight(); ");
			moves.append("robot.stepForward(); ".repeat(Math.abs(xCoordinat) + 1));
		} else {
			moves.append("robot.turnRight(); ");
			moves.append("robot.stepForward(); ".repeat(Math.max(0, Math.abs(xCoordinat) + 1)));

		}
		if (xCoordinat == 0) {
			if ((currentDirrectionY == 1) & (yCoordinat > 0)) {
				moves.append("robot.stepForward(); ".repeat(Math.abs(yCoordinat) + 1));
			} else if ((currentDirrectionY == -1) & (yCoordinat < 0)) {
				moves.append("robot.stepForward(); ".repeat(Math.max(0, 0 - Math.abs(yCoordinat) + 1)));
			}
		} else if ((currentDirrectionY == -1) & (yCoordinat > 0)) {
			moves.append("robot.turnRight(); ");
			moves.append("robot.turnRight(); ");
			moves.append("robot.stepForward(); ".repeat(Math.abs(yCoordinat) + 1));
		} else {
			moves.append("robot.turnRight(); ");
			for (int t = 0; t == Math.abs(yCoordinat); t++) {
				moves.append("robot.stepForward(); ");
			}

		}
		if ((xCoordinat < 0) && (yCoordinat < 0) && (currentDirrectionX == -1)) {
			moves.append("robot.stepForward(); ".repeat(Math.max(0, 0 - Math.abs(xCoordinat) + 1)));
			moves.append("robot.turnLeft(); ");

			moves.append("robot.stepForward(); ".repeat(Math.max(0, 0 - Math.abs(yCoordinat) + 1)));
		} else if ((xCoordinat > 0) && (yCoordinat < 0) && (currentDirrectionX == -1)) {
			moves.append("robot.turnLeft(); ");
			moves.append("robot.stepForward(); ".repeat(Math.max(0, Math.abs(yCoordinat) + 1)));
			moves.append("robot.turnLeft(); ");
			moves.append("robot.stepForward(); ".repeat(Math.max(0, 0 - Math.abs(xCoordinat) + 1)));
		}
		allMoves = moves.toString();
		String[] moves2 = allMoves.split(" ");
		for (int i = 1; i <= moves2.length - 1; i++) {
			System.out.println(moves2[i]);
		}
	}
}
