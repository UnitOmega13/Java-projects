package UnitOmega13;

public class RobotMove {

	public String moveRobotTo(int xCoordinat, int yCoordinat){
		RobotNew robotNew = new RobotNew();
		StringBuilder moves = new StringBuilder();
		int currentDirrectionX = 0;
		int currentDirrectionY = 0;
		String allMoves;
		String robotDirection = robotNew.getDirection();
		if(robotDirection.equals("UP")){
			currentDirrectionY = 1;
		}else if(robotDirection.equals("DOWN")){
			currentDirrectionY = -1;
		}else if(robotDirection.equals("LEFT")){
			currentDirrectionX = -1;
		}else if(robotDirection.equals("RIGHT")){
			currentDirrectionY = 1;
		}
		if(currentDirrectionY == 1){
			moves.append("robot.turnRight(); ");
		}else if(currentDirrectionY == -1){
			moves.append("robot.turnRight(); ");
		}
		if(yCoordinat == 0){
			if((currentDirrectionX == 1) & (xCoordinat >= 0)){
				for (int i = 0; i <= xCoordinat; i++){
					moves.append("robot.stepForward(); ");
				}
			}else if((currentDirrectionX == -1) & (xCoordinat < 0)){
				for (int i = 0; i <= Math.abs(xCoordinat); i--){
					moves.append("robot.stepForward(); ");
				}
			}
		}else if((currentDirrectionX == -1) & (xCoordinat > 0)){
			moves.append("robot.turnRight(); ");
			moves.append("robot.turnRight(); ");
			for (int t = 0; t <= Math.abs(xCoordinat); t++){
				moves.append("robot.stepForward(); ");
			}
		}else{
			moves.append("robot.turnRight(); ");
			for (int t = 0; t <= Math.abs(xCoordinat); t++){
				moves.append("robot.stepForward(); ");
			}

		}
		if(xCoordinat == 0){
			if((currentDirrectionY == 1) & (yCoordinat > 0)){
				for (int i = 0; i <= Math.abs(yCoordinat); i++){
					moves.append("robot.stepForward(); ");
				}
			}else if((currentDirrectionY == -1) & (yCoordinat < 0)){
				for (int i = 0; i >= Math.abs(yCoordinat); i--){
					moves.append("robot.stepForward(); ");
				}
			}
		}else if((currentDirrectionY == -1) & (yCoordinat > 0)){
			moves.append("robot.turnRight(); ");
			moves.append("robot.turnRight(); ");
			for (int t = 0; t <= Math.abs(yCoordinat); t++){
				moves.append("robot.stepForward(); ");
			}
		}else{
			moves.append("robot.turnRight(); ");
			for (int t = 0; t == Math.abs(yCoordinat); t++){
				moves.append("robot.stepForward(); ");
			}

		}
		if((xCoordinat > 0) && (yCoordinat > 0) && (currentDirrectionX == 1)){
				for (int i = 0; i == xCoordinat; i--){
					moves.append("robot.stepForward(); ");
				}
				moves.append("robot.turnRight(); ");

				for (int i = 0; i <= yCoordinat; i--){
					moves.append("robot.stepForward(); ");
				}
		}else if((xCoordinat < 0) && (yCoordinat < 0) && (currentDirrectionX == -1)){
			for (int i = 0; i <= Math.abs(xCoordinat); i--){
				moves.append("robot.stepForward(); ");
			}
			moves.append("robot.turnLeft(); ");

			for (int i = 0; i <= Math.abs(yCoordinat); i--){
				moves.append("robot.stepForward(); ");
			}
		}else if((xCoordinat > 0) && (yCoordinat < 0) && (currentDirrectionX == -1)){
			moves.append("robot.turnLeft(); ");
			for (int i = 0; i <= Math.abs(yCoordinat); i++){
				moves.append("robot.stepForward(); ");
			}
			moves.append("robot.turnLeft(); ");
			for (int i = 0; i <=  Math.abs(xCoordinat); i--){
				moves.append("robot.stepForward(); ");
			}
		}else if((xCoordinat < 0) && (yCoordinat > 0) && (currentDirrectionX == 1)){
			moves.append("robot.turnRight();/");
			for (int i = 0; i <= yCoordinat; i++){
				moves.append("robot.stepForward(); ");
			}
			moves.append("robot.turnRight(); ");
			for (int i = 0; i <= xCoordinat; i--){
				moves.append("robot.stepForward(); ");
			}
		}
		allMoves = moves.toString();
		String[] moves2 = allMoves.split(" ");
		for (int i = 1; i <= moves2.length - 1; i++) {
			System.out.println(moves2[i]);
		}
		return allMoves;
	}
}
