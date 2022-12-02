package parkingSystem.parking.repository;

public interface Entity <T, TId> extends Cloneable{
	TId getId();
	T clone();
}
