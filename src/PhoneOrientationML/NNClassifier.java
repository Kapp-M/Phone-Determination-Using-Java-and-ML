package PhoneOrientationML;

import java.util.*;
import java.io.*;

public class NNClassifier extends BaseClassifier {

	/**
	 * Knowledge base for ML "known points"
	 */
	ArrayList<Point> dataPoints;

	/**
	 * Constructor for NNClassifier, allocates array list
	 */
	public NNClassifier() {
		this.dataPoints = new ArrayList<Point>();
	}

	public void train(String filePath) {
		try {
			File inputFile = new File(filePath);
			Scanner fileReader = new Scanner(inputFile);

			while (fileReader.hasNextLine()) {
				String data = fileReader.nextLine();
//				System.out.println("data: " + data);
				String[] splitData = data.split(",");	// Split on comma into an array of 3

				double newXCoord = Double.parseDouble(splitData[0]);	// Parse inputs
				double newYCoord = Double.parseDouble(splitData[1]);
				double newZCoord = Double.parseDouble(splitData[2]);
				int newOrientation = Integer.parseInt(splitData[3]);

				Point newPoint = new Point(newXCoord, newYCoord, newZCoord, newOrientation);
//				System.out.printf("X: %f, Y: %f, Z: %f, Orientation: %d\n", newXCoord, newYCoord, newZCoord, newOrientation);
				this.dataPoints.add(newPoint);
			}

			fileReader.close();

		} catch (FileNotFoundException error) {
			System.out.println("File Not Found Error.");
			error.printStackTrace();
		}
	}

	/**
	 * Get point and compare to all in set
	 * @param inputPoint
	 */
	private void calculateDistances(Point inputPoint) {
		for (Point currentPoint : this.dataPoints) {
			currentPoint.setDistance(Math.sqrt(Math.pow((currentPoint.getxVal() - inputPoint.getxVal()), 2)
					+ Math.pow((currentPoint.getyVal() - inputPoint.getyVal()), 2)
					+ Math.pow((currentPoint.getzVal() - inputPoint.getzVal()), 2)));
//			System.out.printf("distance: %f\n", currentPoint.distance);
		}
	}

	/**
	 * Sort points for predict function and compare to each other by overriding comparator operator
	 */
	private class SortPoints implements Comparator<Point> {

		@Override
		public int compare(Point a, Point b) {
			return Double.compare(a.getDistance(), b.getDistance());	// Use built-in compare for two doubles
		}

	}

	public int predict(Point inputPoint) {

		this.calculateDistances(inputPoint);
		Collections.sort(this.dataPoints, new SortPoints());
//		for(Point currentPoint:this.dataPoints) {
//			System.out.printf("sortedDistance: %f\n",currentPoint.distance);
//		}
		inputPoint.setOrientation(this.dataPoints.get(0).getOrientation());
		return inputPoint.getOrientation();
	}
	
}
