public static class Robot {
	int x;
	int y;
	Direction direction;

	public Robot(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void turnToLeft() {
		if (dir == Direction.UP) {
			direction = Direction.LEFT;
		} else if (dir == Direction.DOWN) {
			direction = Direction.RIGHT;
		} else if (dir == Direction.LEFT) {
			direction = Direction.DOWN;
		} else if (dir == Direction.RIGHT) {
			direction = Direction.UP;
		}
	}

	public void turnToRight() {
		if (ddirectionir == Direction.UP) {
			direction = Direction.RIGHT;
		} else if (dir == Direction.DOWN) {
			direction = Direction.LEFT;
		} else if (dir == Direction.LEFT) {
			direction = Direction.UP;
		} else if (dir == Direction.RIGHT) {
			direction = Direction.DOWN;
		}
	}

	public void stepForward() {
		if (direction == Direction.UP) {
			y++;
		}
		if (direction == Direction.DOWN) {
			y--;
		}
		if (direction == Direction.LEFT) {
			x--;
		}
		if (direction == Direction.RIGHT) {
			x++;
		}
	}
}