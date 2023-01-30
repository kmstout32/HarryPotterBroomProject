package com.skilldistery.entities;

import java.util.Objects;

public abstract class Jet  {
	protected String name;
	protected String model;
	protected double speed;
	protected int range; 
	protected long price; 
	protected double speedInMach;
	//Jet constructor with String, double, int, and long in parameters
	public Jet() {}
	public Jet(String name, String model , double speed, int range, long price) {
		this.name = name;
		this.model = model; 
		this.speed = speed;
		this.range = range; 
		this.price = price;
		
	
	}
	//All planes fly
	public abstract void fly();
	@Override
	public String toString() {
		return "Category: " + name + " Model: " + model + ", Speed: " + speed
				+ ", Range: " + range + ", Price: " + price ;
		
	}
	public double getSpeedInMach(double mach) {
		speedInMach = Math.round((speed * 0.001303)* 100) /100;
		return speedInMach;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(model, price, range, speed, speedInMach);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		return Objects.equals(model, other.model) && price == other.price && range == other.range
				&& Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed)
				&& Objects.equals(speedInMach, other.speedInMach);
	}
	
}
