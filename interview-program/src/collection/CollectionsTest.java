package collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionsTest {

	public static void main(String[] args) {
		/* Collections has min, max, reverse, sort, frequency  
		 * 
		 * 
		 */
		
		List<String> l = Arrays.asList("a","c","z", "x");
		System.out.println(Collections.min(l));
		System.out.println(Collections.max(l));
		List<String> l2 = Arrays.asList("a","A","c","Z", "x");
		System.out.println(Collections.min(l2));// caps letter are considered as min
		System.out.println(Collections.max(l2));
		System.out.println(Collections.max(l2,String.CASE_INSENSITIVE_ORDER));
		System.out.println(l2);//insertion order

		System.out.println("__________________________");
		List<String> l3 = Arrays.asList("a","A","c","Z", "x");
		//l3.add("7"); we can not modify it, but we assign different collection
		Collections.reverse(l3);
		System.out.println("reverse list :  "+l3);
		
		Collections.sort(l3); //
		System.out.println("Short list :  "+l3);
		
		List<String> l4 = Arrays.asList("a","a","c","Z", "c");
		Set<String> x= l4.stream().filter(i-> Collections.frequency(l4, i)>1).collect(Collectors.toSet());
		
		System.out.println(x);

	}

}
