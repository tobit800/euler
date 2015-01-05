package euler.problem01bis10;

import static java.text.MessageFormat.format;

import java.util.ArrayList;
import java.util.List;

public class Primezahlanzeige
{
	List<Long> primzahlen = new ArrayList<Long>();

	public static void main(String[] args)
	{
		final Primezahlanzeige prime = new Primezahlanzeige();
		final int nummer = 10001;
		final long zahl = prime.finde(nummer);
		System.out.println(format("Die {0,number,#}. Primzahl ist {1,number,#}", nummer, zahl));
	}

	long finde(int nummer)
	{
		while (primzahlen.size() <= nummer - 1)
		{
			ergänzeNächstePrimzahl();
		}
		return primzahlen.get(nummer - 1);
	}

	private void ergänzeNächstePrimzahl()
	{
		long kandidat = größtePrimzahl() + 1;
		while (!isPrime(kandidat))
		{
			kandidat++;
		}
		primzahlen.add(kandidat);
		if (kandidat >= 9590)
		{
			System.out.println(kandidat);
		}
	}

	private long größtePrimzahl()
	{
		if (primzahlen.isEmpty())
		{
			primzahlen.add(2L);
		}
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
