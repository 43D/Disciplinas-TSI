package generators.prime.erastothenes.test;

import generators.ISequenceGenerator;
import generators.prime.erastothenes.ErastosthenesSievePrimeSequenceGenerator;
import generators.prime.test.PrimeSequenceGeneratorTester;
import generators.test.AbstractSequenceGeneratorTester;

public class ErastothenesSievePrimeSequenceGeneratorTest 
{
	//--------------------------------------------------------------
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
