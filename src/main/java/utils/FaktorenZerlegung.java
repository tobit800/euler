package utils;

public class FaktorenZerlegung
{
	public long summe(long number)
	{
		long summe = 1;
		for (long faktor = 2; faktor <= number - 1; faktor++)
		{
			if (number % faktor == 0)
			{
				summe += faktor;
			}
		}
		return summe;
	}
}
