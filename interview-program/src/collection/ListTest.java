package collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		/*
		 * List has add, toArray
		 */
		List<String> list = new ArrayList<String>();
	      list.add("This "); list.add("is "); 
	      list.add("a "); list.add("good "); list.add("program.");
	      String a[] = list.toArray(new String[0]);// just to give string Array ,else gives Object array
	      System.out.println(a.length);
	      System.out.println(list.stream().count());

	}

}
