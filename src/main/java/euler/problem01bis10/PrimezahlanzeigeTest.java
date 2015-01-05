package euler.problem01bis10;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class PrimezahlanzeigeTest
{
	private final Primezahlanzeige sut = new Primezahlanzeige();

	@Test
	public void test6() throws Exception
	{
		final long prime = sut.finde(6);
		assertThat(prime).isEqualTo(13L);
	}
}
