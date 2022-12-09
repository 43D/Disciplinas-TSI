package parkingSystem.parking.repository;

import java.util.List;
import java.util.Map;

import parkingSystem.common.repository.AbstractInMemoryJpaRepository;
import parkingSystem.parking.model.CheckIn;

public class CheckInJpaRepository 
extends AbstractInMemoryJpaRepository<CheckIn, Long>
{
	//---------------------------------------------------------
	public CheckInJpaRepository()
	{
		super();
	}

	//---------------------------------------------------------
	public CheckInJpaRepository(List<CheckIn> entityList)
	{
		super(entityList);
	}
   
	//---------------------------------------------------------
	public CheckInJpaRepository(Map<Long, CheckIn> entityMap)
	{
		super(entityMap);
	}

	//---------------------------------------------------------
	static private 
    long id=0;

	//---------------------------------------------------------
	@Override
	public CheckIn save(CheckIn entity) 
	{
		if(entity.getId() == null)
			entity.setId(++id);
		
		return super.save(entity);
	}
	
	//---------------------------------------------------------
	public static void main(String[] args)
	{
		/*
		
		
		String lineSeparator = "\n-----------------------------------------------------------\n";
		System.out.println(lineSeparator);
		
		repository.findAll().forEach(System.out::println);
		
		System.out.println(lineSeparator);
		Optional<?> optional = repository.findById(2L);
		if(optional.isPresent())
		{
			CheckIn ck = (CheckIn) optional.get();
			System.out.println(ck);
			repository.deleteById(ck.getId());
		}
		
		System.out.println(lineSeparator);
		repository.findAll().forEach(System.out::println);
		
		repository.save(builder
				.id(2)
				.billingType(BillingType.DAY_BILLING)
				.license("XXX9102").model("Monza ")
				.state("Pr").color("Prata")
				.entry(LocalDateTime.now().minusHours(5))
				.build());
		
		System.out.println(lineSeparator);
		repository.findAll().forEach(System.out::println);
		
		System.out.println(lineSeparator);
		*/
	}
}
