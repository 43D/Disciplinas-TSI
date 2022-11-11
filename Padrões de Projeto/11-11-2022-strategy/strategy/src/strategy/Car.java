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
		sb.append(this.licence);
		sb.append(", name: ");
		sb.append(this.name);
		sb.append(", brand: ");
		sb.append(this.brand);
		sb.append(", year: ");
		sb.append(this.year);
		sb.append(", color: ");
		sb.append(this.color);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public int compareTo(Car car) {
		return (this.year - car.year);
	}
}
