package br.edu.utfpr.td.tsi.test;

import java.util.List;

import br.edu.utfpr.td.tsi.generator.PrimeNumbersSequenceGenerator;
import br.edu.utfpr.td.tsi.generator.erastotenes.EratosthenesPrimeNumbersSequenceGenerator;

public class EratosthenesSiverPrimesSequencesGeneratorTest {

	
	public static void main(String[] args) {
		PrimeNumbersSequenceGenerator generator = new EratosthenesPrimeNumbersSequenceGenerator();

		List<Integer> primeSequence;
		
        primeSequence = generator.primeSequenceTo(0);
        if (primeSequence.size() != 0) {
        	System.out.println("Kde lista vazia: " + primeSequence.size());
        }
        primeSequence = generator.primeSequenceTo(20);
        int[] expectedResult = { 2, 3, 5, 7, 11 , 13,17, 19 };
        
        if (expectedResult.length != primeSequence.size()) {
            System.out.printf("\nErro - esperado %d recebido %d primes ", expectedResult.length, primeSequence.size());
        }
		
        for(int i= 0; i<expectedResult.length; i++) {
            if(expectedResult[i]!= primeSequence.get(i)) {
            	 System.out.printf("\nErro - lista errado");
            }
        }
        
        System.out.printf("\n Primos: " + primeSequence.toString());
        
        System.out.printf("\n Fim.");
	}

}
