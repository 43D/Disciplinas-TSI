package generators.test;

import generators.ISequenceGenerator;

public abstract class AbstractSequenceGeneratorTester 
{
	protected final ISequenceGenerator generator;
	
	//-------------------------------------------------------------------
	public AbstractSequenceGeneratorTester(ISequenceGenerator generator)
	{
		this.generator = generator;
	}
	
	//-------------------------------------------------------------------
	public abstract void test();
}
