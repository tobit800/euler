package euler.problem21bis30;

import static java.math.BigInteger.ONE;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.stream.Stream;

public class Fibonacci
{

	private static final BigInteger MAX = BigInteger.valueOf(12586269025L);

	public static void main(String[] args)
	{
		final BigInteger first = fibonacciStream().filter(b -> b.toString()
																.length() >= 1000)
												  .findFirst()
												  .get();

		System.out.println("First = " + first);
		int counter = 0;
		BigInteger next = null;
		final Iterator<BigInteger> iterator = fibonacciStream().iterator();
		while (iterator.hasNext())
		{
			next = iterator.next();
			counter++;
			if (next.equals(first))
			{
				System.out.println("Counter = " + counter);
				break;
			}
		}
	}

	private static Stream<BigInteger> fibonacciStream()
	{
		return Stream.iterate(new BigInteger[] { ONE, ONE },
			f -> new BigInteger[] { f[1], f[0].add(f[1]) })
					 .map(f -> f[0]);
	}

}
