package utils;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class FaktorenZerlegungTest
{
	private final FaktorenZerlegung sut = new FaktorenZerlegung();

	@Test
	public void summeFaktoren1() throws Exception
	{
		long summe = sut.summe(1);
		assertThat(summe).isEqualTo(1);
	}

	@Test
	public void summeFaktoren2() throws Exception
	{
		long summe = sut.summe(2);
		assertThat(summe).isEqualTo(1);
	}

	@Test
	public void summeFaktoren4() throws Exception
	{
		long summe = sut.summe(4);
		assertThat(summe).isEqualTo(3);
	}

	@Test
	public void summeFaktoren12() throws Exception
	{
		long summe = sut.summe(12);
		assertThat(summe).isEqualTo(16);
	}

	@Test
	public void primzahl() throws Exception
	{
		long[] primzahlen = { 523L, 1979, 2731, 3559, 5273 };
		for (long prim : primzahlen)
		{
			assertThat(sut.summe(prim)).isEqualTo(1);
		}
	}

	@Test
	public void produktVonPrimzahlen() throws Exception
	{
		long[] primzahlen = { 523L, 1979, 2731, 3559, 5273 };
		long summe = 1;
		for (long prim : primzahlen)
		{
			summe += prim;
		}
		long produkt = 1;
		for (long prim : primzahlen)
		{
			produkt *= prim;
		}
		assertThat(sut.summe(produkt)).isEqualTo(summe);
	}
}
