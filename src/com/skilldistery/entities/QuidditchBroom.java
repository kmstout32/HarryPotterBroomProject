package com.skilldistery.entities;

public class QuidditchBroom extends Jet{

	public QuidditchBroom() {
		
	}
	
	public QuidditchBroom(String name, String model, double speed, int range, long price ) {
		super(name, model, speed, range, price);
	}
	public void playQuidditch() {
		System.out.println( this.getModel() + " is debuting it's first Quidditch match, ridden by H. Potter!");
	}

	public void fly() {
	
		
	}

}
