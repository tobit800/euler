package euler.problem41bis50;

import static java.math.BigInteger.ZERO;

import java.math.BigInteger;
import java.util.stream.IntStream;

// Problem 48
public class SelfPower
{
	public static void main(String[] args)
	{
		new SelfPower().calc();
	}

	private void calc()
	{
		final BigInteger power = IntStream.rangeClosed(1, 1000)
										  .mapToObj(i -> selfPower(i))
										  .reduce(ZERO, (a, b) -> a.add(b));
		System.out.println("Power=" + power);
		System.out.println("Die letzten 10 Ziffern:" + lastTenDigits(power.toString()));
	}

	private BigInteger selfPower(int number)
	{
		return BigInteger.valueOf(number)
						 .pow(number);
	}

	private String lastTenDigits(final String text)
	{
		final int length = text.length();
		return text.substring(length - 10, length);
	}
}
