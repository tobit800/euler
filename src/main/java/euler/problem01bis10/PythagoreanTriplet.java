package euler.problem01bis10;

import static java.text.MessageFormat.format;

public class PythagoreanTriplet
{

	public static void main(String[] args)
	{
		for (int a = 1; a < 499; a++)
		{
			for (int b = a + 1; b < 499; b++)
			{
				final int c = 1000 - a - b;
				if (a * a + b * b == c * c)
				{
					System.out.println(format("a={0} b={1} c={2} Ergebnis={3,number,#}", a, b,
						c, a * b * c));
				}
			}
		}

	}

}
