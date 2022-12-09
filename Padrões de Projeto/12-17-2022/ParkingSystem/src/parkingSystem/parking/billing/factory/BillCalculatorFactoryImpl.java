package parkingSystem.parking.billing.factory;

import java.util.Arrays;

import parkingSystem.parking.billing.BillingType;
import parkingSystem.parking.billing.strategy.BillCalculator;
import parkingSystem.parking.billing.strategy.DayBilling;
import parkingSystem.parking.billing.strategy.HourBilling;
import parkingSystem.parking.billing.strategy.MonthBilling;

public final class BillCalculatorFactoryImpl implements BillCalculatorFactory
{
    static private
    BillCalculatorFactoryImpl singletonInstance = null;

    //---------------------------------------------------------------------
    public BillCalculatorFactoryImpl getInstance()
    {
        if(singletonInstance == null)
            singletonInstance = new BillCalculatorFactoryImpl();

        return singletonInstance;
    }

    //---------------------------------------------------------------------
    private BillCalculatorFactoryImpl()
    {
    	//singleton
    }

    //-----------------------------------------------------------------------------------
    @FunctionalInterface
    static private 
    interface Factory
    {
        BillCalculator create();
    }
    
    //-----------------------------------------------------------------------------------
    static private
    Factory[] factories = {
        ()-> new HourBilling(),
        ()-> new DayBilling(),
        ()-> new MonthBilling()
    };
    
    //-----------------------------------------------------------------------------------------
    static private
    BillCalculator[] billCalculatorInstances = new BillCalculator[BillingType.values().length];
    static {
    	Arrays.fill(billCalculatorInstances, null);
    }
    
    //-----------------------------------------------------------------------------------------
	@Override
	public BillCalculator createBillCalculator(BillingType type) 
	{
		if(billCalculatorInstances[type.ordinal()] == null)
            billCalculatorInstances[type.ordinal()] = factories[type.ordinal()].create();

        return billCalculatorInstances[type.ordinal()];
	}
}