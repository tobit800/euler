package utils;

import java.util.function.LongSupplier;
import java.util.stream.LongStream;

public class GeometrischeReihe implements LongSupplier
{
	private long n = 0;

	@Override
	public long getAsLong()
	{
		n++;
		return n * (n + 1) / 2;
	}

	public LongStream asStream()
	{
		return LongStream.generate(this);
	}
}
