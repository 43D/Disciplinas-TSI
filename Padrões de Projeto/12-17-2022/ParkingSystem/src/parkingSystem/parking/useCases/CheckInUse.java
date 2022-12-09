package parkingSystem.parking.useCases;

import java.util.List;

import parkingSystem.parking.dto.CheckInDto;

public interface CheckInUse {
	CheckInDto doCheckIn(CheckInDto checkInDto);
	List<CheckInDto> findAllCheckIn(String license);
}
