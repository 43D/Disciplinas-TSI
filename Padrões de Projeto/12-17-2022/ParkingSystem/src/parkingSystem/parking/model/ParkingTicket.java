package parkingSystem.parking.model;

import java.time.LocalDateTime;

import parkingSystem.parking.billing.BillingType;

public class ParkingTicket 
{
	private long id;
	private String license;
	private LocalDateTime entry;
	private LocalDateTime exit;
	private BillingType billingType;
	private String billDescription;
	private float billValue;
	
	//-----------------------------------------------------
	public long getId()
	{
		return id;
	}
	
	//-----------------------------------------------------
	public void setId(long id) 
	{
		this.id = id;
	}
	
	//-----------------------------------------------------
	public String getLicense() 
	{
		return license;
	}
	
	//-----------------------------------------------------
	public void setLicense(String license) 
	{
		this.license = license;
	}
	
	//-----------------------------------------------------
	public LocalDateTime getEntry() 
	{
		return entry;
	}
	
	//-----------------------------------------------------
	public void setEntry(LocalDateTime entry)
	{
		this.entry = entry;
	}
	
	//-----------------------------------------------------
	public LocalDateTime getExit()
	{
		return exit;
	}
	
	//-----------------------------------------------------
	public void setExit(LocalDateTime exit) 
	{
		this.exit = exit;
	}
	
	//-----------------------------------------------------
	public BillingType getBillingType() 
	{
		return billingType;
	}
	
	//-----------------------------------------------------
	public void setBillingType(BillingType billingType) 
	{
		this.billingType = billingType;
	}
	
	//-----------------------------------------------------
	public String getBillDescription() 
	{
		return billDescription;
	}
	
	//-----------------------------------------------------
	public void setBillDescription(String billDescription) 
	{
		this.billDescription = billDescription;
	}
	
	//-----------------------------------------------------
	public float getBillValue() 
	{
		return billValue;
	}
	
	//-----------------------------------------------------
	public void setBillValue(float billValue) 
	{
		this.billValue = billValue;
	}
}
