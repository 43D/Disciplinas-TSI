package br.edu.utfpr.td.tsi.generators.test.tester.prime;

import java.util.List;

import br.edu.utfpr.td.tsi.generators.ISequenceGenerator;
import br.edu.utfpr.td.tsi.generators.test.tester.SequenceGeneratorTester;

public class PrimeSequenceGeneratorTester  extends SequenceGeneratorTester{

	
	public PrimeSequenceGeneratorTester(ISequenceGenerator generator) {
		super(generator);
	}

	@Override
	public void test() {
		testGetNegative();
		testGetZero();
		testGetOne();
		testGetTwo();
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
		if (primeSequence.size() != 0) {
        	System.out.println("Erro - A lista não está vazia: " + primeSequence.size());
        }
	}
	
	private void testGetTwo(){
		List<Integer> primeSequence = getSequenceOf(1);
		int[] expectedResult = {2};
		
		if (!isMatches(primeSequence, expectedResult)) {
        	System.out.println("Erro - A lista errada: " + primeSequence.toString());
        }
	}
	
	private void testGetTwenty(){
		List<Integer> primeSequence = getSequenceOf(20);
		int[] expectedResult = { 2, 3, 5, 7, 11 , 13,17, 19 };
		
		if (!isMatches(primeSequence, expectedResult)) {
        	System.out.println("Erro - A lista errada: " + primeSequence.toString());
        }
	}

}
