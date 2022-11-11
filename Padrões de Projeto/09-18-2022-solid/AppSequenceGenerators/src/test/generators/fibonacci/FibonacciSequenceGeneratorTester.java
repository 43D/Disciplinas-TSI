package test.generators.fibonacci;

import java.util.List;

import generators.ISequenceGenerator;
import test.generators.AbstractSequenceGeneratorTester;

public class FibonacciSequenceGeneratorTester 
extends AbstractSequenceGeneratorTester
{
	//----------------------------------------------------------------------------
	public FibonacciSequenceGeneratorTester(ISequenceGenerator generator)
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
	private void testIfProduceAListWithTwoFirstElementsOnly()
	{
		List<Integer> sequence = super.generator.generateSequence(1);
		if(sequence.size() != 2 )
			System.out.println("Erro- esperado lista com 2 elementos " +sequence.size());
		else if(sequence.get(0) != 1 || sequence.get(1) != 1)
			System.out.println("Erro- esperado 1,1 recebido " +
		             sequence.get(0) + ", "+sequence.get(1));
	}
	
	//----------------------------------------------------------------------------
	private void testIfProduceCorrectSequence()
	{
		int expected[] = {1,1,2,3,5,8,13,21};
		List<Integer>sequence = super.generator.generateSequence(21);
		if(sequence.size() != 8 )
			System.out.println("Erro- esperado lista com 8 elementos " +sequence.size());
		else
		{
			for(int i=0; i<expected.length; i++)
			{
				if(expected[i] != sequence.get(i))
					System.out.println("Erro- esperado "+expected[i] +
							" recebeido " + sequence.get(i));
			}
		}
	}
	
	//----------------------------------------------------------------------------
	@Override
	public void test()
	{
		testIfProduceAnEmptyList();
		testIfProduceAListWithTwoFirstElementsOnly();
		testIfProduceCorrectSequence();		
	}
}
