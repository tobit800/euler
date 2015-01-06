package euler.problem11bis20;

import java.math.BigInteger;

// Problem 16
public class PowerDigitSum
{

	private final static BigInteger two = BigInteger.valueOf(2L);

	public static void main(String[] args)
	{
		BigInteger power = two;
		for (int i = 1; i < 1000; i++)
		{
			power = power.multiply(two);
		}
		System.out.println("Power=" + power);

		final int summe = power.toString()
							   .chars()
							   .parallel()
							   .map(c -> c - 48)
							   .sum();

		System.out.println("Summe=" + summe);
	}
}
