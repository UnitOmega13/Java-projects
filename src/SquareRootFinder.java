public class SquareRootFinder {
	public double findSquareRoot(double findSqrtNumber) {
		if(findSqrtNumber >= 0) {
			double number = Math.sqrt(findSqrtNumber);
		}else{
			System.out.println("Sorry, the number is negative");
		}
		return number;
	}
}
