package week9;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import java.io.FileNotFoundException;
import java.io.File;

public class NumericalAnalysis {

	public static void main(String[] args) throws FileNotFoundException {

		String fileName = "C:\\Users\\chomp\\Downloads\\java decimal file.txt";

		File numbers = new File(fileName);
		Scanner file = new Scanner(numbers);

		List<Double> list = new ArrayList<>();
		int qNumbers = 0;
		double total = 0;
		double avg = 0;
		double lNumber = 0;
		double sNumber = 100000;
		double nextNum = 0.0;

		while (file.hasNextLine()) {
			String test = file.nextLine();
			test = test.trim();
			nextNum = Double.parseDouble(test);
			total = total + nextNum;

			qNumbers++;

			list.add(nextNum);

			// tracks largest number
			if (nextNum > lNumber) {
				lNumber = nextNum;
			}
			// tracks smallest number
			if (nextNum < sNumber) {
				sNumber = nextNum;
			}

		}

		file.close();
		
		avg = total / qNumbers;
		list.sort(null);
		
		System.out.println("There are " + qNumbers + " numbers in the file.");
		System.out.printf("The average of the numbers is %.2f.", avg);
		System.out.println("\nThe largest number is " + lNumber + ".");
		System.out.println("The smallest number is " + sNumber + ".");
		System.out.println("The range of the data is: " + list);
	}
}
