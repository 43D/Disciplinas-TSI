package br.edu.utfpr.td.tsi.generators.fibonacci;

import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.td.tsi.generators.AbstractSequenceGenerator;

public class FibonacciSequenceGenerator extends AbstractSequenceGenerator{

	private List<Integer> generateSequence;
	private int current = 1;
	private int next = Integer.MIN_VALUE;
	private int previous = 0;
	
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
	}
	
	private void createSequenceOf(final int MAX) {
		for(int i=0; i<MAX; i++) {
			addNextNumber();
			
			if (i == 0)
				continue;
			
			registrerAccountant();
		}
	}
	private void addNextNumber() {
		next = current + previous;
		generateSequence.add(next);
	}
	private void registrerAccountant() {
		previous = current;
		current = next;
	}
	
}
