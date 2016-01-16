package Algorithms;

import java.util.List;

public class Sorting<T extends Comparable<? super T>> {
	
	/**
	 * Insertion Sort
	 *  - Time Complexity: O(n^2)
	 *  - Space Complexity: O(1)
	 * @param array
	 */
	public static <T> void insertionSort(List<T> array){
		for(int i = 1; i < array.size(); i++){
            T val = array.get(i);
            int j = i - 1;
            while(j >= 0 && ((Comparable<? super T>) array.get(j)).compareTo(val) > 0){
            	array.set(j + 1, array.get(j));
            	j--;
            }
            array.set(j + 1, val);
        }
	}
	public static <T> void quicksort(List<T> array){
		quicksort(array, 0, array.size() - 1);
	}

	private static<T> void quicksort(List<T> array, int low, int high){
		if(low >= high){
	    return;
	 	}
		int pi = partition(array, low, high);
		quicksort(array, low, pi - 1);
		quicksort(array, pi + 1, high);
	}

	public static <T> int partition(List<T> array, int low, int high){
		T p = array.get(high);
		int i = low;
		for(int j = low; j < high; j++){
		    if(((Comparable<? super T>) array.get(j)).compareTo(p) <= 0){
 	      T temp = array.get(i);
		  		array.set(i,array.get(j));
				array.set(j,temp);
				i++;
	 	   }
	 	}
		array.set(high, array.get(i));
		array.set(i,p);
		return i;
	}
}
