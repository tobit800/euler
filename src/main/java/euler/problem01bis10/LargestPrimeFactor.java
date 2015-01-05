package euler.problem01bis10;

import static java.text.MessageFormat.format;

import java.util.ArrayList;
import java.util.List;

public class LargestPrimeFactor
{
	final long ausgangswert;
	final List<Long> faktoren = new ArrayList<Long>();

	public LargestPrimeFactor(long ausgangswert)
	{
		super();
		this.ausgangswert = ausgangswert;
	}

	@Override
	public String toString()
	{
		return format("Die Primzahlen von {0,number,#} sind {1}", ausgangswert, faktoren);
	}

	long groesster()
	{
		return faktoren.stream()
					   .parallel()
					   .reduce(Long::max)
					   .get();
	}

	void zerlege()
	{
		faktoren.clear();
		long wert = ausgangswert;

		long primzahl = 2;
		while (primzahl <= wert)
		{
			if (wert % primzahl == 0)
			{
				faktoren.add(primzahl);
				wert /= primzahl;
			}
			else
			{
				primzahl++;
			}
		}
	}

	public static void main(String[] args)
	{
		final LargestPrimeFactor largestPrimeFactor = new LargestPrimeFactor(600851475143L);
		largestPrimeFactor.zerlege();
		System.out.println(largestPrimeFactor);
		System.out.println("Größter Primfaktor ist " + largestPrimeFactor.groesster());
	}
}
