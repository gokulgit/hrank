package algorithmicSolutions;

import java.util.Scanner;

public class BillBoards {

	public static Long sum(Long[] input, int start, int end){
		Long sum = 0l;
		if(start == end)
			return input[start];
		for(; start<=end; start++)
			sum += input[start];
		return sum;
	}
	public static Long maxValue (Long[] values, int batchSize, int start, int end, int prevBatchSize){
		Long returnValue = 0l;
		if(prevBatchSize + end - start + 1 <= batchSize)
			returnValue = sum(values, start, end);
		else if (prevBatchSize == batchSize)
			returnValue = maxValue(values, batchSize, start+1, end, 0);
		else{
			Long v1 = values[start] + maxValue(values, batchSize, start+1, end, ++prevBatchSize);
			Long v2 = maxValue(values, batchSize, start+1, end, 0);
			returnValue = v1 >= v2 ? v1 : v2;
		}
		System.out.println(start + " " + end + " " + prevBatchSize + " = " + returnValue);
		return returnValue;
			
	}
	
	public static Long maxValue(Long[] values, int batchSize) {
		Long maxValue[][] = new Long[values.length][batchSize + 1];
		int n = values.length;
		int k = 0;
		for (; k < batchSize; k++)
			maxValue[n - 1][k] = values[n - 1];
		maxValue[n - 1][k] = 0l;
		for (int x = n - 2; x > 0; x--) {
			for (k = 0; k < batchSize; k++) {
				maxValue[x][k] = ( maxValue[x + 1][k] >= values[x] + maxValue[x + 1][k + 1] ) ? maxValue[x + 1][k]
						: values[x] + maxValue[x + 1][k + 1];
			}
			maxValue[x][k] = maxValue[x + 1][0];
		}
		maxValue[0][0] = ( maxValue[1][0] >= values[0] + maxValue[1][1]) ? maxValue[1][0] : values[0] + maxValue[1][1];
		return maxValue[0][0];
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
		Long[] input = new Long[n];
		for(int i=0; i<n; i++)
			input[i] = s.nextLong();
//		System.out.println(maxValue(input, batchsize, 0, n-1, 0));
		System.out.println(maxValue(input, batchsize));
	}

}
