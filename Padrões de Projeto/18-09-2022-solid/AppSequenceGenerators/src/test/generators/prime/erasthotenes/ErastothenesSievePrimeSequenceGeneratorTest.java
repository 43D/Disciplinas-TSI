package test.generators.prime.erasthotenes;

import generators.ISequenceGenerator;
import generators.prime.erastothenes.ErastosthenesSievePrimeSequenceGenerator;
import test.AbstractTest;
import test.generators.AbstractSequenceGeneratorTester;
import test.generators.prime.PrimeSequenceGeneratorTester;

public class ErastothenesSievePrimeSequenceGeneratorTest 
extends AbstractTest
{
	//--------------------------------------------------------------
	@Override
	public void doTest()
	{
		ISequenceGenerator generator = new ErastosthenesSievePrimeSequenceGenerator();
		AbstractSequenceGeneratorTester tester = new PrimeSequenceGeneratorTester(generator);
		
		tester.test();
	}
	
	//--------------------------------------------------------------
	public static void main(String[] args)
	{
		new ErastothenesSievePrimeSequenceGeneratorTest ().doTest();
	}
}
