package collection;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest {

	public static void main(String[] args) {
		Predicate<Integer> lesserthan = i -> (i < 18);
		System.out.println(lesserthan.test(6));
		//filter takes predicate
		
		Consumer<Integer> display = a -> System.out.println(a);
		display.accept(2);
		//forEach takes consumer
		
		Consumer<Double> displayDouble = a -> System.out.println(a);
		Supplier<Double> randomValue = () -> Math.random(); 
		displayDouble.accept(randomValue.get());
		
		Predicate<Integer> greater = (i) -> i > 10;
		Predicate<Integer> lower = (i) -> i < 20;
		boolean result = greater.and(lower).test(15);
		boolean orresult = greater.or(lower).test(15);
		System.out.println(result);
		System.out.println(orresult);
	}

}
