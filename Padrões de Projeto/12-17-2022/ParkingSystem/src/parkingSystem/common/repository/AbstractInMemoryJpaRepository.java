package parkingSystem.common.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class 
AbstractInMemoryJpaRepository<TEntity extends Entity<TEntity, TId>, TId> 
   implements JpaRepository<TEntity, TId>
{
	protected SortedMap<TId, TEntity> entityMap;
	
	//-------------------------------------------------------------------------
	public AbstractInMemoryJpaRepository()
	{
		entityMap = Collections.synchronizedSortedMap(new TreeMap<>());
	}
	
	//-------------------------------------------------------------------------
	public AbstractInMemoryJpaRepository(Map<TId, TEntity> entityMap) 
	{
		this();
		this.entityMap.putAll(entityMap);
	}
	
	//-------------------------------------------------------------------------
	public AbstractInMemoryJpaRepository(List<TEntity> entityList)
	{
		this();
		entityList.forEach(entity -> entityMap.put(entity.getId(), entity));
	}
	
	//-------------------------------------------------------------------------
	@Override
	public boolean existsById(TId id) 
	{
		return entityMap.containsKey(id);
	}

	//-------------------------------------------------------------------------
	@Override
	public Optional<TEntity> findById(TId id) 
	{
		TEntity entity = (TEntity) entityMap.get(id);
		
		return (entity == null) ? Optional.empty() : Optional.of(entity.clone());
	}

	//-------------------------------------------------------------------------
	@Override
	public Stream<TEntity> findAll() 
	{
		return entityMap
			.values()
			.stream()
			.map(entity -> entity.clone());
	}

	//-------------------------------------------------------------------------
	@Override
	public Stream<TEntity> findAllById(Iterable<? extends TId> ids) 
	{
		List<TEntity> list = new ArrayList<>();
		
		ids.forEach(id -> list.add(entityMap.get(id)));
		
		return list.stream()
		   .filter(entity -> entity != null)
		   .map(entity -> entity.clone());
	}
	
	//-------------------------------------------------------------------------
	@Override
	public Stream<TEntity> filter(Predicate<TEntity> predicate) 
	{
		return entityMap
			.values()
			.stream()
		   .filter(predicate)
		   .map(entity -> entity.clone());
	}

	//-------------------------------------------------------------------------
	@Override
	public long count()
	{
		return entityMap.size();
	}

	//-------------------------------------------------------------------------
	@Override
	public void deleteById(TId id) 
	{
		entityMap.remove(id);
	}

	//-------------------------------------------------------------------------
	@Override
	public void deleteAllById(Iterable<? extends TId> ids) 
	{
		ids.forEach( entityMap::remove );
	}

	//-------------------------------------------------------------------------
	@Override
	public void deleteAll()
	{
		entityMap.clear();
	}

	//-------------------------------------------------------------------------
	static private 
	Executor executor = Executors.newSingleThreadScheduledExecutor();
	
	//-------------------------------------------------------------------------
	@Override
	public void deleteAllByIdInBatch(Iterable<? extends TId> ids) 
	{
		executor.execute( ( ) -> deleteAllById(ids) );
	}

	//-------------------------------------------------------------------------
	@Override
	public void deleteAllInBatch()
	{
		executor.execute( ( ) -> deleteAll() );
	}

	//-------------------------------------------------------------------------
	@Override
	public TEntity save(TEntity entity)
	{
		entityMap.put(entity.getId(), entity);
		
		return entity;
	}

	//-------------------------------------------------------------------------
	@Override
	public List<TEntity> saveAll(Iterable<TEntity> entities) 
	{
		List<TEntity> list = new ArrayList<>();
		
		entities.forEach( entity -> list.add( save(entity) ) );
		
		return list;
	}
}
