package euler.problem11bis20;

import static java.lang.Math.max;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.List;

// Problem 18
public class MaximumPathSumI
{
	static String demoInput = "3\n" + //
		"7 4\n" + //
		"2 4 6\n" + //
		"8 5 9 3";

	static String input18 = "75\n" + //
		"95 64\n" + //
		"17 47 82\n" + //
		"18 35 87 10\n" + //
		"20 04 82 47 65\n" + //
		"19 01 23 75 03 34\n" + //
		"88 02 77 73 07 63 67\n" + //
		"99 65 04 28 06 16 70 92\n" + //
		"41 41 26 56 83 40 80 70 33\n" + //
		"41 48 72 33 47 32 37 16 94 29\n" + //
		"53 71 44 65 25 43 91 52 97 51 14\n" + //
		"70 11 33 28 77 73 17 78 39 68 17 57\n" + //
		"91 71 52 38 17 14 91 43 58 50 27 29 48\n" + //
		"63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" + //
		"04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

	public static void main(String[] args) throws Exception
	{
		new MaximumPathSumI().calc(input18);
		final String input68 = readTextFile("p067_triangle.txt");
		new MaximumPathSumI().calc(input68);
	}

	private static String readTextFile(String textFile) throws IOException
	{
		final StringBuilder sb = new StringBuilder();
		final Path path = FileSystems.getDefault()
									 .getPath("bin/" + textFile);
		final List<String> allLines = Files.readAllLines(path);
		allLines.forEach(s -> sb.append(s)
								.append("\n"));
		return sb.toString();

	}

	private void calc(String in)
	{
		final int[][] array = asIntArray(in);
		prettyPrint(array);
		summiereVonUntenNachOben(array);
		prettyPrint(array);
		System.out.println("\n\nMaximum=" + array[0][0]);
	}

	private int[][] asIntArray(String in)
	{
		final String[] zeilen = in.split("\n");
		final int d = zeilen.length;
		final int[][] array = new int[d][d];
		for (int row = 0; row < d; row++)
		{
			final String zeile = zeilen[row];
			final String[] zahlen = zeile.split(" ");
			for (int col = 0; col <= row; col++)
			{
				array[row][col] = Integer.valueOf(zahlen[col]);
			}
		}
		return array;
	}

	private void prettyPrint(final int[][] array)
	{
		final StringBuilder sb = new StringBuilder();
		final int d = array.length;
		for (int row = 0; row < d; row++)
		{
			for (int col = 0; col <= row; col++)
			{
				sb.append(MessageFormat.format("{0,number,00}", array[row][col]))
				  .append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private void summiereVonUntenNachOben(int[][] array)
	{
		final int d = array.length;
		for (int row = d - 2; row >= 0; row--)
		{
			for (int col = 0; col <= row; col++)
			{
				array[row][col] += max(array[row + 1][col], array[row + 1][col + 1]);
//				array[row + 1][col] = array[row + 1][col + 1] = 0;
			}
		}
	}
}
