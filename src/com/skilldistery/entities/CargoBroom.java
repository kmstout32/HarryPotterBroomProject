package com.skilldistery.entities;

public class CargoBroom extends Jet implements CargoCarrier{
	public CargoBroom() {

	}
	public CargoBroom(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public void loadCargo() {
		System.out.println("Loading Broom " + this.getModel());

	}

	public void fly() {
	

	}
	

}
