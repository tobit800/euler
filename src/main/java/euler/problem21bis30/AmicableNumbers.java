package euler.problem21bis30;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Problem 21
public class AmicableNumbers
{
	private Map<Long, Long> map;

	public static void main(String[] args)
	{
		System.out.println("start...");
		final long startTime = System.currentTimeMillis();

		final AmicableNumbers calc = new AmicableNumbers();
		calc.erstelleMap(10000);
		calc.map.keySet()
				.stream()
				.filter(key -> calc.isAmicable(key))
				.forEach(System.out::println);

		final long summe = calc.summeiereAmicableZahlen();
		System.out.println("Summe=" + summe);

		final long millis = System.currentTimeMillis() - startTime;
		System.out.println("Millisekunden=" + millis);
	}

	private void erstelleMap(long max)
	{
		map = new TreeMap<>();

		for (long i = 0; i < max; i++)
		{
			map.put(i, divisors(i).stream()
								  .reduce(Long::sum)
								  .get());
		}

	}

	private Set<Long> divisors(long start)
	{
		final Set<Long> alleTeiler = new HashSet<Long>();
		alleTeiler.add(1L);
		long divisor = 2;
		while (divisor < start)
		{
			if (start % divisor == 0)
			{
				alleTeiler.add(divisor);
			}
			divisor++;
		}

		return alleTeiler;
	}

	private long summeiereAmicableZahlen()
	{
		return map.keySet()
				  .stream()
				  .filter(key -> isAmicable(key))
				  .reduce(Long::sum)
				  .get();

	}

	public boolean isAmicable(Long key)
	{
		final Long key2 = map.get(key);
		return key2 != null && !key2.equals(key) && map.containsKey(key2) && map.get(key2)
																				.equals(key);
	}

}
//map.put(220L, 284L);
//map.put(284L, 220L);
