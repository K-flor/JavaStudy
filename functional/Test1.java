/*
 * 기본적인 functional interface
 * Adder 와 Multier
 */
@FunctionalInterface
interface Adder {
	int add(int x, int y);
}

@FunctionalInterface
interface Multier{
	double mul(double a, double b);
}

public class Test1 {
	public static void main(String[] args) {
		Adder adder = (x,y) -> x + y;
		Multier multier = (x,y) -> x * y ;
		
		System.out.println(adder.add(14, 155));
		System.out.println(multier.mul(2.0, 5.2));
	}
}

