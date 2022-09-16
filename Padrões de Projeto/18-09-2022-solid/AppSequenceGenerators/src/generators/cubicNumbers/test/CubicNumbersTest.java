package generators.cubicNumbers.test;

import generators.ISequenceGenerator;
import generators.cubicNumbers.CubicNumbersSequenceGenerator;
import generators.test.AbstractSequenceGeneratorTester;

public class CubicNumbersTest
{
	
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