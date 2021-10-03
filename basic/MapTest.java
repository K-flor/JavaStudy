/*
*	HashMap을 for each에 사용하고 싶을때.  
*/

import java.util.*;

public class MapTest{
	public static void main(String[] args){
		Map<String,Integer> map = new HashMap<>();
		String[] st = {"A","B","C","D","E","F"};
		int ind = 1;
		for(String s : st)
			map.put(s,ind++);
		
		System.out.println(map);

		// 첫번째 방법
		Integer max1 = Integer.MIN_VALUE;
		String max_str1="";
		for( Map.Entry<String,Integer> ent : map.entrySet() ) {
			if(max1 < ent.getValue() ) {
				System.out.println(ent.getKey());
				max_str1 = ent.getKey();
			}
		}
		System.out.println("the key has max value : "+max_str1);

		// 두번째 방법
		Integer max2 = Integer.MIN_VALUE;
		String max_str2 = "";
		int te = 333;
		map.forEach((k,v) -> {System.out.println(max2);
		if(max2 < v){
			te = v +1;
			//max_str2 = k;
			System.out.println(k);
		}});	
	}





}