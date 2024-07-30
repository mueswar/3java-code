package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {

	public static void main(String[] args) {
		/*
		 * when we will implement compareTo, equals
		 * 
		 */
		A a1 = new A("a", 20);
		A a2 = new A("x", 80);
		A a3 = new A("b", 30);
		A a4 = new A("y", 90);
		
		B b1 = new B("a", 20);
		B b2 = new B("x", 80);
		B b3 = new B("b", 30);
		B b4 = new B("y", 90);
		
		List<A> a = List.of(a1,a2,a3,a4);
		System.out.println(a);
		//Collections.sort(a);// unsupported exception
		List<A> c = Arrays.asList(a1,a2,a3,a4);
		//c.add(a1); //we can not modify size for list from Arrays.asList
		Collections.sort(c);
		System.out.println("Arrays.asList sort: "+c);
		List<A> b = new ArrayList<>();
		b.add(a1);b.add(a2);b.add(a3);b.add(a4);
		System.out.println(b);
		Collections.sort(b);//this collection objects should implement Comparable
		System.out.println(b);
		
		List<B> d = Arrays.asList(b1,b2,b3,b4);
		Bcomparator bcomparator = new Bcomparator();
		Collections.sort(d, bcomparator);
		System.out.println(d);
	}

}

class A implements Comparable<A>{
	A(String name, int age){
		this.name = name;
		this.age = age;
	}
	private String name;
	private int age;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	@Override
	public String toString() {
		return name;
	}
	@Override
	public int compareTo(A o) {
		return this.getAge() - o.getAge();
	}
}

class B{
	B(String name, int age){
		this.name = name;
		this.age = age;
	}
	private String name;
	private int age;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	@Override
	public String toString() {
		return name;
	}
}

class Bcomparator implements Comparator<B>{

	@Override
	public int compare(B o1, B o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}

