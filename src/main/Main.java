package main;

import java.util.Scanner;

import PhoneOrientationML.*;

public class Main {

	public static void main(String[] args) {

		// Instantiate a new classifier object
		NNClassifier classifier = new NNClassifier(); // Classifier used in the program

		// First, train the classifier with data
		classifier.trainDataOption("resources/testingData1.txt");

		// Then, predict unknown data
		classifier.unknownDataOption("resources/unknownData1.txt");

		// Now, take input from the user
		Scanner inputScanner = new Scanner(System.in);
		boolean continueLoop = true;

		while (continueLoop) { // Keep looping until they exit...
			double newXCoord = 0;
			double newYCoord = 0;
			double newZCoord = 0;

			try { // Use try-catch in case of weird input
				String input;
				System.out.println("Please enter an X coordinate: ");
				input = inputScanner.nextLine();
				if ("q".equals(input)) { // Check if they want to exit
					continueLoop = false;
					break;
				}
				newXCoord = Double.parseDouble(input);

				System.out.println("Please enter a Y coordinate: ");
				input = inputScanner.nextLine();
				if ("q".equals(input)) { // Check if they want to exit
					continueLoop = false;
					break;
				}
				newYCoord = Double.parseDouble(input);

				System.out.println("Please enter a Z coordinate: ");
				input = inputScanner.nextLine();
				if ("q".equals(input)) { // Check if they want to exit
					continueLoop = false;
					break;
				}
				newZCoord = Double.parseDouble(input);

			} catch (java.lang.NumberFormatException error) {
				System.out.println("Incorrect input, please try again\n\n");
			}

			System.out.println("\n");

			Point userPoint = new Point(newXCoord, newYCoord, newZCoord); // Create a point from user input

			// Predict and print output
			int outputPrediction = classifier.predict(userPoint);
			String orientation = new String();
			if (1 == outputPrediction) {
				orientation = "Face Up";
			} else if (2 == outputPrediction) {
				orientation = "Face Down";
			} else if (3 == outputPrediction) {
				orientation = "Portrait";
			} else if (4 == outputPrediction) {
				orientation = "Portrait, Upside Down";
			} else if (5 == outputPrediction) {
				orientation = "Landscape Left";
			} else if (6 == outputPrediction) {
				orientation = "Landscape Right";
			} else {
				orientation = "Unknown";
			}

			System.out.println("Phone Orientation = " + outputPrediction + "," + orientation +"\n");
		}
		// Close scanner after no more inputs are needed
		inputScanner.close();
	}
}
