import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;

public class StreamTest2 {

	public static void main(String[] args) {
		List<Dish> menu = Dish.menu;
	/*	
	 *  Error :: stream has already been operated upon or closed
	 *  Stream should be used only Once!

		Stream<Dish> a = menu.stream();
		Stream<Dish> b = a.filter(dish -> dish.getCalories()>500);
		Stream<String> c1 = b.map(dish -> dish.getName());
		Stream<String> c2 = b.map(Dish::getName);
		
	 *  ==> c1 또는 c2만 실행 시켜야함!	
	 */
		
		//System.out.println("Stream : "+a);
		//System.out.println("After filter : "+b);
		//System.out.println("After map : "+c1);
		//System.out.println("After limit : "+d);
		//System.out.println("After collect : "+f);
		
		List<String> HighCal = menu.stream()
				.filter(dish -> dish.getCalories() > 500 )
				.map(Dish::getName)
				.limit(3)
				.collect(toList());
		
		System.out.println(HighCal);
		
		Stream<Dish> a = menu.stream();
		System.out.println("Stream : "+a);
		Stream<Dish> b = a.filter(dish -> dish.getCalories()>500);
		System.out.println("After filter : "+b);
		Stream<String> c1 = b.map(dish -> dish.getName());
		System.out.println("After map : "+c1);
		
		
	}
}
