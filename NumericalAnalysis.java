package week9;

import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.File;

public class NumericalAnalysis {

	public static void main(String[] args) throws FileNotFoundException {

		String fileName = "C:\\Users\\chomp\\Downloads\\java number file.txt";

		File numbers = new File(fileName);
		Scanner file = new Scanner(numbers);

		int qNumbers = 0;
		double total=0;
		double avg = 0;
		double lNumber = 0;
		double sNumber = 0;
		double nextNum = 0;
		

		while (file.hasNextLine()) {
			nextNum = file.nextDouble();
			total = total + nextNum;
			qNumbers++;

			

			
		}
		System.out.println(qNumbers);
		System.out.println(total);
		file.close();			
	}
}
