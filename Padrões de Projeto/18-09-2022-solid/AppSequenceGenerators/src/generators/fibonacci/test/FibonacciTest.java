package generators.fibonacci.test;

import generators.ISequenceGenerator;
import generators.fibonacci.FibonacciSequenceGenerator;
import generators.test.AbstractSequenceGeneratorTester;

public class FibonacciTest
{
	
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
