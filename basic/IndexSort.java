import java.util.*;

public class IndexSort< T extends Comparable<T> > implements Comparator<Integer> {
	T[] val;
	Integer[] index;

	IndexSort(T[] a){
		val = a;
		index = new Integer[val.length];

		for(int i=0; i < val.length; i++)
			index[i] = i;
	}

	public Integer[] sort(T[] a){
		Arrays.sort(index, this);
		return index;
	}

	public int compare(Integer i1, Integer i2){
		T v1 = val[i1];
		T v2 = val[i2];
		return v1.compareTo(v2);
	}

	public static void main(String[] args){
		Integer[] a = {5,1,10,4,8};
		IndexSort<Integer> is = new IndexSort<>(a);
		Integer[] id = is.sort(a);

		for(Integer j : id)
			System.out.println(j+" ");

	}
}