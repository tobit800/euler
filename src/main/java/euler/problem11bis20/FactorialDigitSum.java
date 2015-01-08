package euler.problem11bis20;

import java.math.BigInteger;

import utils.DigitSum;

// Problem 20
public class FactorialDigitSum
{

	public static void main(String[] args)
	{
		final int n = 100;
		BigInteger fakultät = BigInteger.ONE;

		for (int i = 1; i < n; i++)
		{
			fakultät = fakultät.multiply(BigInteger.valueOf(i));
		}
		System.out.println("Fakultät=" + fakultät);

		final int summe = DigitSum.digitSum(fakultät);
		System.out.println("Quersumme=" + summe);
	}

}
