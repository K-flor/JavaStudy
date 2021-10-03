import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;
import org.apache.commons.lang3.*;
import org.apache.commons.math3.util.MathArrays;

public class CompareTime {
	static int[] nextPermutation2(int n) {
		List<Integer> range = IntStream.range(0, n).boxed().collect(Collectors.toList());
		Collections.shuffle(range); 
		int[] tour = range.stream().mapToInt(i->i).toArray();
		
		return tour;
	}

	static int[] nextPermutation1(int n){
		int[] re = new int[n];

		for (int i = 0; i < n; i++)
			re[i] = i;
		
		MathArrays.shuffle(re);
		return re;
	}

	public static void main(String[] args){
		int n = 10;
		
		long start1 = System.currentTimeMillis();
		int[] p1 = nextPermutation1(n);
		long end1 = System.currentTimeMillis();
		System.out.println("nextPermutation1 실행 시간 : "+ ( end1 - start1 )/1000.0 );
		
		long start2 = System.currentTimeMillis();
		int[] p2 = nextPermutation2(n);
		long end2 = System.currentTimeMillis();
		System.out.println("nextPermutation2 실행 시간 : "+ ( end2 - start2 )/1000.0 );

		//System.out.println(Arrays.toString(p1));
		//System.out.println(Arrays.toString(p2));
		
	}
}