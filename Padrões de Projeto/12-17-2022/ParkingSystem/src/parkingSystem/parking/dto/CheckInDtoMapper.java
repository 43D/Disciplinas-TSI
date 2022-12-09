package parkingSystem.parking.dto;

import java.util.List;

import parkingSystem.common.dto.DtoMapper;
import parkingSystem.parking.model.CheckIn;

public class CheckInDtoMapper implements DtoMapper<CheckIn, CheckInDto> {

	@Override
	public CheckIn fromDto(CheckInDto dto) {
		
		CheckIn checkIn = new CheckIn();
		
		checkIn.setLicense(dto.getLicense());
		checkIn.setState(dto.getState());
		checkIn.setModel(dto.getModel());
		checkIn.setColor(dto.getColor());
		checkIn.setBillingType(dto.getBillingType());
		checkIn.setEntry(dto.getEntry());
		
		return checkIn;
	}

	@Override
	public CheckInDto toDto(CheckIn checkIn) {
		CheckInDto dto = new CheckInDto();
		
		dto.setLicense(checkIn.getLicense());
		dto.setState(checkIn.getState());
		dto.setModel(checkIn.getModel());
		dto.setColor(checkIn.getColor());
		dto.setBillingType(checkIn.getBillingType());
		dto.setEntry(checkIn.getEntry());
		
		return dto;
	}

	@Override
	public List<CheckIn> fromDto(List<CheckInDto> dtoList) {
		return dtoList.stream().map(dto -> fromDto(dto)).toList();
	}

	@Override
	public List<CheckInDto> toDto(List<CheckIn> checkInList) {
		return checkInList.stream().map(checkIn -> toDto(checkIn)).toList();
	}

}
