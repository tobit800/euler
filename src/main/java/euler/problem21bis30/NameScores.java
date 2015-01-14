package euler.problem21bis30;

import static java.text.MessageFormat.format;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

// Problem 22
public class NameScores
{
	static String inputText = "p022_names.txt";

	static class Name implements Comparable<Name>
	{
		String s;
		long alphaValue;

		public Name(String s)
		{
			this.s = s;
			alphaValue = alpha(s);
		}

		private int alpha(String s)
		{
			int sum = 0;
			for (final char c : s.toCharArray())
			{
				sum += c - 64;
			}
//			System.out.println("summe=" + sum);
			return sum;
		}

		@Override
		public String toString()
		{
			return format("{0}:{1,number,#}", s, alphaValue);
		}

		@Override
		public int compareTo(Name other)
		{
			return s.compareTo(other.s);
		}
	}

	static class PositionName implements Comparable<PositionName>
	{
		Name name;
		long pos;

		public PositionName(Name name, long pos)
		{
			this.name = name;
			this.pos = pos;
		}

		@Override
		public String toString()
		{
			return format("{0}:{1,number,#}:{2,number,#}", name, pos, score());
		}

		@Override
		public int compareTo(PositionName other)
		{
			return Long.compare(pos, other.pos);
		}

		public long score()
		{
			return name.alphaValue * pos;
		}
	}

	public static void main(String[] args) throws Exception
	{
		final String allNamesText = readText();
		final Stream<String> nameList = readNames(allNamesText);
		final AtomicInteger position = new AtomicInteger();
		long summe = 0;
		summe = nameList.map(s -> new Name(s))
						.sorted()
						.map(n -> new PositionName(n, position.incrementAndGet()))
//				.forEach(System.out::println);
						.map(pn -> pn.score())
						.reduce(Long::sum)
						.get();
		System.out.println("Summe=" + summe);
	}

	private static Stream<String> readNames(String allNamesText)
	{
		return Arrays.stream(allNamesText.split(","))
					 .map(s -> s.substring(1, s.length() - 1))
//					 .filter(s -> s.startsWith("COLIN"))
					 .sorted();
	}

	private static String readText() throws IOException
	{
		final Path path = FileSystems.getDefault()
									 .getPath("bin/" + inputText);
		final List<String> allLines = Files.readAllLines(path);
		return allLines.get(0);
	}

}
