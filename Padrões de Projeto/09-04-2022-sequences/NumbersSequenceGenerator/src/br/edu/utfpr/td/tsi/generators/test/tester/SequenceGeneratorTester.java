package br.edu.utfpr.td.tsi.generators.test.tester;

import java.util.List;

import br.edu.utfpr.td.tsi.generators.ISequenceGenerator;

public abstract class SequenceGeneratorTester implements ISequenceGeneratorTester {

	protected final ISequenceGenerator generator;
	
	public SequenceGeneratorTester(ISequenceGenerator generator) {
		this.generator = generator;
	}
	
	@Override
	public abstract void test();
	
	protected void destroy() {
		System.out.println("Fim!!!");
	}

	protected List<Integer> getSequenceOf(final int MAX){
		return generator.generateSequence(MAX);
	}
	
	protected boolean isMatches(final List<Integer> SOURCE_LIST, final int[] SEARCH_LIST) {
		
		for(int index= 0; index<SOURCE_LIST.size(); index++)
			if(!isMatches(SOURCE_LIST.get(index), SEARCH_LIST[index])) 
				return false;
		
		return true;
	}

	protected boolean isMatches(final int SOURCE_NUNBER, final int SEARCH_NUMBER) {
		if(SOURCE_NUNBER == SEARCH_NUMBER)
			return true;
		return false;
	}
	
}
