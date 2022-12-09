package parkingSystem.parking.dto;

import java.time.LocalDateTime;

import parkingSystem.parking.billing.BillingType;

public class CheckInDto implements Cloneable
{
	private String license = null;
	private String state = null;
	private String model = null;
	private String color = null;
	private LocalDateTime entry = null;
	private BillingType billingType = null;
	
	//----------------------------------------------------------------
	public CheckInDto() {};
	
	//----------------------------------------------------------------
   public 
   CheckInDto(String license, String state, String model, 
   		String color, LocalDateTime entry, BillingType billingType)
	{
		super();
		this.license = license;
		this.state = state;
		this.model = model;
		this.color = color;
		this.entry = entry;
		this.billingType = billingType;
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
   public CheckInDto clone()
   {
   	 try
	    {
		 	 return (CheckInDto) super.clone();
		 }
		 catch( CloneNotSupportedException e )
		 {
			e.printStackTrace();
		 }
		 return null;
   }
}
