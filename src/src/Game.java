public class Game {

	public boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
		return (a ^ b) && (c ^ d) || (a ^ c) && (b ^ d);
	}
}
