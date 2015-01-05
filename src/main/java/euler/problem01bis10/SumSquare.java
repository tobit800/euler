package euler.problem01bis10;

import static java.lang.System.out;

import java.util.Arrays;

public class SumSquare
{

	public static void main(String[] args)
	{
		final Integer[] zahlen = new Integer[100];
		for (int i = 0; i < zahlen.length; i++)
		{
			zahlen[i] = i + 1;
		}

		final int sumSquares = Arrays.stream(zahlen)
									 .map(i -> i * i)
									 .reduce(0, Integer::sum)
									 .intValue();

		out.println("Summe Square=" + sumSquares);

		final int summe = Arrays.stream(zahlen)
								.reduce(0, Integer::sum)
								.intValue();

		final int squareSums = summe * summe;
		out.println("Square Summe=" + squareSums);

		final int diff = squareSums - sumSquares;
		out.println("Diff=" + diff);
	}
}
