package generators.prime.atkin.test;

import generators.ISequenceGenerator;
import generators.prime.atkin.AtkinSievePrimeSequenceGenerator;
import generators.prime.test.PrimeSequenceGeneratorTester;
import generators.test.AbstractSequenceGeneratorTester;

public class AtkinSievePrimeSequenceGeneratorTest 
{
	//--------------------------------------------------------------
	public void doTest()
	{
		ISequenceGenerator generator = new AtkinSievePrimeSequenceGenerator();
		AbstractSequenceGeneratorTester tester = new PrimeSequenceGeneratorTester(generator);
		
		tester.test();
	}
	
	//--------------------------------------------------------------
	public static void main(String[] args)
	{
		new AtkinSievePrimeSequenceGeneratorTest().doTest();
	}
}
