package prototype;

public class AppArrayCloneTest
{

	//-----------------------------------------------------------------------------------------------------
	private void shouldDoShallowArrayCopy()
	{
		int[] array = {0,1,2,3,4,5,6,7,8,9};
		int[] clone = array.clone();
		
		if(array == clone)
			System.out.println("Error - the instances should be differents");
		
		if(array.length != clone.length)
			System.out.println("Error - the lengths of arrays should be equals");
		
		for(int i=0; i<array.length; i++)
		{
			if(array[i] != clone[i])
				System.out.println("Error - the elements should be equals between then");
		}
		
		clone[0] = 5;
		if(array[0] == clone[0])
			System.out.println("Error - the changes on clone should not be reflected on the original array");
	}
	
	//-----------------------------------------------------------------------------------------------------
	private void shouldDoDeepArrayCopy()
	{
		Address[] array = {
				new Address("Toledo"  , "Pr", "Rua Cristo Rei", 419, "Bloco C - sala 301"),
				new Address("Cascavel", "Pr", "Rua S�o Paulo", 123, "casa"),
				new Address("Marechal", "Pr", "Rua Salom�o", 201, "Bloco A - Apto 101")
		};
		
		Address[] clone = array.clone();
		
		for(int i=0; i<array.length; i++)
			clone[0] = array[0].clone();
		
		if(array == clone)
			System.out.println("Error - the instances should be differents");
		
		if(array.length != clone.length)
			System.out.println("Error - the lengths of arrays should be equals");
		
		for(int i=0; i<array.length; i++)
		{
			if(array[i] != clone[i])
				System.out.println("Error - the elements should be equals between then");
		}
		
		clone[0].setCity("CURITIBA");
		if(array[0].getCity() == clone[0].getCity())
			System.out.println("Error - the changes on clone should not be reflected on the original array");
	}
	
	//-----------------------------------------------------------------------------------------------------
	static public void main(String[] args)
	{
		AppArrayCloneTest app = new AppArrayCloneTest();
		
		app.shouldDoShallowArrayCopy();
		app.shouldDoDeepArrayCopy();
	}
}
