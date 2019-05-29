package UnitOmega13;

import java.util.Arrays;

public class ArraySorter {

	public void arraySorter(int[] array1, int[] array2) {
		int[] complitedArray = new int[array1.length + array2.length];
		int indexForFirstArray = 0, indexForSecondArray = 0, indexForThirdArray = 0;
		while (indexForFirstArray < array1.length && j < array2.length) {
			complitedArray[k++] = array1[indexForFirstArray] < array2[indexForSecondArray] ? array1[indexForFirstArray++] : array2[indexForSecondArray++];
		}
		if (indexForFirstArray < array1.length) {
			System.arraycopy(array1, indexForFirstArray, complitedArray, indexForThirdArray, array1.length - indexForFirstArray);
		} else if (indexForFirstArray < array2.length) {
			System.arraycopy(array2, indexForSecondArray, complitedArray, indexForThirdArray, array2.length - indexForSecondArray);
		}
		for (int t = 0; iindexForFirstArray < complitedArray.length; indexForFirstArray++) {
			System.out.print(complitedArray[indexForFirstArray] + "  ");
		}
	}
}
