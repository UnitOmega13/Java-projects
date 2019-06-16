public class Task1 {

	public static void main(String[] args) {
		System.out.println(getCallerClassAndMethodName());
		anotherMethod();
	}

	private static void anotherMethod() {
		System.out.println(getCallerClassAndMethodName());
	}

	public static String getCallerClassAndMethodName() {
		StackTraceElement[] stackTraceElement = new Exception().getStackTrace();
		if (stackTraceElement.length < 3) {
			return null;
		} else {
			return stackTraceElement[2].getClassName() + "#" + stackTraceElement[2].getMethodName();
		}
	}
}
