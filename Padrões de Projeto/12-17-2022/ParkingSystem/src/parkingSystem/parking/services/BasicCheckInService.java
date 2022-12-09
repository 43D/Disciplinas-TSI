package parkingSystem.parking.services;

import java.util.stream.Stream;

import parkingSystem.parking.model.CheckIn;

public interface BasicCheckInService {
	Stream<CheckIn> findAll();

	Stream<CheckIn> findAllByLicense(String license);

	CheckIn save(CheckIn checkIn);

	default Stream<CheckIn> findAllSorted(String license) {
		return findAllByLicense(license)
				.sorted((a, b) -> a.getEntry().compareTo(b.getEntry()));
	}

}
