package algorithmicSolutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSort1 {
	
	
	static void quicksort(int[] input, int low, int high){
		if ( !(low < high) )
			return;
		int i = low, j = high;
		int pivot = low;
		while ( i < j){
			while (input[i] <= input[pivot] && i < high)
				i++;
			while (input[j] >= input[pivot] && j > low)
				j--;
			if ( i < j ){
				swap(input, i , j);
				i++;
				j--;
			}
		}				
		if(j != pivot)
			swap(input, pivot, j);
		quicksort(input, low, j-1);
		quicksort(input, j+1, high);
		printArray(input, low, high);

	}
	static void sort(int[] input){
		if (input.length <= 1)
			return;
		quicksort(input, 0, input.length-1);
	}
	
	static void swap(int[] ar, int top, int bottom){
		ar[top] = ar[top]+ar[bottom];
		ar[bottom] = ar[top]-ar[bottom];
		ar[top] = ar[top]-ar[bottom];
	}

	/* Tail starts here */

	static void printArray(int[] ar, int low, int high) {
		while (low <= high) {
			System.out.print(ar[low++] + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		sort(ar);
	}

}
