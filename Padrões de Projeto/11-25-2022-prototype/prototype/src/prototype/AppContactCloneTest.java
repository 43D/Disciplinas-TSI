package prototype;

public class AppContactCloneTest
{
	//-------------------------------------------------------------------------------------------
	private Address createAddress() 
	{
		return new Address(
			"Toledo", 
			"Pr",
			"Rua Cristo Rei",
			 419,
			"Bloco C - sala 301"
		);
	}
	
	//-------------------------------------------------------------------------------------------
	private Contact createContact()
	{
		return new Contact(
			"Vilson Luiz Dalle Mole",
			"(45) 3379-6800",
			"vldmole@utfpr.edu.br",
			createAddress()
		);
	}
	
	//-------------------------------------------------------------------------------------------
	private void souldDoDeepCopy()
	{
		Contact contact = createContact();
		
		Contact clone = contact.clone();
		
		System.out.println(contact);
		System.out.println(clone);
		
		if(contact == clone)
			System.out.println("Erro - the instances should be differents");
		
		if(contact.getName() != clone.getName())
			System.out.println("Error - The references should be equals - String is Immutable");
		
		if(contact.getFone() != clone.getFone())
			System.out.println("Error - The references should be equals - String is Immutable");
		
		if(contact.getEmail() != clone.getEmail())
			System.out.println("Error - The references should be equals - String is Immutable");
		
		if(contact.getAddress() == clone.getAddress())
			System.out.println("Error - The references should be not equals - Address is mutable");
		
		System.out.println("\n------------------------------------------------------------\n");
		
		clone.setName("Pedro da Silva");
		clone.getAddress().setCity("Cascavel");
		
		System.out.println(contact);
		System.out.println(clone);
		
		if(contact.getAddress().getCity() == clone.getAddress().getCity())
			System.out.println("Error - The references should be not equals - Address is mutable");
	}
	
	//-------------------------------------------------------------------------------------------
	public static void main(String[] args)
	{
		AppContactCloneTest app = new AppContactCloneTest();
		
		app.souldDoDeepCopy();
	}	
}
