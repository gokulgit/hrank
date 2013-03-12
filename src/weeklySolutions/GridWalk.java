package weeklySolutions;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GridWalk {

	/**
	 * @param args
	 */
	private static Map<String, Long> m = new HashMap<String, Long>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		BigInteger[][] matrix = new BigInteger[n+1][n+1];
		for( int y=0; y<=n; y++){
			for( int x=0; x<=n; x++){
				if ( y == 0 || x == 0 ){
					matrix[x][y] = BigInteger.valueOf(0l);
					continue;
				}
				if ( x > y ){
					matrix[x][y] = BigInteger.valueOf(0l);
					continue;
				}
				if ( x == 1){
					matrix[x][y] = BigInteger.valueOf(1l);
					continue;
				}
				matrix[x][y] = matrix[x-1][y].add(matrix[x][y-1]).mod(BigInteger.valueOf(10007));
			}
		}
		System.out.print(matrix[n][n].multiply(BigInteger.valueOf(2l)).mod(BigInteger.valueOf(10007)));
	}

}
