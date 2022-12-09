package parkingSystem.common.repository;

public interface Entity<T, TId> extends Cloneable
{
	TId getId();
	
	T clone();
}
