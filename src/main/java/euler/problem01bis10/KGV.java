package euler.problem01bis10;

public class KGV
{
	/*
	 * 1
	 * 2
	 * 3
	 * 2 2
	 * 5
	 * 2 3
	 * 7
	 * 2 2 2
	 * 3 3
	 * 2 5
	 * 11
	 * 2 2 3
	 * 13
	 * 2 7
	 * 3 5
	 * 2 2 2 2
	 * 17
	 * 2 3 3
	 * 19
	 * 2 2 5
	 */
	public static void main(String[] args)
	{
		final int kgv = new KGV().berechne();
		System.out.println("KGV=" + kgv);
	}

	private int berechne()
	{
		return 1 * 2 * 2 * 2 * 2 * 3 * 3 * 5 * 7 * 11 * 13 * 17 * 19;
	}

}
