package test.generators.prime;

import java.util.List;

import generators.ISequenceGenerator;
import test.generators.AbstractSequenceGeneratorTester;

public class PrimeSequenceGeneratorTester 
extends AbstractSequenceGeneratorTester
{
	//-----------------------------------------------------------------------------
	public PrimeSequenceGeneratorTester(ISequenceGenerator generator)
	{
		super(generator);
	}

	//-----------------------------------------------------------------------------
	@Override
	public void test() 
	{
		List<Integer> sequence = super.generator.generateSequence(0);
		if(sequence.size()>0)
			System.out.println("erro - esperado lista vazia " + sequence.size());
		
		sequence = super.generator.generateSequence(1);
		if(sequence.size()>0)
			System.out.println("erro - esperado lista vazia " + sequence.size());
		
		sequence = super.generator.generateSequence(2);
		if(sequence.size() != 1)
			System.out.println("erro - esperado lista com um elemento " + sequence.size());
		else if(sequence.get(0) != 2)
			System.out.println("erro - esperado 2 " + sequence.get(0));
		
		int expected[] = {2,3,5,7,11,13,17,19};
		sequence = super.generator.generateSequence(19);
		if(sequence.size() != 8)
			System.out.println("erro - esperado lista com 8 elementos " + sequence.size());
		else 
		{
			for(int i=0; i<expected.length; i++)
			{
				if(expected[i] != sequence.get(i))
					System.out.println("erro - esperado " + expected[i]+
							" recebido "+sequence.get(i));
			}		
		}	
	}
}
