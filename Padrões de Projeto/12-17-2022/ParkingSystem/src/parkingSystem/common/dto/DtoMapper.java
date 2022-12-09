package parkingSystem.common.dto;

import java.util.List;

public interface DtoMapper <T, TDto> {
	T fromDto(TDto dto);
	TDto toDto (T obj);
	
	List<T> fromDto(List<TDto> list);
	List<TDto> toDto(List<T> list);
	
}
