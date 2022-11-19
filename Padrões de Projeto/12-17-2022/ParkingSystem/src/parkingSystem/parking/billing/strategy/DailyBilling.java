package parkingSystem.parking.billing.strategy;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import parkingSystem.parking.billing.Bill;
import parkingSystem.parking.billing.SimpleBillBuilder;

public class DailyBilling extends AbstractBilling {

	public float getAdditionalDayTax() {
		return super.additionalTax;
	}

	public float getFirstDayTax() {
		return super.baseTax;
	}

	@Override
	protected Bill calculateBill(LocalDateTime parkingEntry, LocalDateTime parkingExit) {
		SimpleBillBuilder billBuilder = new SimpleBillBuilder();
		billBuilder.parkingEntry(parkingEntry)
			.parkingExit(parkingExit)
			.appendDescriptionItem("Fisrt day", getFirstDayTax());

		long completeDays = ChronoUnit.DAYS.between(parkingEntry, parkingExit);

		LocalDateTime completeDaysDateTime = parkingEntry.plus(completeDays, ChronoUnit.DAYS);
		long additionalHours = ChronoUnit.HOURS.between(completeDaysDateTime, parkingExit);

		if (additionalHours > 2) {
			completeDays += 1;
		}
		if (--completeDays > 0) {
			String description = String.format("Additional days %d", completeDays);
			float value = completeDays * getAdditionalDayTax();

			billBuilder.appendDescriptionItem(description, value);
		}
		return billBuilder.build();
	}

}
