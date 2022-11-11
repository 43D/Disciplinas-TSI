package test.generators.prime.atkin;

import generators.ISequenceGenerator;
import generators.prime.atkin.AtkinSievePrimeSequenceGenerator;
import test.AbstractTest;
import test.generators.AbstractSequenceGeneratorTester;
import test.generators.prime.PrimeSequenceGeneratorTester;

public class AtkinSievePrimeSequenceGeneratorTest 
extends AbstractTest
{
	//--------------------------------------------------------------
	@Override
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
