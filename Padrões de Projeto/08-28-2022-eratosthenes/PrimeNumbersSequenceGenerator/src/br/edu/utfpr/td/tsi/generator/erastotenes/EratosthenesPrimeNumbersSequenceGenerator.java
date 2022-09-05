package br.edu.utfpr.td.tsi.generator.erastotenes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.utfpr.td.tsi.generator.PrimeNumbersSequenceGenerator;

public class EratosthenesPrimeNumbersSequenceGenerator implements PrimeNumbersSequenceGenerator{
	
	private List<Integer> resultantSequence;
	private List<Integer> candidateNumbers;
	private List<Boolean> candidateNumbersBoolean;
	
	@Override
	public List<Integer> primeSequenceTo(int maxNumber){
		if (maxNumber < 2)
			return new ArrayList<>();
		
		createCandidateNumbers(maxNumber);
		chooseCandidateNumbers();
		generateFinalResults();
		
		return resultantSequence;
	}
	
	private void createCandidateNumbers(int maxNumber) {
		int ArrayLenght = maxNumber + 1;
		candidateNumbers = new ArrayList<>(ArrayLenght);
		candidateNumbersBoolean = new ArrayList<>(ArrayLenght);
		makeValueOfList(ArrayLenght);
	}
	
	private void makeValueOfList(int ArrayLenght) {
		for(int index = 0; index < ArrayLenght; index++) {
			candidateNumbers.add(index);
			candidateNumbersBoolean.add(true);
		}
		marcaodoisprimeiros();
	}
	private void marcaodoisprimeiros() {
		candidateNumbersBoolean.set(0, false);
		candidateNumbersBoolean.set(1, false);
	}
	
	private void chooseCandidateNumbers() {
		for(int index = 0; index < candidateNumbers.size(); index++) {
			rejectNumberIfAreCandidate(index); 
		}
	}
	private void rejectNumberIfAreCandidate(int index) {
		if (candidateNumbersBoolean.get(index)) {
			rejectNumberOf(index);
		}
	}
	private void rejectNumberOf(int primo) {
		for(int mutlipo = primo*2; mutlipo < candidateNumbers.size(); mutlipo+=primo) {
			candidateNumbersBoolean.set(mutlipo, false);
		}
	}
	
	private void generateFinalResults() {
		resultantSequence = new ArrayList<>();
		readPossiblePrimeNumbers();
	}
	
	private void readPossiblePrimeNumbers() {
		for(int index = 0; index < candidateNumbers.size(); index++) {
			checkTruePrimeNumbers(index); 
		}
	}
	
	private void checkTruePrimeNumbers(int index) {
		if (candidateNumbersBoolean.get(index)) {
			addTruePrimeNumber(index);
		}
	}
	private void addTruePrimeNumber(int prime) {
		resultantSequence.add(prime);
	}
}
