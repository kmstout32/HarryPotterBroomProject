package com.skilldistery.entities;

public class FighterBroom extends Jet implements CombatReady{
	public FighterBroom() {
	
	}
	
	public FighterBroom(String model, double speed, int range, long price ) {
		super(model, speed, range, price);
	}
	

	@Override
	public void fly() {
		
		
	}

	@Override
	public void fight() {
		System.out.println(" Ready for combat" + this.getModel());
	}
}
