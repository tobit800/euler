package lambda;

import static java.text.MessageFormat.format;

public class MathRiddle implements Riddle {

	private final int a;
	private final int b;

	public MathRiddle(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int solve() {
		analyse();
		final int c = a + b;
		System.out.println(format("{0} + {1} = {2}", a, b, c));
		return c;
	}

	@Override
	public int reduce() {
		return a + b;
	}

}
