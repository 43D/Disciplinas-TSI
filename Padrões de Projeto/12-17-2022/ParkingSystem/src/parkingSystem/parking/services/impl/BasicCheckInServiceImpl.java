package parkingSystem.parking.services.impl;

import java.util.stream.Stream;

import parkingSystem.common.repository.JpaRepository;
import parkingSystem.parking.model.CheckIn;
import parkingSystem.parking.services.BasicCheckInService;

public class BasicCheckInServiceImpl implements BasicCheckInService {

	private JpaRepository<CheckIn, Long> repository; 
	
	public BasicCheckInServiceImpl(JpaRepository<CheckIn, Long> repository) {
		this.repository = repository;
	}

	@Override
	public Stream<CheckIn> findAll() {
		return repository.findAll();
	}

	@Override
	public Stream<CheckIn> findAllByLicense(String license) {
		return repository.filter(checkIn -> license.equalsIgnoreCase(checkIn.getLicense()));
	}

	@Override
	public CheckIn save(CheckIn checkIn) {
		return repository.save(checkIn);
	}

}
