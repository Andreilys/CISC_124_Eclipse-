/*
 * This is a class that you may use to test the
 * operation of your IO helper class.  It assumes that the class is
 * called IOHelper, but you can use another name for your helper class
 * and just carry out a "search and replace" in this program.
 */
public class TestIOHelper {

	private static void testIntInput () {
		int low = -100;
		int high = 200;
		int num;
		// Full parameter getInt
		String prompt = "Please supply a number between " + low + " and " + high + ": ";
		num = IOHelper.getInt(low, prompt, high);
		System.out.println("Obtained: " + num);
		// Two parameter getInt
		low = 400;
		prompt = "Please supply a number above " + low + ": ";
		num = IOHelper.getInt(low, prompt);
		System.out.println("Obtained: " + num);
		// The other two parameter getInt
		high = 500;
		prompt = "Please supply a number below " + high + ": ";
		num = IOHelper.getInt(prompt, high);
		System.out.println("Obtained: " + num);
		// The one parameter getInt
		prompt = "Please supply a number: ";
		num = IOHelper.getInt(prompt);
		System.out.println("Obtained: " + num);
		// The no parameter getInt
		num = IOHelper.getInt();
		System.out.println("Obtained: " + num);		
	} // end testIntInput method
	
	private static void testDoubleInput () {
		double low = -100;
		double high = 200;
		double num;
		// The three parameter getDouble
		String prompt = "Please supply a number between " + low + " and " + high + ": ";
		num = IOHelper.getDouble(low, prompt, high);
		System.out.println("Obtained: " + num);
		// The two parameter getDouble
		low = 400;
		prompt = "Please supply a number above " + low + ": ";
		num = IOHelper.getDouble(low, prompt);
		System.out.println("Obtained: " + num);
		// The other two parameter getDouble
		high = 500;
		prompt = "Please supply a number below " + high + ": ";
		num = IOHelper.getDouble(prompt, high);
		System.out.println("Obtained: " + num);
		// The one parameter getDouble
		prompt = "Please supply a number: ";
		num = IOHelper.getDouble(prompt);
		System.out.println("Obtained: " + num);
		// The no parameter getDouble
		num = IOHelper.getDouble();
		System.out.println("Obtained: " + num);		
	} // end testDoubleInput method

	public static void testStringInput() {
		String testOne = IOHelper.getString("Enter a string: ");
		String testTwo = IOHelper.getString("Enter another string: ");
		System.out.println("You provided:\n" + testOne + "\n" + testTwo);		
	} // end testStringInput method
	
	public static void main(String[] args) {
		testIntInput();
		testDoubleInput();
		testStringInput();
		System.out.println("\nAll done testing!");
	} // end main

} // end TestIOHelper