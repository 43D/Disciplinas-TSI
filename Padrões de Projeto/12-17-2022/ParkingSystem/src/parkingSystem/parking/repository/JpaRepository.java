package parkingSystem.parking.repository;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface JpaRepository<TEntity extends Entity<TEntity, TId>, TId> {
	boolean existsById(TId id);

	Stream<TEntity> findAll();
	Stream<TEntity> findAllById(Iterable<? extends TId> ids);
	Stream<TEntity> filter(Predicate<TEntity> predicate);

	long count();

	void deleteById(TId id);
	void deleteAllById(Iterable<? extends TId> ids);
	void deleteAll();

	void deleteAllByIdInBatch(Iterable<? extends TId> ids);
	void deleteAllInBatch();

	TEntity save(TEntity entity);

	List<TEntity> saveAll(Iterable<TEntity> entities);
}
