package parkingSystem.parking.model;

import java.time.LocalDateTime;

import parkingSystem.parking.billing.BillingType;

public class CheckInBuilder 
{
	private long id;
	private String license;
	private String state;
	private String model;
	private String color;
	private LocalDateTime entry;
	private BillingType billingType;
	
	//-----------------------------------------------------
	public
	CheckInBuilder id (long id)
	{
		this.id = id;
		return this;
	}
	
	//-----------------------------------------------------
	public
	CheckInBuilder license (String license)
	{
		this.license = license;
		return this;
	}
	
	//-----------------------------------------------------
	public
	CheckInBuilder state (String state)
	{
		this.state = state;
		return this;
	}
	
	//-----------------------------------------------------
	public
	CheckInBuilder model( String model)
	{
		this.model = model;
		return this;
	}
	
	//-----------------------------------------------------
	public  
	CheckInBuilder color( String color)
	{
		this.color = color;
		return this;
	}
	
	//-----------------------------------------------------
	public 
	CheckInBuilder entry(LocalDateTime entry)
	{
		this.entry = entry;
		return this;
	}
	
	//-----------------------------------------------------
	public
	CheckInBuilder billingType (BillingType billingType)
	{
		this.billingType = billingType;
		return this;
	}
	
	//-----------------------------------------------------
	public
	CheckIn build()
	{
		CheckIn checkIn = new CheckIn();
		
		checkIn.setId(id);
		checkIn.setBillingType(billingType);
		checkIn.setColor(color);
		checkIn.setEntry(entry);
		checkIn.setLicense(license);
		checkIn.setModel(model);
		checkIn.setState(state);
		
		return checkIn;
	}
}
