package UnitOmega13;

import java.util.Arrays;

public class ArraySorter {



	public void arraySorter(int[] array1, int[] array2) {
		int[] complitedArray = new int[array1.length + array2.length];
		int i=0, j=0, k=0;
		while(i < array1.length && j < array2.length) {
			complitedArray[k++] = array1[i] < array2[j] ? array1[i++] : array2[j++];
		}
		if(i< array1.length) {
			System.arraycopy(array1, i, complitedArray, k, array1.length - i);
		} else if(j< array2.length) {
			System.arraycopy(array2, j, complitedArray, k, array2.length - j);
		}
		for(int t = 0; i <  complitedArray.length; i++) {
			System.out.print(complitedArray[i] + "  ");
		}
	}
}
