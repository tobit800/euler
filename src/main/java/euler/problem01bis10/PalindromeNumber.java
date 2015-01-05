package euler.problem01bis10;

import static java.text.MessageFormat.format;

public class PalindromeNumber
{
	public static void main(String[] args)
	{
		int max = 1;
		for (int i = 999; i > 1; i--)
		{
			for (int j = 999; j > 1; j--)
			{
				final int x = i * j;
				if (isPalindrom(x) && x > max)
				{
					max = x;
					System.out.println(format("{0}x{1}={2,number,#}", i, j, max));
				}
			}
		}
	}

	private static void assertThat(boolean value)
	{
		if (!value)
		{
			throw new RuntimeException("Assertion");
		}
	}

	private static boolean isPalindrom(int x)
	{
		final String text = String.valueOf(x);
		final char[] chars = text.toCharArray();
		final int length = text.length();
		if (length == 6)
		{
			return chars[0] == chars[5] && chars[1] == chars[4] && chars[2] == chars[3];
		}
		if (length == 4)
		{
			return chars[0] == chars[3] && chars[1] == chars[2];
		}
		return false;
	}
}
