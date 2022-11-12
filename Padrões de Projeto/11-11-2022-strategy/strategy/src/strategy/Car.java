package strategy;

public class Car implements Comparable<Car>{
	private String licence;
	private String name;
	private String brand;
	private int year;
	private String color;

	// -------------------------------------------------------------
	public Car() {
	}

	// --------------------------------------
	public final String getLicence() {
		return licence;
	}

	// --------------------------------------
	public final void setLicence(String licence) {
		this.licence = licence;
	}

	// --------------------------------------
	public final String getName() {
		return name;
	}

	// --------------------------------------
	public final void setName(String name) {
		this.name = name;
	}

	// --------------------------------------
	public final String getBrand() {
		return brand;
	}

	// --------------------------------------
	public final void setBrand(String brand) {
		this.brand = brand;
	}

	// --------------------------------------
	public final int getYear() {
		return year;
	}

	// --------------------------------------
	public final void setYear(int year) {
		this.year = year;
	}

	// --------------------------------------
	public final String getColor() {
		return color;
	}

	// --------------------------------------
	public final void setColor(String color) {
		this.color = color;
	}

	// ------------------------------------------------
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("{ licence: ");
		sb.append(String.format("%-7s", this.licence));
		sb.append(", name: ");
		sb.append(String.format("%-10s",this.name));
		sb.append(", brand: ");
		sb.append(String.format("%-12s",this.brand));
		sb.append(", year: ");
		sb.append(String.format("%-5s",this.year));
		sb.append(", color: ");
		sb.append(String.format("%-9s",this.color));
		sb.append("}");

		return sb.toString();
	}

	@Override
	public int compareTo(Car car) {
		return (this.year - car.year);
	}
}
