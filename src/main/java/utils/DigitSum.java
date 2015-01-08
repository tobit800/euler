package utils;

import java.math.BigInteger;

public class DigitSum
{
	/**
	 * Liefert die Summe der Ziffern
	 *
	 * @param input Eingabe
	 * @return Summe der Ziffern
	 */
	public static int digitSum(BigInteger input)
	{
		final int summe = input.toString()
							   .chars()
							   .parallel()
							   .map(c -> c - 48)
							   .sum();
		return summe;
	}

}
