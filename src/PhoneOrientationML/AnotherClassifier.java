package PhoneOrientationML;

/**
 * Basic classifier with only print function name instead of implementation
 * @author Kalp-Rudra-Girish-Jiya
 *
 */
public class AnotherClassifier extends BaseClassifier {

	public void train(String filePath) {
		System.out.println("public void train(String filePath)");
	}

	public int predict(Point inputPoint) {
		System.out.println("public int predict(Point inputPoint)");
		return 1;
	}

}
