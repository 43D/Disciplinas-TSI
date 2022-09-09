package br.edu.utfpr.td.tsi.generators.fibonacci.test;

import java.util.List;

import br.edu.utfpr.td.tsi.generators.ISequenceGenerator;
import br.edu.utfpr.td.tsi.generators.test.AbstractSequenceGeneratorTester;

public class FibonacciSequenceGeneratorTester  extends AbstractSequenceGeneratorTester{

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
        	System.out.println("Erro - A lista n�o est� vazia: " + primeSequence.size());
        }
	}
	
	private void testGetZero(){
		List<Integer> primeSequence = getSequenceOf(0);
		
		if (primeSequence.size() != 0) {
        	System.out.println("Erro - A lista n�o est� vazia: " + primeSequence.size());
        }
	}
	
	private void testGetOne(){
		List<Integer> primeSequence = getSequenceOf(1);
		int[] expectedResult = {1,1};
		
		if (!isMatches(primeSequence, expectedResult)) {
        	System.out.println("Erro - A lista errada: " + primeSequence.toString());
        }
	}
	private void testGetTwenty(){
		List<Integer> primeSequence = getSequenceOf(20);
		int[] expectedResult = { 1, 1, 2, 3, 5, 8, 13 };
		
		if (!isMatches(primeSequence, expectedResult)) {
        	System.out.println("Erro - A lista errada: " + primeSequence.toString());
        }
	}
}
