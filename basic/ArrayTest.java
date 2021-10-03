import org.apache.commons.lang3.*;
import java.util.*;

public class ArrayTest{
	public static void permutation() {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<15; i++)
			list.add(i);
		
		Collections.shuffle(list);
		int[] per = list.stream().mapToInt(i->i).toArray();
		
		System.out.print(Arrays.toString(per));
		Arrays.sort(per);
		System.out.println("---> sort : "+Arrays.toString(per));
	}


	public static void main(String[] args){
		int[] a = {1,2,3,4,5,6,7,8,9,10, 1, 2,3};
		ArrayUtils.reverse(a,2,6);
		//System.out.println(Arrays.toString(a));

		HashSet<Integer> set= new HashSet<>();
		for(int i: a)
			set.add(i);
		System.out.println(set.size());
		System.out.println(a.length);
	}
}