package test.generators.perfectSquares;

import generators.ISequenceGenerator;
import generators.perfectSquares.PerfectSquaresSequenceGenerator;
import test.AbstractTest;
import test.generators.AbstractSequenceGeneratorTester;

public class PerfectSquaresTest
extends AbstractTest
{
	@Override
	public void doTest()
	{
		ISequenceGenerator generator = new PerfectSquaresSequenceGenerator();
		AbstractSequenceGeneratorTester tester = 
				new PerfectSquaresSequenceGeneratorTester(generator);
		
		tester.test();
	}

	public static void main(String[] args)
	{
		new PerfectSquaresTest().doTest();
	}
}