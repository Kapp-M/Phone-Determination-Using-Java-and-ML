package PhoneOrientationML;

/**
 * Points structure / class for the classifier to simplify things
 * @author Kalp-Rudra-Girish-Jiya
 *
 */
public class Point {

	/**
	 * Values for a 3d point, plus orientation and distance for predicted / known
	 */
	private double xCoord;
	private double yCoord;
	private double zCoord;
	private int orientation;
	private double distance;

	/**
	 * Default constructor zero values data
	 */
	public Point() {
		this.xCoord = 0;
		this.yCoord = 0;
		this.zCoord = 0;
		this.orientation = 0;
		this.distance = 0;
	}

	/**
	 * Parameterized constructor for unknown
	 * 
	 * @param xCoord - input value for X plane
	 * @param yCoord - input value for Y plane
	 * @param zCoord - input value for Z plane
	 */
	public Point(double xCoord, double yCoord, double zCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.zCoord = zCoord;
		this.orientation = 0;
		this.distance = 0;
	}

	/**
	 * Parameterized constructor for known
	 * 
	 * @param xCoord - input value for X plane
	 * @param yCoord - input value for Y plane
	 * @param zCoord - input value for Z plane
	 */
	public Point(double xCoord, double yCoord, double zCoord, int orientation) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.zCoord = zCoord;
		this.orientation = orientation;
		this.distance = 0;
	}

	/**
	 * Get X plane for point
	 * 
	 * @return value for X plane
	 */
	public double getxVal() {
		return xCoord;
	}

	/**
	 * Set X plane for point
	 * 
	 * @param xCoord - new X value for point
	 */
	public void setxVal(double xCoord) {
		this.xCoord = xCoord;
	}

	/**
	 * Get Y plane for point
	 * 
	 * @return value for Y plane
	 */
	public double getyVal() {
		return yCoord;
	}

	/**
	 * Set Y plane for point
	 * 
	 * @param yCoord - new Y value for point
	 */
	public void setyVal(double yCoord) {
		this.yCoord = yCoord;
	}

	/**
	 * Get Y plane for point
	 * 
	 * @return value for Y plane
	 */
	public double getzVal() {
		return zCoord;
	}

	/**
	 * Set Z plane for point
	 * 
	 * @param zCoord - new Z value for point
	 */
	public void setzVal(double zCoord) {
		this.zCoord = zCoord;
	}

	/**
	 * Get known orientation for point
	 * 
	 * @return integer representation for orientation
	 */
	public int getOrientation() {
		return orientation;
	}

	/**
	 * Set known orientation for point
	 * 
	 * @param orientation - input new orientation for point
	 */
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	/**
	 * Get known relative distance for point
	 * 
	 * @return double representation for distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * Set known distance for point
	 * 
	 * @param distance - input new relative distance for point
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}
}
