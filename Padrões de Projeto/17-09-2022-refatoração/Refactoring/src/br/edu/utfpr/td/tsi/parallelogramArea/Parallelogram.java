package br.edu.utfpr.td.tsi.parallelogramArea;

public class Parallelogram {
	private float base;
	private float height;
	
	public Parallelogram() {
	}
	
	public Parallelogram(float base, float height) {
		this.base = Math.abs(base);
		this.height = Math.abs(height);
	}

	public float getBase() {
		return base;
	}

	public void setBase(float base) {
		this.base = Math.abs(base);
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = Math.abs(height);
	}

	public float getArea() {
		return this.base * this.height;
	}
}
