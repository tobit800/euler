package lambda;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class LambdaDemo {

	public static void main(String[] args) {
		final LambdaDemo instance = new LambdaDemo();
		instance.demo();

	}

	void demo() {
		final List<Point> pointList = new ArrayList<>();
		pointList.add(new Point(0, 0));

		// pointList.forEach(new Consumer<Point>() {
		// public void accept(Point p) {
		// p.translate(1, 1);
		// }
		// });

		pointList.forEach(p -> p.translate(1, 2));
		print(pointList);
	}

	private void print(final List<Point> pointList) {
		pointList.forEach(p -> System.out.println(p));
	}
}
