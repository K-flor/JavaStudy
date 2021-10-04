
public class Basic {
	public static int add(int a, int b) {
		System.out.println( String.format("Returning %s as the result of %s + %s",a+b,a,b)  );
		return a+b;
	}

	public static int mult(int a, int b) {
		return a * b;
	}
	
	public static void process(Runnable r) {
		r.run();
	}
	
	public static void main(String[] args) {
		System.out.println(add(mult(3,5), mult(4,5)));
		
		Runnable r1 = () -> System.out.println("HELLO");
		process(r1);
		process(() -> System.out.println("Hello i am THREE"));
	}
}
