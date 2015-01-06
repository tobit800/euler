package euler.problem11bis20;

import static java.text.MessageFormat.format;

import java.util.stream.IntStream;

// Problem 17
public class NumberLetterCounts
{

	public static void main(String[] args)
	{
		final NumberLetterCounts calc = new NumberLetterCounts();
		for (int i = 1; i <= 1000; i++)
		{
			System.out.println(i + ": " + calc.toEnglish(i));
		}
		final long numberOfLetters = calc.countAllLetters(1000);
		System.out.println("Anzahl der Buchstaben=" + numberOfLetters);
	}

	private int countAllLetters(int max)
	{
		return IntStream.rangeClosed(1, max)
						.map(number -> countEnglishLetters(number))
						.sum();
	}

	private int countEnglishLetters(int number)
	{
		final String english = toEnglish(number).replaceAll("[ -]", "");
		final int length = english.length();
		System.out.println(format("{0}: {1} ({2})", number, english, length));
		return length;
	}

	private String toEnglish(int number)
	{
		final StringBuilder sb = new StringBuilder();
		final int einer = number % 10;
		final int zehner = (number - einer) % 100 / 10;
		final int hunderter = (number - 10 * zehner - einer) / 100;
		if (number == 1000)
		{
			return "one thousand";
		}
		if (number > 100)
		{
			sb.append(hunderter(hunderter));
			number = number % 100;
		}
		if (number == 100)
		{
			return "one hundred";
		}
		if (sb.length() > 0)
		{
			sb.append(" and ");
		}
		if (number <= 20)
		{
			sb.append(zahlenBis20(number));
		}
		else
		{

			sb.append(nurZehner(zehner));
			final String zahlenBis20 = zahlenBis20(einer);
			if (zahlenBis20.length() > 0)
			{
				sb.append('-')
				  .append(zahlenBis20);
			}
		}
		return sb.toString();
	}

	private String hunderter(int hunderter)
	{
		return zahlenBis20(hunderter) + " hundred";
	}

	private String nurZehner(int zehner)
	{
		switch (zehner)
		{
			case 2:
				return "twenty";
			case 3:
				return "thirty";
			case 4:
				return "forty";
			case 5:
				return "fifty";
			case 6:
				return "sixty";
			case 7:
				return "seventy";
			case 8:
				return "eighty";
			case 9:
				return "ninety";

		}
		return null;
	}

	private String zahlenBis20(int number)
	{
		switch (number)
		{
			case 0:
				return "";
			case 1:
				return "one";
			case 2:
				return "two";
			case 3:
				return "three";
			case 4:
				return "four";
			case 5:
				return "five";
			case 6:
				return "six";
			case 7:
				return "seven";
			case 8:
				return "eight";
			case 9:
				return "nine";
			case 10:
				return "ten";
			case 11:
				return "eleven";
			case 12:
				return "twelve";
			case 13:
				return "thirteen";
			case 14:
				return "fourteen";
			case 15:
				return "fifteen";
			case 16:
				return "sixteen";
			case 17:
				return "seventeen";
			case 18:
				return "eighteen";
			case 19:
				return "nineteen";
			case 20:
				return "twenty";
			default:
				throw new IllegalArgumentException("Falsche zahl " + number);
		}
	}
}
