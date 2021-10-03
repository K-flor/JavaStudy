import java.util.*;

public class MatrixMulti{
	// i - j - k 순으로 for-loop
	public static int[][] mult1(int[][] a, int[][] b, int n){
		int[][] c = new int[n][n];

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				for(int k=0; k<n; k++)
					c[i][j] += a[i][k] * b[k][j];
			}
		}

		return c;
	}

// i - k - j 순으로 for-loop
	public static int[][] mult2(int[][] a, int[][] b, int n){
		int[][] c = new int[n][n];

		for(int i=0; i<n; i++){
			for(int k=0; k<n; k++){
				for(int j=0; j<n; j++)
					c[i][j] += a[i][k] * b[k][j];
			}
		}

		return c;
	}

	public static void main(String[] args){
		int n = 2000;

		Random rand = new Random();

		int[][] a = new int[n][n];
		int[][] b = new int[n][n];
		int[][] c = new int[n][n];

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				a[i][j] = rand.nextInt(3);
				b[i][j] = rand.nextInt(3);
			}
		}
		long s1 = System.currentTimeMillis();
		int[][] c1 = mult1(a,b,n);
		long e1 = System.currentTimeMillis();
		
		System.out.println("Time i-j-k :"+(e1-s1)/1000);

		long s2 = System.currentTimeMillis();
		int[][] c2 = mult2(a,b,n);
		long e2 = System.currentTimeMillis();
		System.out.println("Time i-k-j :"+(e2-s2)/1000);
		
	}
}