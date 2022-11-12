package strategy;

import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class App {
	private final Stock<Car> carStock;

	// ---------------------------------------------------
	public App(Stock<Car> stock) {
		carStock = stock;
	}

	// ---------------------------------------------------
	public final void printAllCars() {
		carStock.stream().forEach(System.out::println);
	}

	public final void printAllCarsOrderedByYear() {
		carStock.stream().sorted(((carA, carB) -> (carA.getYear() - carB.getYear()))).forEach(System.out::println);
	}

	public final void printAllCarsOrderedByBrand() {
		carStock.stream().sorted(((carA, carB) -> (carA.getBrand().compareToIgnoreCase(carB.getBrand()))))
				.forEach(System.out::println);
	}

	public final void printAllCarsOrderedByLicence() {
		carStock.stream().sorted(((carA, carB) -> (carA.getLicence().compareToIgnoreCase(carB.getLicence()))))
				.forEach(System.out::println);
	}

	public final void printAllCarsOrdered(Comparator<? super Car> comparator) {
		carStock.stream().sorted(comparator).forEach(System.out::println);
	}

	// ---------------------------------------------------

	public final void printAllCarsByFilter(Predicate<? super Car> predicate) {
		carStock.stream().filter(predicate).forEach(System.out::println);
	}

	public final void printAllCarsByBrand(String brand) {
		carStock.stream().filter((car -> brand.equalsIgnoreCase(car.getBrand()))).forEach(System.out::println);
	}

	public final void printAllCarsByYear(int year) {
		carStock.stream().filter((car -> (year == car.getYear()))).forEach(System.out::println);
	}

	public final void printAllCarsByLicence(String licence) {
		carStock.stream().filter((car -> licence.equalsIgnoreCase(car.getLicence()))).forEach(System.out::println);
	}

	public final void printAllOldCars(int yearsOld) {
		carStock.stream().filter((car -> (yearsOld <= (Year.now().getValue() - car.getYear()))))
				.forEach(System.out::println);
	}

	public final void printAllOldCarsOrderedByYear(int yearsOld) {
		carStock.stream().filter((car -> (yearsOld <= (Year.now().getValue() - car.getYear()))))
				.sorted(((carA, carB) -> (carA.getYear() - carB.getYear()))).forEach(System.out::println);
	}

	public final void printAllNewerCars(int year) {
		carStock.stream().filter((car -> (year >= (Year.now().getValue() - car.getYear()))))
				.forEach(System.out::println);
	}

	// ---------------------------------------------------
	static public void main(String[] args) {
		Stock<Car> stock = new CarStock(carList);
		App app = new App(stock);

		app.printAllOldCarsOrderedByYear(15);
	}

	// --------------------------------------------------------------------------------------------------------------------//
	static final List<Car> carList = new ArrayList<>();

	static {
		CarBuilder builder = new CarBuilder();

		carList.add(builder.licence("AXB1234").name("Fusca").brand("Wolkswagen").year(1975).color("Amarela").build());
		carList.add(builder.licence("AVC7362").name("Gol").brand("Wolkswagen").year(1980).color("Verde").build());
		carList.add(builder.licence("KWI3829").name("Polo").brand("Wolkswagen").year(2022).color("Prata").build());
		carList.add(builder.licence("KHJ4273").name("Jetta").brand("Wolkswagen").year(2010).color("Preta").build());
		carList.add(builder.licence("AUI8090").name("Voyage").brand("Wolkswagen").year(2006).color("Prata").build());
		carList.add(builder.licence("LLS3920").name("Monza").brand("Chevrolet").year(1982).color("Prata").build());
		carList.add(builder.licence("HAK8292").name("Cruze").brand("Chevrolet").year(2015).color("Preta").build());
		carList.add(builder.licence("KJS3822").name("Tracker").brand("Chevrolet").year(2017).color("Branca").build());
		carList.add(builder.licence("ABD7237").name("Spin").brand("Chevrolet").year(2019).color("Azul").build());
		carList.add(builder.licence("XPT8499").name("Onix").brand("Chevrolet").year(2020).color("Vermelha").build());
		carList.add(builder.licence("YIW3728").name("Argo").brand("Fiat").year(2020).color("Vermelha").build());
		carList.add(builder.licence("YAG3129").name("Mobi").brand("Fiat").year(2021).color("Prata").build());
		carList.add(builder.licence("JHA8349").name("Fiat 147").brand("Fiat").year(1981).color("Branca").build());
		carList.add(builder.licence("KAR8312").name("Siena").brand("Fiat").year(2001).color("Preta").build());
		carList.add(builder.licence("AAN8992").name("Cronos").brand("Fiat").year(2021).color("Vermelha").build());
	};
}
