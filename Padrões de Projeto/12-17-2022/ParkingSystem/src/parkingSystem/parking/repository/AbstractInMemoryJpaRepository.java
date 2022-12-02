package parkingSystem.parking.repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;

public abstract class AbstractInMemoryJpaRepository<TEntity extends Entity<TEntity, TId>, TId>
implements JpaRepository<Entity<TEntity,TId>, TId> 
{
	protected SortedMap<TId, TEntity> entityMap;
	
	protected AbstractInMemoryJpaRepository() {
		entityMap = Collections.synchronizedCollection(new TreeMap<>());
	}
	
	protected AbstractInMemoryJpaRepository(Map<TId, TEntity> entityMap) {
		this();
		this.entityMap.putAll(entityMap);
	}
	
	protected AbstractInMemoryJpaRepository(List<TEntity> enityList) {
		this();
		enityList.forEach(entity -> entityMap.put((TId) Entity.getId(), entity));
	}
	
	@Override
	public boolean existsById(TId id) {
		return entityMap.containsKey(id);
	}
	
	@Override
	public  Optional<TEntity> findAllById(Iterable<? extends TId> ids){
		TEntity entity = (TEntity) entityMap.get(ids);
		
		return (entity == null)? Optional.empty() : Optional.of(entity);
	}
	
	
	
	
	
}
