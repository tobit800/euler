package lambda;

public class Interruptions {
	public static void saveForLater(InterruptibleAction action) {
		saveForLater(action::run);
	}

	public static <E> E saveForLater(InterruptibleTask<E> task) {
		boolean interrupted = Thread.interrupted(); // clears flag
		try {
			while (true) {
				try {
					return task.run();
				} catch (final InterruptedException e) {
					// flag would be cleared at this point too
					interrupted = true;
				}
			}
		} finally {
			if (interrupted) {
				Thread.currentThread().interrupt();
			}
		}
	}

	@FunctionalInterface
	public interface InterruptibleAction {
		void run() throws InterruptedException;
	}

	@FunctionalInterface
	public interface InterruptibleTask<E> {
		E run() throws InterruptedException;
	}
}