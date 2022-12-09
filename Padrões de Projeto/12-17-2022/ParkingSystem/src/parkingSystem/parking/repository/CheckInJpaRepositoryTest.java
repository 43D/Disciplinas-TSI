package parkingSystem.parking.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import parkingSystem.common.repository.Entity;
import parkingSystem.common.repository.JpaRepository;
import parkingSystem.parking.billing.BillingType;
import parkingSystem.parking.model.CheckIn;
import parkingSystem.parking.model.CheckInBuilder;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class CheckInJpaRepositoryTest
{
	List<CheckIn> checkInList;
	JpaRepository<CheckIn, Long> repository;
	
	void init()
	{
		CheckInBuilder builder = new CheckInBuilder();
		
		checkInList = new ArrayList<>();
		
		checkInList.add(builder
				.id(1)
				.billingType(BillingType.DAY_BILLING)
				.license("AXE8732")
				.model("Opala")
				.state("Pr")
				.color("Preta")
				.entry(LocalDateTime.now().minusHours(2))
				.build()
		);
		checkInList.add(builder
				.id(2)
				.billingType(BillingType.DAY_BILLING)
				.license("PAS8923")
				.model("Variant")
				.state("Sp")
				.color("Branca")
				.entry(LocalDateTime.now().minusHours(3))
				.build()
		);
		checkInList.add(builder
				.id(3)
				.billingType(BillingType.DAY_BILLING)
				.license("AXX9202").model("Del Rey")
				.state("Pr").color("Prata")
				.entry(LocalDateTime.now().minusHours(5))
				.build()
		);
	}
	
	//----------------------------------------------------------
	@Test
	@Order(1)
	void shouldInitTheRepositoryWithInitialEntities()
	{
		System.out.println(1);
		init();
		repository = new CheckInJpaRepository(checkInList);
	}
	
	//---------------------------------------------------------
	@Test
	@Order(2)
	void shouldCheckIfAnEntityExistis()
	{
		System.out.println(2);
		assertTrue(repository.existsById(1L));
		assertTrue(repository.existsById(2L));
		assertTrue(repository.existsById(3L));
	}
	
	//---------------------------------------------------------
	@Test
	@Order(3)
	void shouldFindById()
	{
		System.out.println(3);
		
		Optional<? extends Entity<CheckIn, Long>> opt;
		
		opt = repository.findById(1L);
		assertTrue(opt.isPresent());
		
		opt = repository.findById(2L);
		assertTrue(opt.isPresent());
		
		opt = repository.findById(3L);
		assertTrue(opt.isPresent());
	}
	
	//---------------------------------------------------------
	@Test
	@Order(4)
	void shouldFindAll()
	{
		System.out.println(4);
		
		List<CheckIn> list = repository.findAll().toList();
		
		int expectedSize = 3;
		assertTrue(expectedSize == list.size() );
		
		long expectedId = 1;
		assertTrue(expectedId == list.get(0).getId());
		
		expectedId = 2; 
		assertTrue(expectedId == list.get(1).getId());
		
		expectedId = 3;
		assertTrue(expectedId == list.get(2).getId());
	}
	
	//---------------------------------------------------------
	@Test
	@Order(5)
	void shouldFindAllById()
	{
		System.out.println(5);
		
		List<Long> ids = Arrays.asList(1L,3L);
		List<CheckIn> list = repository.findAllById(ids).toList();
		
		int expectedSize = 2;
		assertTrue(expectedSize == list.size() );
		
		long expectedId = 1;
		assertTrue(expectedId == list.get(0).getId());
		
		expectedId = 3; 
		assertTrue(expectedId == list.get(1).getId());
	}
	
	//---------------------------------------------------------
	@Test
	@Order(6)
	void shouldFilterByPredicate()
	{
		System.out.println(6);
		
		Predicate<CheckIn> predicate = (checkIn) -> (checkIn.getId() == 2);
		
		List<CheckIn> list = repository.filter(predicate).toList();
		
		int expectedSize = 1;
		assertTrue(expectedSize == list.size() );
		
		long expectedId = 2;
		assertTrue(expectedId == list.get(0).getId());
		
		
		predicate = (checkIn) -> (checkIn.getLicense().startsWith("A"));
		list = repository.filter(predicate).toList();
		
		expectedSize = 2;
		assertTrue(expectedSize == list.size() );
		
		expectedId = 1;
		assertTrue(expectedId == list.get(0).getId());
		
		expectedId = 3;
		assertTrue(expectedId == list.get(1).getId());
	}
	
	//----------------------------------------------------------
	@Test
	@Order(7)
	void shouldCountTheRepositoryEntities()
	{
		System.out.println(7);
		
		long expected = 3;
		long actual = repository.count();
		assertEquals(expected, actual);
	}
	
	//---------------------------------------------------------
	@Test
	@Order(8)
	void shouldDeleteById()
	{
		System.out.println(8);
		
		repository = new CheckInJpaRepository(checkInList);
		
		long expected = 3;
		long actual = repository.count();
		assertEquals(expected, actual);
		
		//--deleting id = 1
		repository.deleteById(1L);
		List<CheckIn> list = repository.findAll().toList();
		
		expected = 2;
		actual = repository.count();
		assertEquals(expected, actual);
		
		actual = list.size();
		assertEquals(expected, actual);
		
		expected = 2;
		actual = list.get(0).getId();
		assertEquals(expected, actual);
		
		expected = 3;
		actual = list.get(1).getId();
		assertEquals(expected, actual);
		
		//--deleting id = 2
		repository = new CheckInJpaRepository(checkInList);
		repository.deleteById(2L);
		list = repository.findAll().toList();
		
		expected = 2;
		actual = list.size();
		assertEquals(expected, actual);
		
		actual = repository.count();
		assertEquals(expected, actual);
				
		expected = 1;
		actual = list.get(0).getId();
		assertEquals(expected, actual);
		
		expected = 3;
		actual = list.get(1).getId();
		assertEquals(expected, actual);
		
		//--deleting id = 3
		repository = new CheckInJpaRepository(checkInList);
		repository.deleteById(3L);
		list = repository.findAll().toList();
		
		expected = 2;
		actual = repository.count();
		assertEquals(expected, actual);
		
		actual = list.size();
		assertEquals(expected, actual);
		
		expected = 1;
		actual = list.get(0).getId();
		assertEquals(expected, actual);
		
		expected = 2;
		actual = list.get(1).getId();
		assertEquals(expected, actual);
		
		//--deleting all one by one
		repository = new CheckInJpaRepository(checkInList);
		expected = 2;
		repository.deleteById(1L);
		actual = repository.count();
		assertEquals(expected, actual);
		
		expected = 1;
		repository.deleteById(3L);
		actual = repository.count();
		assertEquals(expected, actual);
		
		expected = 0;
		repository.deleteById(2L);
		actual = repository.count();
		assertEquals(expected, actual);
	}
	
	//---------------------------------------------------------
	@Test
	@Order(9)
	void shouldDeleteAllByIds()
	{
		System.out.println(9);
		
		repository = new CheckInJpaRepository(checkInList);
		
		List<Long> ids = Arrays.asList(1L,3L);
		
		Long expected = 1L;
		repository.deleteAllById(ids);
		Long actual = repository.count();
		assertEquals(expected, actual);
		
		expected = 2L;
		actual = repository.findAll().toList().get(0).getId();
		assertEquals(expected, actual);
	}
	
	//---------------------------------------------------------
	@Test
	@Order(10)
	void shouldDeleteAll()
	{
		System.out.println(10);
		
		repository = new CheckInJpaRepository(checkInList);
		repository.deleteAll();
		
		long expected = 0;
		long actual = repository.count();
		assertEquals(expected, actual);
	}
	
	//---------------------------------------------------------
	@Test
	@Order(11)
	void shouldSaveAnEntity()
	{
		System.out.println(11);
		
		repository = new CheckInJpaRepository(checkInList);
		
		Optional<? extends Entity<CheckIn, Long>> opt = repository.findById(2L);
		
		assertTrue(opt.isPresent());
			
		CheckIn checkIn = (CheckIn) opt.get();
		long expectedId = 2L;
		long actual = checkIn.getId();
		assertEquals(expectedId, actual);
		
		String expectedLicense = "AXC9999";
		checkIn.setLicense(new String(expectedLicense));
		checkIn = repository.save(checkIn);
		
		String actualLicense = checkIn.getLicense(); 
		assertEquals(expectedLicense, actualLicense);
		
		opt = repository.findById(2L);
		assertTrue(opt.isPresent());
		
		checkIn = (CheckIn) opt.get();
		actualLicense = checkIn.getLicense();
		assertEquals(expectedLicense, actualLicense);
	}
	
	//---------------------------------------------------------
	@Test
	@Order(12)
	void shouldSaveAllEntities()
	{
		System.out.println(12);
		
		repository = new CheckInJpaRepository();
		long expectedSize = 0L;
		long actualSize = repository.count();
		assertEquals(expectedSize, actualSize);
		
		repository.saveAll(checkInList);
		expectedSize = 3L;
		actualSize = repository.count();
		assertEquals(expectedSize, actualSize);
	}
	
}
