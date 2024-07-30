package collection;

import java.util.Arrays;
import java.util.List;

public class ArrayTest {

	public static void main(String[] args) {
		/*
		 * Arrays class has methods asList, sort
		 * 
		 */
		
		List<String> l = Arrays.asList("a");
		System.out.println(l);
		//l.add("b"); //we will get Unsupported operation exception
		int a[] = {2,1,4,3,6,5,8,7};
		Arrays.sort(a);
		System.out.println(a);
		System.out.println(a[0]+""+a[1]+""+a[2]+""+a[3]+""+a[4]);
		
		System.out.println(Arrays.asList(a));
		Arrays.asList(a).stream().forEach(e-> System.out.println("111"));
		for (int i=0; i<=a.length; i++) {
			System.out.print(i);
		}
		

	}

}
