package prototype;

public class AddressCloneTest
{
	//-------------------------------------------------------------------------------------------
	public void shouldDoShallowCopy()
	{
		Address address = new Address(
				"Toledo", 
				"Pr",
				"Rua Cristo Rei",
				419,
				"Bloco C - sala 301"
		);
		
		Address clone = (Address) address.clone();
		
		System.out.println(address);
		System.out.println(clone);
		
		if(address == clone)
			System.out.println("Error - the instances should be differents");
		
		if(address.getState() != clone.getState())
			System.out.println("Error - the references should be equals - STRING is IMMUTABLE");
		
		if(address.getCity() != clone.getCity())
			System.out.println("Error - the references should be equals - STRING is IMMUTABLE");
		
		if(address.getStreet() != clone.getStreet())
			System.out.println("Error - the references should be equals - STRING is IMMUTABLE");
		
		if(address.getNumber() != clone.getNumber())
			System.out.println("Error - the references should be equals - INTEGER is IMMUTABLE");
		
		if(address.getComplement() != clone.getComplement())
			System.out.println("Error - the references should be equals - STRING is IMMUTABLE");
	}
	
	//-------------------------------------------------------------------------------------------
	public static void main(String[] args)
	{
		new AddressCloneTest().shouldDoShallowCopy();
	}
}
