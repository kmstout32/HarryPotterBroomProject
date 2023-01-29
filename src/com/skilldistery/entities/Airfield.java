package com.skilldistery.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistery.app.JetsApp;

public class Airfield {
	private List<Jet> jets;

	public void displayFastestJet() {
		Jet fastestJet = jets.get(0);
		for(int i = 0; i < jets.size(); i++) {
			if(jets.get(i).getSpeed()> fastestJet.getSpeed()) {
				fastestJet = jets.get(i);
			}
		}
		System.out.println("fastest jet :" + fastestJet);
		
	}

	public void listAllJets() {
		for (Jet jet : jets) {
			System.out.println(jet);
		}
	}

	public void flyAllJets() {
		for (Jet jet : jets) {
			System.out.println(jet.getModel() + " taking off in 3...2..1..");
		}
	}

	public void longestRange() {
		Jet longestRange = jets.get(0);
		for(int i = 0; i < jets.size(); i++) {
			if(jets.get(i).getRange()> longestRange.getRange()) {
				longestRange = jets.get(i);
			}
		}
		System.out.println("The jet with the longest range of flytime :\n"
				+ " " + longestRange);
		
	}

	public Airfield() {
		this.jets = readListOfJet("jets.txt");
	}

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
					jet = new FighterBroom(model, speed, range, price);
				} else if (name.equalsIgnoreCase("PassengerBroom")) {
					jet = new PassengerBroom(model, speed, range, price);
				} else if (name.equalsIgnoreCase("CargoBroom")) {
					jet = new CargoBroom(model, speed, range, price);
				} else if (name.equalsIgnoreCase("QuidditchBroom")) {
					jet = new QuidditchBroom(model, speed, range, price);
				}

				jets.add(jet);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return jets;
	}

	public void loadBroom() {

	}

	public List<Jet> getJets() {
		return jets;
	}

	public void setJets(List<Jet> jets) {
		this.jets = jets;
	}

}
