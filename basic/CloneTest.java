import java.util.*;

public class CloneTest{
	public static void main(String[] args){
		int[] a = {1,2,3};
		int[] b = a.clone();

		System.out.println("b is copy of a : "+Arrays.toString(b));
		a[1] = a[1]*10;
		System.out.println("change a to "+Arrays.toString(a));
		System.out.println("then b is : "+ Arrays.toString(b));
	}
}