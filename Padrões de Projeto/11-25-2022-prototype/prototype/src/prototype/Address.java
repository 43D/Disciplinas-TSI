package prototype;

public class Address implements Cloneable {
	private String city;
	private String state;
	private String street;
	private Integer number;
	private String complement;

	// -------------------------------------------------------------------------------------------
	public Address() {
		super();
	}

	// -------------------------------------------------------------------------------------------
	public Address(String city, String state, String street, Integer number, String complement) {
		this();
		this.city = city;
		this.state = state;
		this.street = street;
		this.number = number;
		this.complement = complement;
	}

	// -------------------------------------------------------------------------------------------
	public String getCity() {
		return city;
	}

	// -------------------------------------------------------------------------------------------
	public void setCity(String city) {
		this.city = city;
	}

	// -------------------------------------------------------------------------------------------
	public String getState() {
		return state;
	}

	// -------------------------------------------------------------------------------------------
	public void setState(String state) {
		this.state = state;
	}

	// -------------------------------------------------------------------------------------------
	public String getStreet() {
		return street;
	}

	// -------------------------------------------------------------------------------------------
	public void setStreet(String street) {
		this.street = street;
	}

	// -------------------------------------------------------------------------------------------
	public Integer getNumber() {
		return number;
	}

	// -------------------------------------------------------------------------------------------
	public void setNumber(Integer number) {
		this.number = number;
	}

	// -------------------------------------------------------------------------------------------
	public String getComplement() {
		return complement;
	}

	// -------------------------------------------------------------------------------------------
	public void setComplement(String complement) {
		this.complement = complement;
	}

	// -------------------------------------------------------------------------------------------
	@Override
	public String toString() {
		return new StringBuilder().append("{").append(this.state).append(", ").append(this.city).append(", ")
				.append(this.street).append(", ").append(this.number).append(", ").append(this.complement).append("}")
				.toString();
	}

	public Address clone() {
		try {
			return (Address) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
