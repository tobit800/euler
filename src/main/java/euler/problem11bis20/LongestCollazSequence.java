package euler.problem11bis20;

import static java.text.MessageFormat.format;

import java.util.Set;
import java.util.SortedMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

// Problem 14
public class LongestCollazSequence
{

	private final SortedMap<Long, Long> collatzMap = new TreeMap<>();
	private long index = 1;

	public static void main(String[] args)
	{
		final LongestCollazSequence calc = new LongestCollazSequence();
		final TimerTask monitor = new TimerTask()
		{

			@Override
			public void run()
			{
				System.out.println(format("Index={0,number,#}. Map enthält {1} Elemente",
					calc.index, calc.collatzMap.size()));
			}
		};
		final Timer timer = new Timer();
		timer.schedule(monitor, 100, 1000);
//		calc.colatz(113382);
//		calc.colatz(113383);
//		calc.colatz(113384);
//		calc.colatz(113385);
		while (calc.index <= 1000000)
		{
			calc.colatz(calc.index++);
		}

		final Set<Long> keySet = calc.collatzMap.keySet();
		long maxValue = 0;
		long maxKey = 0;
		for (final Long key : keySet)
		{
			if (calc.collatzMap.get(key)
							   .intValue() > maxValue)
			{
				maxKey = key;
				maxValue = calc.collatzMap.get(key);
			}
		}
		timer.cancel();
		System.out.println(format("Bei der Startzahl {0} hat die Collatz-Folge die Länge {1}",
			maxKey, maxValue));
	}

	private long colatz(long start)
	{
		long steps = 1;
		long n = start;
		while (n != 1)
		{
			if (collatzMap.containsKey(n))
			{
				steps += collatzMap.get(n);
				break;
			}
			else
			{
				n = next(n);
				steps++;
			}
		}
		collatzMap.put(start, steps);
		return steps;
	}

	private long next(long n)
	{
		return n % 2 == 0 ? n / 2 : 3 * n + 1;
	}

}
