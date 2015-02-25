package euler.problem01bis10;

import org.junit.Before;
import org.junit.Test;

public class PrimzahlenGeneratorTest
{
	private PrimzahlenGenerator sut;

	@Before
	public void setUp()
	{
		sut = new PrimzahlenGenerator();
	}

	@Test
	public void primNummer() throws Exception
	{
		sut.nummer(3)
		   .forEach(System.out::println);
	}

	@Test
	public void primBis() throws Exception
	{
		sut.bis(1000)
		   .forEach(System.out::println);
	}

	@Test
	public void generate10() throws Exception
	{
		sut.asStream()
		   .limit(10)
		   .forEach(System.out::println);
	}
}
