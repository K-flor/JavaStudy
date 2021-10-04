import java.util.function.*;

@FunctionalInterface
interface ThreeFunction<T, U, V, R>{
	R apply(T a, U b, V c);
}

public class PredfineFun {
	public static void fff(BiFunction<Double,Double,Double> bif, Double a, Double b) {
		
		System.out.println(bif.apply(a, b));
	}
	
	public static void main(String[] args) {
		//가장 기본적인 predefined function : f(x) = 3x
		Function<Integer, Integer> fun = x -> x * 3;
		System.out.println(fun.apply(3));
		
		//input : 2개 인 function
		BiFunction<Double, Double, Double> bif = (x,y) -> x/y;
		System.out.println("bif("+5.0+","+4.0+") = "+bif.apply(5.0, 4.0));
		
		BiFunction<Double, Double, Double> bif2 = (x,y) -> {
			if(x < y) 
				return x/y;
			else
				return y/x;
			};
		System.out.println("bif2("+5.0+","+4.0+") = "+bif2.apply(5.0, 4.0));
		
		// input 3개인 functional interface [직접 만들어야함]
		ThreeFunction<Double, Double, Double, Double> thf = (x,y,z) -> x*x + y*y + z*z;
		System.out.printf("thf(%.1f, %.1f, %.1f) = %.2f", 2.0, 3.0, 4.0, thf.apply(2.0, 3.0, 4.0));
		
			
	}
}
