package br.edu.utfpr.td.tsi.generators;

import java.util.List;

public abstract class AbstractSequenceGenerator implements ISequenceGenerator{

	public abstract List<Integer> generateSequence(final int MAX);
}
