package euler.problem11bis20;

import java.util.stream.LongStream;

public class HighlyDivisibleTriangualrNumber
{
	public static void main(String[] args)
	{
		final HighlyDivisibleTriangualrNumber calc = new HighlyDivisibleTriangualrNumber();

		final LongStream geometrischeReihe = new GeometrischeReihe().asStream();
		geometrischeReihe.map(zahl -> calc.anzahlFaktoren(zahl))
						 .forEach(System.out::println);

	}

	public int anzahlFaktoren(long zahl)
	{
		final StringBuilder sb = new StringBuilder();
		sb.append(zahl)
		  .append(": ");
		int anzahlFaktoren = 0;
		for (int faktor = 1; faktor <= zahl; faktor++)
		{
			if (zahl % faktor == 0)
			{
				sb.append(faktor)
				  .append(", ");
				anzahlFaktoren++;
			}
		}
		if (anzahlFaktoren >= 500)
		{
			System.out.println(sb.substring(0, sb.length() - 2));
			throw new RuntimeException("Abbruch");
		}
		return anzahlFaktoren;
	}
}
