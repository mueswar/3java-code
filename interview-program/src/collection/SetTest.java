package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set<String> s = Set.of("a","b");
		System.out.println(s);//no order guarantee
		//s.add("c"); //we will get Unsupported operation exception
		//s.clear(); //we will get Unsupported operation exception
		Set<String> s1 = new HashSet<>();
		s1.add("z"); s1.add("y");s1.add("x");s1.add("x");
		System.out.println(s1);// no insertion order
		s1.remove("x");
		System.out.print("rmove(x) called on S1: "+s1);
		System.out.println("");
		s1.clear();
		System.out.println("clear called on S1: "+ s1);
		Set<String> s2 = new HashSet<>();
		s2.add("r"); s2.add("q");s2.add("p");s2.add("p");
		System.out.println("__________iterate with iterate_______________");
		Iterator<String> iterator = s2.iterator(); 
		while(iterator.hasNext()) {
			String temp = iterator.next();			
			System.out.println(temp);
			//s2.remove(temp); //ConcurrentModificationException
		}
		System.out.println("__________iterate with java 7 _______________");
		for(String temp : s2) {
			System.out.println(temp);
			//s2.remove(temp);  //ConcurrentModificationException
		}
		System.out.println("__________iterate with forEach_______________");
		s2.forEach(System.out::print);
	}

}
