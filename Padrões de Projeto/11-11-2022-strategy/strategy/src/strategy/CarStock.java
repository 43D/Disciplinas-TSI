package strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CarStock implements Stock<Car> {
	private final List<Car> carList;

	// ----------------------------------------------
	public CarStock() {
		carList = new ArrayList<>();
	}

	// ----------------------------------------------
	public CarStock(List<Car> carList) {
		this();
		this.carList.addAll(carList);
	}

	// ----------------------------------------------
	public final void add(Car car) {
		carList.add(car);
	}

	// ----------------------------------------------
	public final void remove(Car car) {
		carList.remove(car);
	}

	// ----------------------------------------------
	public final boolean contains(Car car) {
		return carList.contains(car);
	}

	public final List<Car> getAll() {
		return carList;
	}

	public final Stream<Car> stream() {
		return carList.stream();
	}
	
	
}
