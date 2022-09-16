package generators.perfectSquares;

import generators.ISequenceGenerator;
import generators.test.AbstractSequenceGeneratorTester;

public class PerfectSquaresTest
{
	
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