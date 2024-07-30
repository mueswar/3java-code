package string;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringTest {

	public static void main(String[] args) {
		String a = new String("123456789");
		String d = new String("123456789123456789");
		System.out.println(a.charAt(1));
		IntStream b = a.chars();
		b.forEach(z->System.out.print(z));
		System.out.println("");
		char[] e= a.toCharArray();
		System.out.println(e.length);
		System.out.println("a length  "+a.length());
		String c = a.concat("abc");
		System.out.println(c);
		System.out.println("a contains abc?, expected FALSE : "+a.contains("abc"));
		System.out.println("a contains 123?, expected TRUE : "+a.contains("123"));
		System.out.println("ends with 9 : "+a.endsWith("9"));
		System.out.println("starts with 1 : "+a.startsWith("1"));
		System.out.println("is blank, expected TRUE : "+"".isBlank());
		System.out.println("is blank, expected TRUE : "+" ".isBlank());
		System.out.println("is isEmpty, expected TRUE : "+"".isEmpty());
		System.out.println("is isEmpty, expected FALSE: "+" ".isEmpty());
		System.out.println("index of 456   "+a.indexOf("456"));
		System.out.println("index of 456   "+"123456789123456789".indexOf("456", 5));
		System.out.println("lastIndexOf 456   "+a.lastIndexOf("456"));
		System.out.println("matches 123   "+a.matches("123"));
		System.out.println("replace123   "+d.replace("123", "abc"));
		System.out.println("replace all 123   "+d.replaceAll("123", "xyz"));//regex
		System.out.println("replace first 123   "+d.replaceFirst("123", "pqr"));
		System.out.println("split   "+"as df hj".split(" "));
		System.out.println("substring 2   "+a.substring(2));
		System.out.println("substring 2 5   "+a.substring(2, 5));
		String f = String.valueOf('c');
		String g = String.valueOf(5);
		String h = String.valueOf(5.5);
		System.out.println( f+ "   "+g+"  "+h);
		System.out.println("abc       ".strip());//java11strp,stripLeading,stripTriling
		System.out.println("abc       ".trim());
		String[] i = {"abc","XYZ"};
		System.out.println(String.join("_",i));
		System.out.println(String.join("_",Arrays.asList("abc","XYZ")));
		String name = "xyz";
		int age = 30;
		System.out.println(String.format("name %s age %d",name,age));

	}

}
