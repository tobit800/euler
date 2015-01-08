package euler.problem11bis20;

import static java.text.MessageFormat.format;

import java.time.DayOfWeek;
import java.time.LocalDate;

// Problem 19
public class CountingSundays
{

	public static void main(String[] args)
	{
		int anzahlSonntage = 0;
		LocalDate date = LocalDate.of(1901, 1, 1);
		while (date.isBefore(LocalDate.of(2000, 12, 31)))
		{
			if (date.getDayOfWeek() == DayOfWeek.SUNDAY)
			{
				anzahlSonntage++;
			}
			date = date.plusMonths(1);
		}

		System.out.println(format(
			"Es gab {0} Sonntage am ersten eines Monats im 20. Jahrhundert.", anzahlSonntage));
	}
}
