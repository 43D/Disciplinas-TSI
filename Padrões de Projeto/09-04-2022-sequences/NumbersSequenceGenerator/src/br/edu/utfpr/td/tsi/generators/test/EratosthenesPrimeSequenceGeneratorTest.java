package br.edu.utfpr.td.tsi.generators.test;

import br.edu.utfpr.td.tsi.generators.ISequenceGenerator;
import br.edu.utfpr.td.tsi.generators.prime.erastotenes.EratosthenesPrimeSequenceGenerator;
import br.edu.utfpr.td.tsi.generators.prime.test.PrimeSequenceGeneratorTester;

public class EratosthenesPrimeSequenceGeneratorTest {
	
	public static void doTest() {
		ISequenceGenerator generator = new EratosthenesPrimeSequenceGenerator();
		ISequenceGeneratorTester tester = new PrimeSequenceGeneratorTester(generator);
		tester.test();
	}
	
	public static void main(String[] args) {
		doTest();
	}
	
}
