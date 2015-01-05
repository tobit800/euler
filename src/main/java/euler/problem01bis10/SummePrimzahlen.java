package euler.problem01bis10;

public class SummePrimzahlen
{

	public static void main(String[] args)
	{
		final long summe = new PrimzahlenGenerator().bis(2000000)
													.reduce(0, Long::sum);
		System.out.println("Summe=" + summe);

	}

}
