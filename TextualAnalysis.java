package week9;

import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.File;

public class TextualAnalysis {

	public static void main(String[] args) throws FileNotFoundException {

		String fileName = "C:\\Users\\chomp\\Downloads\\College Essay.txt";

		File essay = new File(fileName);
		Scanner file = new Scanner(essay);

		String l;
		int words = 0;
		int sentences = 0;
		int letters = 0;
		int[] counter = new int[26];

		while (file.hasNextLine()) {
			words++;
			l = file.nextLine();
			l = l.trim();

			for (int j = 0; j < l.length(); j++) {

				// Word count
				if ((l.charAt(j) == ' ') && (l.charAt(j + 1) != ' ')) {
					words++;
				}
				// Sentence count
				if ((l.charAt(j) == '.') || (l.charAt(j) == '?') || (l.charAt(j) == '!')) {
					sentences++;
				}

				// counts individual letters
				int ascii = (int) (l.charAt(j));
				if ((ascii >= 97) && (ascii <= 122)) {
					counter[ascii - 97]++;
				}
				if ((ascii >= 65) && (ascii <= 90)) {
					counter[ascii - 65]++;
				}
			}
		}

		file.close();

		// total letter count
		for (int j = 0; j <= 25; j++) {
			letters += counter[j];
		}
		
		//average # of letters per word
		double avgLetters;
		avgLetters = (double)letters/(double)words;
		
		//average # of words per sentence
		double avgWords;
		avgWords= (double)words/(double)sentences;
		

		System.out.println("There are " + words + " words in this document.");
		System.out.println("There are " + letters + " letters in this document.");
		System.out.println("There are " + sentences + " sentences in this document.");
		System.out.printf("There are an average of %.2f letters per word.", avgLetters);
		System.out.printf("\nThere are an average of %.2f words per sentence.", avgWords);
		
		System.out.println("\nProgram ending ...");

	}

}
