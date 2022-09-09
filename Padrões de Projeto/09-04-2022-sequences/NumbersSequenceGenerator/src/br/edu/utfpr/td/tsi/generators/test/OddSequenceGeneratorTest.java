package br.edu.utfpr.td.tsi.generators.test;

import br.edu.utfpr.td.tsi.generators.ISequenceGenerator;
import br.edu.utfpr.td.tsi.generators.odd.OddSequenceGenerator;
import br.edu.utfpr.td.tsi.generators.odd.test.OddSequenceGeneratorTester;

public class OddSequenceGeneratorTest {
	public void doTest() {
		ISequenceGenerator generator = new OddSequenceGenerator();
		ISequenceGeneratorTester tester = new OddSequenceGeneratorTester(generator);
		tester.test();
	}
	
	public static void main(String[] args) {
		new OddSequenceGeneratorTest().doTest();
	}
}
