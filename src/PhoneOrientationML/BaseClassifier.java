package PhoneOrientationML;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class BaseClassifier {

	/**
	 * Training for the ML before predictions can occur
	 * 
	 * @param filePath - name of file with known data / knowledge base
	 */
	public abstract void train(String filePath);

	/**
	 * Predict given the inputed point
	 * 
	 * @param inputPoint - input unknown point
	 * @return integer value associated with orientation
	 */
	public abstract int predict(Point inputPoint);
	
	//Functions for training and running on unknown data for any children of BaseClassifier...

	/**
	 * function to train classifier, notifies upon completion
	 * 
	 * @param filePath - path of the file containing training data
	 */
	public void trainDataOption(String filePath) {
		this.train(filePath);
		System.out.println("Training Complete...\n");
	}

	/**
	 * function for the unknown data file, prints out predictions
	 * 
	 * @param filePath - path of the file containing unknown data
	 */
	public void unknownDataOption(String filePath) {
		try {
			File inputFile = new File(filePath);
			Scanner fileReader = new Scanner(inputFile);

			while (fileReader.hasNextLine()) {	// Keep reading lines until end of file
				String data = fileReader.nextLine();
				System.out.println("data: " + data);
				String[] splitData = data.split(",");	// Split on comma into an array of 3

				double newXCoord = Double.parseDouble(splitData[0]);	// Parse inputs
				double newYCoord = Double.parseDouble(splitData[1]);
				double newZCoord = Double.parseDouble(splitData[2]);
				Point newPoint = new Point(newXCoord, newYCoord, newZCoord);
				
				int predictedOrientation = this.predict(newPoint);	// Predict given point from unknown file
				
				System.out.printf("Predicted Orientation: %d\n\n", predictedOrientation);
			}

			fileReader.close();

		} catch (FileNotFoundException error) {	// In case file doesn't exist
			System.out.println("File Not Found Error.");
			error.printStackTrace();
		}
	}
}
