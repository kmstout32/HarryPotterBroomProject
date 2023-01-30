package com.skilldistery.entities;

public class FighterBroom extends Jet implements CombatReady{
	public FighterBroom() {
	
	}
	
	public FighterBroom(String name, String model, double speed, int range, long price ) {
		super(name, model, speed, range, price);
	}
	

	@Override
	public void fly() {
		
		
	}

	@Override
	public void fight() {
		System.out.println("Valdemort is in sight " + this.getModel() + " Ready for combat");
		System.out.println( "Taking off...");
		
	}
}
