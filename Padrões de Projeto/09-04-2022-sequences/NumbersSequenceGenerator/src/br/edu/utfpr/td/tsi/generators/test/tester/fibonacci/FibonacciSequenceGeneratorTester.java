package br.edu.utfpr.td.tsi.generators.test.tester.fibonacci;

import java.util.List;

import br.edu.utfpr.td.tsi.generators.ISequenceGenerator;
import br.edu.utfpr.td.tsi.generators.test.tester.SequenceGeneratorTester;

public class FibonacciSequenceGeneratorTester  extends SequenceGeneratorTester{

	public FibonacciSequenceGeneratorTester(ISequenceGenerator generator) {
		super(generator);
	}

	@Override
	public void test() {
		testGetNegative();
		testGetZero();
		testGetOne();
		testGetTwenty();
		destroy();
	}
	
	private void testGetNegative(){
		List<Integer> primeSequence = getSequenceOf(-2);
		if (primeSequence.size() != 0) {
        	System.out.println("Erro - A lista não está vazia: " + primeSequence.size());
        }
	}
	
	private void testGetZero(){
		List<Integer> primeSequence = getSequenceOf(0);
		
		if (primeSequence.size() != 0) {
        	System.out.println("Erro - A lista não está vazia: " + primeSequence.size());
        }
	}
	
	private void testGetOne(){
		List<Integer> primeSequence = getSequenceOf(1);
		int[] expectedResult = {1};
		
		if (!isMatches(primeSequence, expectedResult)) {
        	System.out.println("Erro - A lista errada: " + primeSequence.toString());
        }
	}
	private void testGetTwenty(){
		List<Integer> primeSequence = getSequenceOf(20);
		int[] expectedResult = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765 };
		
		if (!isMatches(primeSequence, expectedResult)) {
        	System.out.println("Erro - A lista errada: " + primeSequence.toString());
        }
	}
}
