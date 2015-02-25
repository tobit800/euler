package euler.problem21bis30;

import static java.lang.Integer.MAX_VALUE;
import static java.text.MessageFormat.format;

import java.util.HashSet;
import java.util.Set;

public class QuadraticPrimes
{
	private final Set<Long> primzahlen = new HashSet<>();

	public static void main(String[] args)
	{
		final QuadraticPrimes problem = new QuadraticPrimes();
		problem.solve();
	}

	private void solve()
	{
		System.out.println("Die Folge von Primzahlen hat die Länge: "
			+ längeDerFolgeVonPrimzahlen(n -> n * n + n + 41));
		System.out.println("Die Folge von Primzahlen hat die Länge: "
			+ längeDerFolgeVonPrimzahlen(n -> n * n - 79 * n + 1601));
		int bestA = 1;
		int bestB = 1;
		int max = 0;
		for (int a = -999; a < 1000; a++)
		{
			for (int b = -999; b < 1000; b++)
			{
				final int x = a;
				final int y = b;
				final int länge = längeDerFolgeVonPrimzahlen(n -> n * n + x * n + y);
				if (länge > max)
				{
					max = länge;
					bestA = a;
					bestB = b;
				}
			}
			System.out.println("a=" + a);
		}
		System.out.println(format(
			"Die Formel n² + {0}n + {1} bildet eine Primzahlkette der Länge {2}.", bestA,
			bestB, max));
		System.out.println(format("{0}*{1}={2,number,#}", bestA, bestB, bestA * bestB));
	}

	private int längeDerFolgeVonPrimzahlen(Formel formula)
	{
		for (int n = 1; n < MAX_VALUE; n++)
		{
			if (!isPrime(calc(n, formula)))
			{
				return n - 1;
			}
		}
		return -1;
	}

	long calc(int n, Formel formula)
	{
		return formula.calc(n);
	}

	interface Formel
	{
		long calc(int n);
	}

	boolean isPrime(long candidate)
	{
		if (primzahlen.contains(candidate))
		{
			return true;
		}
		if (candidate < 2)
		{
//			System.out.println(candidate + "<2");
			return false;
		}
		for (long i = 2; i * i < candidate; i++)
		{
			if (candidate % i == 0)
			{
//				System.out.println(candidate + " ist nicht prim");
				return false;
			}
		}
//		System.out.println(candidate + " ist prim");
		primzahlen.add(candidate);
		return true;
	}
}
