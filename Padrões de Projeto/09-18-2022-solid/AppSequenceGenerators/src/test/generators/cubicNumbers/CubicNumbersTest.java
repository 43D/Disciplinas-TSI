package test.generators.cubicNumbers;

import generators.ISequenceGenerator;
import generators.cubicNumbers.CubicNumbersSequenceGenerator;
import test.AbstractTest;
import test.generators.AbstractSequenceGeneratorTester;

public class CubicNumbersTest
extends AbstractTest
{
	@Override
	public void doTest()
	{
		ISequenceGenerator generator = new CubicNumbersSequenceGenerator();
		AbstractSequenceGeneratorTester tester = 
				new CubicNumbersSequenceGeneratorTester(generator);
		
		tester.test();
	}

	public static void main(String[] args)
	{
		new CubicNumbersTest().doTest();
	}
}