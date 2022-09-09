package br.edu.utfpr.td.tsi.generators.test;

import br.edu.utfpr.td.tsi.generators.ISequenceGenerator;
import br.edu.utfpr.td.tsi.generators.fibonacci.FibonacciSequenceGenerator;
import br.edu.utfpr.td.tsi.generators.fibonacci.test.FibonacciSequenceGeneratorTester;

public class FibonacciSequenceGeneratorTest {

	public static void doTest() {
		ISequenceGenerator generator = new FibonacciSequenceGenerator();
		ISequenceGeneratorTester tester = new FibonacciSequenceGeneratorTester(generator);
		tester.test();
	}
	
	public static void main(String[] args) {
		doTest();
	}

}
