package utils;

import java.math.BigInteger;

public class DigitSum
{
	/**
	 * Liefert die Quersumme, also die Summe über alle Ziffern.
	 *
	 * @param input Eingabe
	 * @return Summe der Ziffern
	 */
	public static int digitSum(BigInteger input)
	{
		return input.toString()
					.chars()
					.parallel()
					.map(c -> c - 48)
					.sum();
	}

}
