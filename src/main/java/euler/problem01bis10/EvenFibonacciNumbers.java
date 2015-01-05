package euler.problem01bis10;

import java.util.stream.LongStream;
import java.util.stream.LongStream.Builder;

/**
 * Zweites Problem aus dem Project Euler.
 *
 * @see https://projecteuler.net/problem=2
 */
public class EvenFibonacciNumbers
{
	private static class Fibonacci
	{
		long a = 1;
		long b = 1;

		long nächsteZahl()
		{
			b = a + b;
			a = b - a;
			return b;
		}

		LongStream reiheBis(long max)
		{
			final Builder builder = LongStream.builder();
			while (nächsteZahl() < max)
			{
				builder.accept(b);
			}
			return builder.build();
		}
	}

	public static void main(String[] args)
	{
		final Fibonacci fibonacci = new Fibonacci();
		final long summe = fibonacci.reiheBis(4000000L)
									.filter(it -> it % 2 == 0)
									.reduce(0, Long::sum);

		System.out.println("Summe = " + summe);
	}
}
