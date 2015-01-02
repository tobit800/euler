package lambda;

public interface Riddle {
	int solve();

	int reduce();

	default void analyse() {
		try {
			Thread.sleep(1000);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
	}
}
