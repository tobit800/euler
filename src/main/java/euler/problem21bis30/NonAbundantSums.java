package euler.problem21bis30;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.LongStream;

import utils.ProgressUtil;

// Problem 23
public class NonAbundantSums
{
	private static final long MAX = 28123L;
	private static long[] abundant;
	private static Set<Long> abundantSet;

	public static void main(String[] args)
	{
		ProgressUtil.start();
		System.out.println("Berechne Abundant-Zahlen...");
		abundant = new AbundantNumberGenerator().asStream(MAX)
												.toArray();

		abundantSet = new TreeSet<Long>();
		for (final long zahl : abundant)
		{
			abundantSet.add(zahl);
		}
		System.out.println("Abundant-Zahlen berechnet.");

		final long summe = LongStream.range(1, MAX)
									 .filter(z -> !istZerlegbar(z))
									 .parallel()
									 .sum();
		System.out.println("Summe = " + summe);
		ProgressUtil.stop();

	}

	private static boolean istZerlegbar(long zahl)
	{
		return Arrays.stream(abundant)
					 .limit(zahl)
					 .anyMatch(z -> istSumme(zahl, z));
	}

	private static boolean istSumme(long zahl, long z)
	{
		return abundantSet.contains(zahl - z);
	}
}
