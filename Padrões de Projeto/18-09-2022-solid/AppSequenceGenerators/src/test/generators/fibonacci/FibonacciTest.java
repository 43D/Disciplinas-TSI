package test.generators.fibonacci;

import generators.ISequenceGenerator;
import generators.fibonacci.FibonacciSequenceGenerator;
import test.AbstractTest;
import test.generators.AbstractSequenceGeneratorTester;

public class FibonacciTest
extends AbstractTest
{
	@Override
	public void doTest()
	{
		ISequenceGenerator generator = new FibonacciSequenceGenerator();
		AbstractSequenceGeneratorTester tester = 
				new FibonacciSequenceGeneratorTester(generator);
		
		tester.test();
	}

	public static void main(String[] args)
	{
		new FibonacciTest().doTest();
	}
}
