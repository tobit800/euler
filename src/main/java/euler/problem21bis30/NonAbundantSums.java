package euler.problem21bis30;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.LongStream;

// Problem 23
public class NonAbundantSums
{
	private long[] abundant;
	private Set<Long> abundantSet;

	private long calculate(long max)
	{
		abundant = new AbundantNumberGenerator().getAsArray(max);
		abundantSet = new TreeSet<Long>();
		for (final long number : abundant)
		{
			abundantSet.add(number);
		}
		long start = System.currentTimeMillis();
		long sum = LongStream.range(1, max)
							 .filter(z -> !isSum(z))
							 .sum();

		long delta = System.currentTimeMillis() - start;
		System.out.println("Used " + delta + " ms.");
		return sum;
	}

	private boolean isSum(long zahl)
	{
		return Arrays.stream(abundant)
					 .limit(zahl)
					 .parallel()
					 .anyMatch(z -> hasSummand(zahl, z));
	}

	private boolean hasSummand(long sum, long summand)
	{
		return abundantSet.contains(sum - summand);
	}

	public static void main(String[] args)
	{
		System.out.println("Summe = " + new NonAbundantSums().calculate(28123L));
	}
}
