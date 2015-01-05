package euler.problem01bis10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;
import java.util.stream.LongStream.Builder;

public class PrimzahlenGenerator implements LongSupplier
{
	private final List<Long> primzahlen;

	public PrimzahlenGenerator()
	{
		primzahlen = new ArrayList<Long>();
		primzahlen.add(2L);
	}

	public LongStream asStream()
	{
		return LongStream.generate(this);
	}

	public LongStream bis(long schranke)
	{
		final Builder builder = LongStream.builder();

		while (true)
		{
			final long nächste = ergänzeNächstePrimzahl();
			if (nächste < schranke)
			{
				builder.accept(nächste);
			}
			else
			{
				break;
			}
		}

		return builder.build();
	}

	/**
	 * Alle Primzahlen bis zur Nummer
	 *
	 * @param nummer Nummer
	 * @return 2,3,5,7 etc
	 */
	public LongStream nummer(long nummer)
	{
		final Builder builder = LongStream.builder();
		primzahlen.clear();
		primzahlen.add(2L);
		builder.accept(2L);

		while (primzahlen.size() < nummer)
		{
			builder.accept(ergänzeNächstePrimzahl());
		}

		return builder.build();
	}

	private long ergänzeNächstePrimzahl()
	{
		final long nächste = nächstePrimzahl();
		primzahlen.add(nächste);
		return nächste;
	}

	private long nächstePrimzahl()
	{
		long kandidat = größtePrimzahl() + 1;
		while (!isPrime(kandidat))
		{
			kandidat++;
		}
		return kandidat;
	}

	@Override
	public long getAsLong()
	{
		return ergänzeNächstePrimzahl();
	}

	private long größtePrimzahl()
	{
		return primzahlen.get(primzahlen.size() - 1);
	}

	private boolean isPrime(long candidate)
	{
		for (final Long prim : primzahlen)
		{
			if (candidate % prim == 0)
			{
				return false;
			}
		}
		return true;
	}

}
