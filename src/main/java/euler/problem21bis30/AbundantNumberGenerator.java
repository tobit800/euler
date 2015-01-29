package euler.problem21bis30;

import java.util.function.LongSupplier;
import java.util.stream.LongStream;

import utils.FaktorenZerlegung;

// Zum Problem 23
public class AbundantNumberGenerator implements LongSupplier
{
	private final FaktorenZerlegung faktoren = new FaktorenZerlegung();
	private long counter = 1;

	public LongStream asStream(long max)
	{
		return LongStream.generate(this)
						 .limit(max);
	}

	public long[] getAsArray(long max)
	{
		return asStream(max).toArray();
	}

	@Override
	public long getAsLong()
	{
		while (true)
		{
			counter++;
			if (isAbundant(counter))
			{
				return counter;
			}
		}
	}

	private boolean isAbundant(long number)
	{
		return number < faktoren.summe((int) number);
	}

}
