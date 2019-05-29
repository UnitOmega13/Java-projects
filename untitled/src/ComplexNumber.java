public class ComplexNumber {

	private final double re;
	private final double im;

	ComplexNumber(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public double getRe() {
		return re;
	}

	public double getIm() {
		return im;
	}

//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || getClass() != o.getClass()) return false;
//		ComplexNumber complexNumber = (ComplexNumber) o;
//		if (Double.compare(complexNumber.re, re) != 0) return false;
//		return Double.compare(complexNumber.im, im) == 0;
//	}

	@Override
	public int hashCode() {
		int result;
		long temporary;
		temporary = Double.doubleToLongBits(re);
		result = (int) (temporary ^ (temporary >>> 32));
		temporary = Double.doubleToLongBits(im);
		result = 31 * result + (int) (temporary ^ (temporary >>> 32));
		return result;
	}
}
