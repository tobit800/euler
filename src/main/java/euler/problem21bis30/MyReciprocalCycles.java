package euler.problem21bis30;

// Problem 26
public class MyReciprocalCycles
{
	public static void main(String[] args)
	{
		for (int i = 1; i < 10; i++)
		{
			System.out.println(unitFractionAsString(i));
		}
	}

	private static String unitFractionAsString(int denominator)
	{
		final double unitFraction = 1d / denominator;
		return String.format("%.1000f", unitFraction)
					 .substring(2);
	}
}
