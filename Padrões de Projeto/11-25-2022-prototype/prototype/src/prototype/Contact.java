package prototype;

public class Contact implements Cloneable
{
	private String name = null;
	private String fone = null;
	private String email = null;
	private Address address = null;
	
	//-------------------------------------------------------------------------------------------
	public Contact()
	{
		super();
	}
	
	//-------------------------------------------------------------------------------------------
	public Contact(String name, String fone, String email, Address address)
	{
		super();
		this.name = name;
		this.fone = fone;
		this.email = email;
		this.address = address;
	}

	//-------------------------------------------------------------------------------------------
	public String getName()
	{
		return name;
	}

	//-------------------------------------------------------------------------------------------
	public void setName(String name)
	{
		this.name = name;
	}

	//-------------------------------------------------------------------------------------------
	public String getFone()
	{
		return fone;
	}

	//-------------------------------------------------------------------------------------------
	public void setFone(String fone)
	{
		this.fone = fone;
	}

	//-------------------------------------------------------------------------------------------
	public String getEmail()
	{
		return email;
	}

	//-------------------------------------------------------------------------------------------
	public void setEmail(String email)
	{
		this.email = email;
	}

	//-------------------------------------------------------------------------------------------
	public Address getAddress()
	{
		return address;
	}

	//-------------------------------------------------------------------------------------------
	public void setAddress(Address address)
	{
		this.address = address;
	}
	
	//-------------------------------------------------------------------------------------------
	@Override
	public String toString()
	{
		return new StringBuilder()
		.append("{")
		.append(this.name)
		.append(", ")
		.append(this.fone)
		.append(", ")
		.append(this.email)
		.append("\n")
		.append(this.address)
		.append("}")
		.toString();
	}
	
	public Contact clone() {
		try {
			Contact clone = (Contact) super.clone();
			clone.setAddress(address.clone());
			return clone;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
