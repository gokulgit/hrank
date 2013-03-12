package algorithmicSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CountDifferences {

	public static int countDiff(Integer[] arr, int diff){
		int count = 0;
		
		List<Integer> list = Arrays.asList(arr);
		Collections.sort(list);
		for(int i=0; i<list.size()-1; i++){
			int j = i;
			while ( j <list.size() && list.get(j) - list.get(i) <= diff){
				if(list.get(j)-list.get(i) == diff)
					count++;
				j++;
			}
		}
		return count;
	}
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int count = s.nextInt();
		int diff = s.nextInt();
		Integer[] arr = new Integer[count];
		for(int i=0; i<count; i++)
			arr[i] = s.nextInt();
		System.out.println(countDiff(arr, diff));
	}
}
