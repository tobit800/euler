package euler.problem21bis30;

public class NumberSpiralDiagnoalSum
{

	public static void main(String[] args)
	{
		new NumberSpiralDiagnoalSum().solve(1001);
	}

	private void solve(int dim)
	{
		final int max = (dim + 1) / 2;
		int summe = 1;
		int zähler = 1;
		for (int ring = 1; ring < max; ring++)
		{
			for (int i = 0; i < 4; i++)
			{
				zähler += ring * 2;
				summe += zähler;
			}
		}
		System.out.println("Summe = " + summe);
	}
}
