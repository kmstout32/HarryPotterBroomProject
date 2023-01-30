package com.skilldistery.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Airfield {
	private List<Jet> jets;
	Scanner sc = new Scanner(System.in);

	public void displayFastestJet() {
		Jet fastestJet = jets.get(0);
		for (int i = 0; i < jets.size(); i++) {
			if (jets.get(i).getSpeed() > fastestJet.getSpeed()) {
				fastestJet = jets.get(i);
			}
		}
		System.out.println("fastest jet :" + fastestJet);
	}

	public void addBroomToFleet() {
		String nameEntered;
		String modelEntered;
		double speedEntered;
		int rangeEntered;
		long priceEntered;

		System.out.println("............................");
		System.out.println("Enter name of your broom: ");
		nameEntered = sc.nextLine();
		System.out.println("Enter model of your broom: ");
		modelEntered = sc.nextLine();
		System.out.println("Enter speed of your broom: ");
		speedEntered = sc.nextDouble();
		System.out.println("Enter range of your broom: ");
		rangeEntered = sc.nextInt();
		System.out.println("Enter price of your broom: ");
		priceEntered = sc.nextLong();
		Jet UserBroom = new JetImpl(nameEntered, modelEntered, speedEntered, rangeEntered, priceEntered);
		jets.add(UserBroom);
		System.out.println("Broom added to list successfuly!");
		System.out.println("View list to see your broom in list");
		System.out.println("------------------------------------");

	}

	public void removeBroomFromList() {
		System.out.println("System loading broom removal...");
		System.out.println("Type in the name of the broom you would like to remove");
		for (Jet jet : jets) {
			int index = jets.indexOf(jet);
			System.out.println(index + ": " + jet.getModel());
		}
		int choice = sc.nextInt();
		jets.remove(choice);

	}

// This method retrieves the list off all brooms
	public void listAllBrooms() {
		for (Jet jet : jets) {
			System.out.println(jet);
			System.out.println(" ");
		}
	}

// This method flies all brooms
	public void flyAllBrooms() {
		for (Jet jet : jets) {
			System.out.println(jet.getModel() + " taking off in 3...2..1..");
			System.out.println(" ");
		}
	}

//This method iterates though this arraylist to find the broom with the longest flying range.
	public void longestRange() {
		Jet longestRange = jets.get(0);
		for (int i = 0; i < jets.size(); i++) {
			if (jets.get(i).getRange() > longestRange.getRange()) {
				longestRange = jets.get(i);
			}
		}
		System.out.println("The jet with the longest range of flytime :\n" + " " + longestRange);

	}

	public Airfield() {
		this.jets = readListOfJet("jets.txt");
	}

//This method reads the text file and adds it into the list array
	public List<Jet> readListOfJet(String fileName) {
		List<Jet> jets = new ArrayList<>();
		// read list into file
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				Jet jet = null;
				String[] jetsRecord = line.split(",");
				String name = jetsRecord[0];
				String model = jetsRecord[1];
				double speed = Double.parseDouble(jetsRecord[2]);
				int range = Integer.parseInt(jetsRecord[3]);
				long price = Long.parseLong(jetsRecord[4]);
				// if - figure out where each jet belongs
				if (name.equalsIgnoreCase("FighterBroom")) {
					jet = new FighterBroom(name,  model, speed, range, price);
				} else if (name.equalsIgnoreCase("PassengerBroom")) {
					jet = new PassengerBroom(name, model, speed, range, price);
				} else if (name.equalsIgnoreCase("CargoBroom")) {
					jet = new CargoBroom(name, model, speed, range, price);
				} else if (name.equalsIgnoreCase("QuidditchBroom")) {
					jet = new QuidditchBroom(name, model, speed, range, price);
				}

				jets.add(jet);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return jets;
	}

//This method loads all cargo broom (Starting point with one cargo broom)
	public void loadBroom() {
		for (Jet jet : jets) {
			if (jet instanceof CargoCarrier) {
				((CargoCarrier) jet).loadCargo();
				break;
			}
		}
	}
	public void playQuidditch() {
		for (Jet jet : jets) {
			if (jet instanceof playQuid) {
				((CargoCarrier) jet).loadCargo();
				break;
			}
		}
	}

//This method calls all the fighter brooms
	public void dogFight() {
		for (Jet jet : jets) {
			if (jet instanceof CombatReady) {
				((CombatReady) jet).fight();
				break;
			}
		}
	}

	public List<Jet> getJets() {
		return jets;
	}

	public void setJets(List<Jet> jets) {
		this.jets = jets;
	}

}
