package euler.problem11bis20;

import java.math.BigInteger;
import java.util.stream.IntStream;

import utils.DigitSum;

// Problem 16
public class PowerDigitSum
{

	private final static BigInteger two = BigInteger.valueOf(2L);
	private BigInteger power = two;

	public static void main(String[] args)
	{
		new PowerDigitSum().calc();
	}

	private void calc()
	{
		IntStream.range(1, 1000)
				 .forEach(value -> power = power.multiply(two));
		System.out.println("Power=" + power);

		final int summe = DigitSum.digitSum(power);
		System.out.println("Summe=" + summe);
	}

}
