package euler.problem21bis30;

import java.math.BigDecimal;
import java.util.Arrays;

public class ReciprocalCycles
{
	private int recipAmount;
	private final int precision = 10000;
	private BigDecimal testDeci;
	private BigDecimal highestDeci = new BigDecimal(0.0);
	private BigDecimal denominator = new BigDecimal(2.0);
	private static final BigDecimal NUMERATOR = new BigDecimal(1.0);
	private static final BigDecimal UPTO = new BigDecimal(1000.0);
	private static final BigDecimal COUNTER = new BigDecimal(1.0);

	public static void main(String[] args)
	{
		new ReciprocalCycles();
	}

	public ReciprocalCycles()
	{
		while (denominator.compareTo(UPTO) == -1)
		{
			testDeci = NUMERATOR.divide(denominator, precision, BigDecimal.ROUND_UP);
			recipAmount = findReciprocal(testDeci);
			if (BigDecimal.valueOf(recipAmount)
						  .compareTo(highestDeci) >= 0)
			{
				highestDeci = denominator;
			}
			denominator = denominator.add(COUNTER);
		}
		System.out.println(highestDeci);
	}

	private int findReciprocal(BigDecimal test)
	{
		char[] characterArray;
		char[] testArray1;
		char[] testArray2;
		char[] testArray3;
		int counter = 1;
		final int endNumber = 0;
		final int simpleIt = 0;
		characterArray = test.toString()
							 .toCharArray();
		if (characterArray[2] == characterArray[3] && characterArray[7] == characterArray[26]
			&& characterArray[2] == characterArray[1231])
		{
			return 1;
		}
		while (counter < precision / 2)
		{
			for (int i = counter; i < precision / 2 - counter - 5; i++)
			{
				testArray1 = Arrays.copyOfRange(characterArray, counter + 2, counter + 2 + i);
				testArray2 =
					Arrays.copyOfRange(characterArray, counter + 3 + i, counter + 3 + i + i);
				testArray3 =
					Arrays.copyOfRange(characterArray, counter + 4 + i + i, counter + 4 + i + i
						+ i);
				if (Arrays.equals(testArray1, testArray2)
					&& Arrays.equals(testArray1, testArray3))
				{
					return i + 1;
				}
			}
			counter++;
		}
		return 0;
	}
}