package algorithmicSolutions;

import java.util.Scanner;

public class BillBoards {

	public static int sum(int[] input, int start, int end){
		int sum = 0;
		if(start == end)
			return input[start];
		for(; start<=end; start++)
			sum += input[start];
		return sum;
	}
	public static int maxValue (int[] values, int batchSize, int start, int end, int prevBatchSize){
		int returnValue = 0;
		if(prevBatchSize + end - start + 1 <= batchSize)
			returnValue = sum(values, start, end);
		else if (prevBatchSize == batchSize)
			returnValue = maxValue(values, batchSize, start+1, end, 0);
		else{
			int v1 = values[start] + maxValue(values, batchSize, start+1, end, ++prevBatchSize);
			int v2 = maxValue(values, batchSize, start+1, end, 0);
			returnValue = v1 >= v2 ? v1 : v2;
		}
		System.out.println(start + " " + end + " " + prevBatchSize + " = " + returnValue);
		return returnValue;
			
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, batchsize;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		batchsize = s.nextInt();
		int[] input = new int[n];
		for(int i=0; i<n; i++)
			input[i] = s.nextInt();
		System.out.println(maxValue(input, batchsize, 0, n-1, 0));
	}

}
