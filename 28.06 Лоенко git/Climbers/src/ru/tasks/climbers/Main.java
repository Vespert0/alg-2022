package ru.tasks.climbers;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Number of climbers: ");
		int rockClimberCount = scanner.nextInt();
		RockClimber[] rockClimbers = new RockClimber[rockClimberCount];
		int maxHeight;
		int dropHeight;
		int routeLenght;
		for (int i = 0; i < rockClimberCount; i++) {
			System.out.printf("Climber [%d]:\n", i + 1);
			System.out.print("Max height: ");
			maxHeight = scanner.nextInt();
			System.out.print("Drop Height: ");
			dropHeight = scanner.nextInt();
			System.out.print("Route Length: ");
			routeLenght = scanner.nextInt();
			rockClimbers[i] = new RockClimber(maxHeight, dropHeight, routeLenght);
		}
		System.out.println("Climbers' Route: ");
		for (int i = 0; i < rockClimberCount; i++) {
			System.out.printf("\nClimber [%d]:\n", i + 1);
			rockClimbers[i].renderRoute();
		}
	}
}