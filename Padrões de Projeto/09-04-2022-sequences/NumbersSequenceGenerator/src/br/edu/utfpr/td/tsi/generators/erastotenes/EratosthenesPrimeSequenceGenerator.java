package br.edu.utfpr.td.tsi.generators.erastotenes;

import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.td.tsi.generators.AbstractSequenceGenerator;

public class EratosthenesPrimeSequenceGenerator  extends AbstractSequenceGenerator{
	
	private List<Integer> resultantSequence;
	private List<Integer> candidateNumbers;
	private List<Boolean> candidateNumbersBoolean;
	
	@Override
	public List<Integer> generateSequence(final int MAX){
		if (MAX < 2)
			return new ArrayList<>();
		
		init(MAX);
		chooseCandidateNumbers();
		generateFinalResults();
		
		return resultantSequence;
	}
	
	private void init(final int MAX_NUMBER) {
		final int ARRAY_LENGHT = MAX_NUMBER + 1;
		candidateNumbers = new ArrayList<>(ARRAY_LENGHT);
		candidateNumbersBoolean = new ArrayList<>(ARRAY_LENGHT);
		makeValueOfList(MAX_NUMBER);
	}
	
	private void makeValueOfList(final int ARRAY_LENGHT) {
		for(int index = 0; index < ARRAY_LENGHT; index++) {
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
