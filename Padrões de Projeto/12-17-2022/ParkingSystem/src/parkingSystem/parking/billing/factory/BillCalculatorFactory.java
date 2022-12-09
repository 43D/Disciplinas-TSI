package parkingSystem.parking.billing.factory;

import parkingSystem.parking.billing.BillingType;
import parkingSystem.parking.billing.strategy.BillCalculator;

public interface BillCalculatorFactory 
{
	public BillCalculator createBillCalculator(BillingType type);
}
