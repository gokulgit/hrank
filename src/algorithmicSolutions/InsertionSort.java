package algorithmicSolutions;

import java.util.Scanner;

public class InsertionSort {

	/**
	 * @param args
	 */
	public static void insertSort(Integer[] input){
		for(int indexToPlace = 1; indexToPlace < input.length ; indexToPlace++){
			int valueToPlace = input[indexToPlace];
			int position = indexToPlace;
			for(; position >0; position--){
				if(input[position-1] > valueToPlace)
					input[position] = input[position-1];
				else
					break;
			}
			input[position] = valueToPlace;
			spit(input);
		}
	}
	
	public static void spit(Integer[] input){
		for(int i =0; i<input.length; i++){
			if(i > 0)
				System.out.print(" ");
			System.out.print(input[i]);
		}
		System.out.println("\n");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Integer[] input = new Integer[n];
		for(int i=0; i<n; i++){
			input[i] = s.nextInt();
		}
		spit(input);
		insertSort(input);
	}

}
