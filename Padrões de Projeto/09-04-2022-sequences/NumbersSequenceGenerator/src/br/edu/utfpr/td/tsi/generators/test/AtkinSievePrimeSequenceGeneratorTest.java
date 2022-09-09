package br.edu.utfpr.td.tsi.generators.test;

import br.edu.utfpr.td.tsi.generators.ISequenceGenerator;
import br.edu.utfpr.td.tsi.generators.prime.aktin.AtkinSievePrimeSequenceGenerator;
import br.edu.utfpr.td.tsi.generators.test.tester.ISequenceGeneratorTester;
import br.edu.utfpr.td.tsi.generators.test.tester.prime.PrimeSequenceGeneratorTester;

public class AtkinSievePrimeSequenceGeneratorTest {

	public static void doTest() {
		ISequenceGenerator generator = new AtkinSievePrimeSequenceGenerator();
		ISequenceGeneratorTester tester = new PrimeSequenceGeneratorTester(generator);
		tester.test();
	}
	
	public static void main(String[] args) {
		doTest();
	}

}
