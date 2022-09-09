package br.edu.utfpr.td.tsi.generators.fibonacci;

import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.td.tsi.generators.AbstractSequenceGenerator;

public class FibonacciSequenceGenerator extends AbstractSequenceGenerator{

	private List<Integer> generateSequence;
	private int current;
	private int next;
	private int previous;
	
	@Override
	public List<Integer> generateSequence(int MAX) {
		if (MAX < 0)
			return new ArrayList<>();
		
		init(MAX);
	
		createSequenceOf(MAX);
		
		return generateSequence;
	}

	private void init(final int MAX) {
		generateSequence = new ArrayList<>(MAX);
		current = 1;
		next = Integer.MIN_VALUE;
		previous = 0;
	}
	
	private void createSequenceOf(final int MAX) {
		while(current <= MAX) {
			addCurrentNumber();
			calculeNextNumber();
			registrerAccountant();			
		}
	}

	private void calculeNextNumber() {
		next = current + previous;
	}
	
	private void addCurrentNumber() {
		generateSequence.add(current);
	}
	
	private void registrerAccountant() {
		previous = current;
		current = next;
	}
}
