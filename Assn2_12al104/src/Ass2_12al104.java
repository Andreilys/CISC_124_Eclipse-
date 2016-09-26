import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Ass2_12al104 {

	public static Scanner fileRead(String fileName){
		File file = new File(fileName);
		try {
			Scanner inputStream = new Scanner(file);
			return inputStream;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//TODO fix this?
		return null;
	}
	
	

	
	public static void main(String[] args) {
		//TODO how to put this into the eclipse folder?
		String fileName = "/Users/andreilyskov/Logger.csv";
		Scanner inputStream = fileRead(fileName);
		while (inputStream.hasNext()){
			String data = inputStream.next();
			System.out.println(data);
		}
		
		
	}
}