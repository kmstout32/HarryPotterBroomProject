package com.skilldistery.app;

import java.util.Scanner;

import com.skilldistery.entities.Airfield;

public class JetsApp {
	private Airfield airf; // encapsulate

	public static void main(String[] args) {
// starts here
		JetsApp japp = new JetsApp();
		japp.launch();
	}

	public void launch() {
		boolean isTrue = true;
		Scanner sc = new Scanner(System.in);
		airf = new Airfield();
		while (isTrue) {
			isTrue = userInput(sc);
		}
		sc.close();
	}

	public void displayUserMenu() {
		System.out.println("--------------------------------------------");
		System.out.println(" Welcome to Diagon Alley's Broom Jet Museum ");
		System.out.println("    Choose from the following Menu Items:   ");
		System.out.println("************************************");
		System.out.println("1) List Fleet of Broom Jets\t   |" + "\n2) Fly all Broom Jets\t\t   |"
				+ "\n3) View Broom with the Fastest Jet |" + "\n4) View Broom with Longest Range   |"
				+ "\n5) Load all Cargo Broom\t\t   |" + "\n6) DogFight!\t\t\t   |" + "\n7) Add Broom to Fleet\t\t   |"
				+ "\n8) Remove Boom from Fleet\t   |" + "\n9) Quit\t\t\t\t   |");
		System.out.println("************************************");
		System.out.println("Enter your choice here: ");

	}

	public boolean userInput(Scanner sc) {
		displayUserMenu();
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			airf.listAllBrooms();
			break;
		case 2:
			airf.flyAllBrooms();
			break;
		case 3:
			airf.displayFastestJet();
			break;
		case 4:
			airf.longestRange();
			break;
		case 5:
			airf.loadBroom();
			break;
		case 6:
			airf.dogFight();
			break;
		case 7:
			airf.addBroomToFleet();
			break;
		case 8:
			airf.removeBroomFromList();
			break;
		case 9:
			System.out.println("Byeeeeeee!");
			return false;
		default:
			if (choice < 1 || choice > 9) {
				System.out.println("That's not an option. Try again!");
			}
			break;
		}
		return true;
	}
}
