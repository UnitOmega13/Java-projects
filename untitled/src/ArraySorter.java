package src;

class ArraySorter {

	int[] arraySorter(int[] a1, int[] a2) {
		int[] complitedArray = new int[a1.length + a2.length];
		int indexForFirstArray = 0;
		int indexForSecondArray = 0;
		int indexForThirdArray = 0;
		while (indexForFirstArray < a1.length && indexForSecondArray < a2.length) {
			complitedArray[indexForThirdArray++] = a1[indexForFirstArray] < a2[indexForSecondArray] ? a1[indexForFirstArray++] : a2[indexForSecondArray++];
		}
		if (indexForFirstArray < a1.length) {
			System.arraycopy(a1, indexForFirstArray, complitedArray, indexForThirdArray, a1.length - indexForFirstArray);
		} else if (indexForSecondArray < a2.length) {
			System.arraycopy(a2, indexForSecondArray, complitedArray, indexForThirdArray, a2.length - indexForSecondArray);
		}
		return complitedArray;
	}
}
