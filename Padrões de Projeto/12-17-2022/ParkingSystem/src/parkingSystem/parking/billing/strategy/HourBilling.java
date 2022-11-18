package parkingSystem.parking.billing.strategy;

import java.time.Duration;
import java.time.LocalDateTime;

import parkingSystem.parking.billing.Bill;
import parkingSystem.parking.billing.SimpleBillBuilder;

public class HourBilling extends AbstractBilling {

	public float getAdditionalHourTax() {
		return super.additionalTax;
	}

	public float getFirstHourTax() {
		return super.baseTax;
	}

	@Override
	protected Bill calculateBill(LocalDateTime parkingEntry, LocalDateTime parkingExit) {
		SimpleBillBuilder billBuilder = new SimpleBillBuilder();
		billBuilder
			.parkingEntry(parkingEntry)
			.parkingExit(parkingExit)
			.appendDescriptio("Fisrt hour", getFirstHourTax());

		long minutes = Duration.between(parkingEntry, parkingExit).toMinutes();
		long hour = minutes / 60;
		float additionalTime = hour + ((minutes / 15) * 0.25f);

		if (additionalTime > 0) {
			float additionalValue = additionalTime * getAdditionalHourTax();
			String description = String.format("Additional %d hous", additionalTime);
			billBuilder.appendDescriptio(description, additionalValue);
		}

		return billBuilder.build();
	}

}
