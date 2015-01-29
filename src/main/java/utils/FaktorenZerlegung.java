package utils;

public class FaktorenZerlegung
{
	public long summe(long number)
	{
		long summe = 1;
		for (long faktor = 2; faktor <= number / 2; faktor++)
		{
			if (number % faktor == 0)
			{
				summe += faktor;
			}
		}
		return summe;
	}

	public long summeAusBeispiel(int n)
	{
		int prod = 1;
		for (int k = 2; k * k <= n; ++k)
		{
			int p = 1;
			while (n % k == 0)
			{
				p = p * k + 1;
				n /= k;
			}
			prod *= p;
		}
		if (n > 1)
		{
			prod *= 1 + n;
		}
		return prod;
	}

}
