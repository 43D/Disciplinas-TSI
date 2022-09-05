package br.edu.utfpr.td.tsi.generators.odd;

import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.td.tsi.generators.AbstractSequenceGenerator;

public class OddSequenceGenerator extends AbstractSequenceGenerator{

	private List<Integer> resultantSequence;
	
	@Override
	public List<Integer> generateSequence(int MAX) {
		if (MAX <= 0)
			return new ArrayList<>();
		
		init(MAX);
		
		makeValueOfList(MAX);
		
		return resultantSequence;
	}

	private void makeValueOfList(int MAX) {
		for(int index = 1; index<= MAX; index++) 
			if(isOdd(index)) 
				resultantSequence.add(index);
	}

	private boolean isOdd(final int NUMBER) {
		return (NUMBER % 2 == 1) ? true : false;
	}

	private void init(final int MAX) {
		resultantSequence = new ArrayList<>( getHalfA(MAX));
	}
	
	private int getHalfA(final int NUMBER) {
		return (int) Math.ceil(NUMBER / 2);
	}
}
