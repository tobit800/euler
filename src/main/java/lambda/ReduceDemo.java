package lambda;

import java.util.Arrays;
import java.util.List;

public class ReduceDemo {

	public static void main(String[] args) {
		new ReduceDemo().demo();

	}

	private void demo() {
		final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		final int sum = numbers.stream().reduce(0, (x, y) -> x + y);

		System.out.println("Summe = " + sum);

	}
}
