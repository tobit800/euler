package lambda;

/** @author Maurice Naftalin, from Mastering Lambdas */
public class Hello {

	String text = "Test-";

	Runnable r1 = () -> {
		text += "r1";
		System.out.println(this);
	};

	Runnable r2 = () -> {
		text += "r2";
		System.out.println(toString());
	};

	@Override
	public String toString() {
		return "Text=" + text;
	}

	public static void main(String... args) {
		final Hello hello = new Hello();
		hello.r1.run();
		hello.r2.run();
	}

}