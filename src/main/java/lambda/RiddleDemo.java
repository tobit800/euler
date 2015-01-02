package lambda;

import java.util.ArrayList;
import java.util.List;

public class RiddleDemo {

	public static void main(String[] args) {

		final List<Riddle> riddles = new ArrayList<>();
		riddles.add(new MathRiddle(1, 10));
		riddles.add(new MathRiddle(2, 20));
		riddles.add(new MathRiddle(3, 30));
		final long startTime = System.currentTimeMillis();
		riddles.parallelStream().forEach(Riddle::solve);

		final long stopTime = System.currentTimeMillis();
		final float delta = (float) (stopTime - startTime) / 1000;
		System.out.println("Brauchte " + delta + " Sekunden.");
	}
}
