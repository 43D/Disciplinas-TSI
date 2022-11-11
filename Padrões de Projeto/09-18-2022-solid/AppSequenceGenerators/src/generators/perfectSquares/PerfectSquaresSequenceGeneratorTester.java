package generators.perfectSquares;

import java.util.Arrays;
import java.util.List;

import generators.ISequenceGenerator;
import generators.test.AbstractSequenceGeneratorTester;

public class PerfectSquaresSequenceGeneratorTester
extends AbstractSequenceGeneratorTester
{
	//----------------------------------------------------------------------------
	public PerfectSquaresSequenceGeneratorTester(ISequenceGenerator generator)
	{
		super(generator);
	}

	//----------------------------------------------------------------------------
	private void testIfProduceAnEmptyList()
	{
		List<Integer> sequence = super.generator.generateSequence(-1);
		if(sequence.size() !=0 )
			System.out.println("Erro- esperado lista vazia " +sequence.size());
		
		sequence = super.generator.generateSequence(0);
		if(sequence.size() !=0 )
			System.out.println("Erro- esperado lista vazia " +sequence.size());
	}
	
	//----------------------------------------------------------------------------
	private void testIfProduceAListWithOneElementOnly()
	{
		List<Integer> sequence = super.generator.generateSequence(1);
		
		if(sequence.size() != 1 )
		{
			System.out.println("Erro- esperado lista com 1 elemento apenas " +
					Arrays.toString(sequence.toArray()));
		}
		else if(sequence.get(0) != 1)
		{
			System.out.println("Erro- esperado {1} recebido " +
		             Arrays.toString(sequence.toArray()));
		}
	}
	
	//----------------------------------------------------------------------------
	private void testIfProduceCorrectSequence()
	{
		int expected[] = {1,4,9,16,25,36,49};
		List<Integer>sequence = super.generator.generateSequence(49);
		if(sequence.size() != 7 )
		{
			System.out.println("Erro- esperado lista com 7 elementos, recebido " +
					sequence.size());
		}
		else
		{
			for(int i=0; i<expected.length; i++)
			{
				if(expected[i] != sequence.get(i))
				{
					System.out.println("Erro- esperado " + 
							Arrays.toString(expected) +
							" recebeido " + 
							Arrays.toString(sequence.toArray()));
				}
			}
		}
	}
	
	//----------------------------------------------------------------------------
	@Override
	public void test()
	{
		testIfProduceAnEmptyList();
		testIfProduceAListWithOneElementOnly();
		testIfProduceCorrectSequence();		
	}
}
