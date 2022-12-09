package parkingSystem.parking.useCases.impl;

import java.util.List;

import parkingSystem.parking.dto.CheckInDto;
import parkingSystem.parking.dto.CheckInDtoMapper;
import parkingSystem.parking.model.CheckIn;
import parkingSystem.parking.services.BasicCheckInService;
import parkingSystem.parking.useCases.CheckInUse;

public class CheckInUseImpl implements CheckInUse {
		
	private final CheckInDtoMapper mapper;
	private final BasicCheckInService service;
	
	public CheckInUseImpl(CheckInDtoMapper mapper, BasicCheckInService service) {
		this.mapper = mapper;
		this.service = service;
	}

	@Override
	public CheckInDto doCheckIn(CheckInDto checkInDto) {
		CheckIn checkIn = mapper.fromDto(checkInDto);
		
		checkIn = service.save(checkIn);
		
		return mapper.toDto(checkIn);
	}

	@Override
	public List<CheckInDto> findAllCheckIn(String license) {
		return service
				.findAll()
				.filter(checkIn -> license.equalsIgnoreCase(checkIn.getLicense()))
				.map(mapper::toDto)
				.toList();
	}
	
	
}
