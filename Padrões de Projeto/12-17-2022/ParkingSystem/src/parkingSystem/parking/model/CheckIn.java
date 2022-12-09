package parkingSystem.parking.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import parkingSystem.common.repository.Entity;
import parkingSystem.parking.billing.BillingType;

public class CheckIn implements Entity<CheckIn, Long>
{
	private Long id = null;
	private String license = null;
	private String state = null;
	private String model = null;
	private String color = null;
	private LocalDateTime entry = null;
	private BillingType billingType = null;
	
	//------------------------------------------------
	public final
	void setId(Long id)
    {
        this.id = id;
    }

	//------------------------------------------------
    public final 
    Long getId()
    {
        return id;
    }

    //------------------------------------------------
    public final
    String getLicense()
    {
        return license;
    }

    //------------------------------------------------
    public final
    void setLicense(String license)
    {
        this.license = license;
    }

    //------------------------------------------------
    public final
    String getState()
    {
        return state;
    }

    //------------------------------------------------
    public final
    void setState(String state)
    {
        this.state = state;
    }
    
    //------------------------------------------------
    public final
    String getModel()
    {
        return model;
    }

    //------------------------------------------------
    public final 
    void setModel(String model)
    {
        this.model = model;
    }

    //------------------------------------------------
    public final
    String getColor()
    {
        return color;
    }

    //------------------------------------------------
    public final
    void setColor(String color)
    {
        this.color = color;
    }

    //------------------------------------------------
    public final
    LocalDateTime getEntry()
    {
        return entry;
    }

    //------------------------------------------------
    public final
    void setEntry(LocalDateTime entry)
    {
        this.entry = entry;
    }

    //------------------------------------------------
    public final
    BillingType getBillingType()
    {
        return this.billingType;
    }

    //------------------------------------------------
    public final
    void setBillingType(BillingType billingType)
    {
        this.billingType = billingType;
    }
    
    //------------------------------------------------
    @Override
    public CheckIn clone()
    {
    	try
		{
			return (CheckIn) super.clone();
		}
		catch( CloneNotSupportedException e )
		{
			e.printStackTrace();
		}
		return null;
    }
    
    //------------------------------------------------
    @Override
    public String toString()
    {
   	 StringBuilder sb = new StringBuilder();
   	 
   	 sb.append("{\n");
   	 sb.append(String.format("id: %03d\n", this.id));
   	 sb.append(String.format("License: %7s\n", this.license));
   	 sb.append(String.format("State: %2s\n", this.state));
   	 sb.append(String.format("Model: %-15s\n", this.model));
   	 sb.append(String.format("Color: %-10s\n", this.color));
   	 sb.append(String.format("BillingType: %-10s\n", this.billingType));
   	 sb.append(String.format("Entry: %-15s\n", this.entry.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
   	 sb.append("}");
   	 				 
   	 return sb.toString();
    }
}
