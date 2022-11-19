package parkingSystem.parking.billing.factory;

import java.util.Arrays;

import parkingSystem.parking.billing.BillingType;
import parkingSystem.parking.billing.strategy.BillCalculator;
import parkingSystem.parking.billing.strategy.DailyBilling;
import parkingSystem.parking.billing.strategy.HourBilling;
import parkingSystem.parking.billing.strategy.MonthBilling;

public final class BillCalculatorFactoryImp implements BillCalculatorFactory {

	static private BillCalculatorFactory singletonInstance = null;

	public BillCalculatorFactory getInstance() {
		if (singletonInstance == null)
			singletonInstance = new BillCalculatorFactoryImp();

		return singletonInstance;
	}

	private BillCalculatorFactoryImp() {
	}

	@FunctionalInterface
	static private interface Factory {
		BillCalculator create();
	}

	static private Factory[] factories = {
			() -> new HourBilling(),
			() -> new DailyBilling(),
			() -> new MonthBilling()
	};

	static private BillCalculator[] billCalculatorInstances = new BillCalculator[BillingType.values().length];

	static {
		Arrays.fill(billCalculatorInstances, null);
	}

	@Override
	public BillCalculator createBillCalculator(BillingType type) {
		if(billCalculatorInstances[type.ordinal()] == null)
			billCalculatorInstances[type.ordinal()] = factories[type.ordinal()].create();
		
		return billCalculatorInstances[type.ordinal()];
	}

}
