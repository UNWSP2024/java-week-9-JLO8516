package week9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FacialRecognition {
	static Scanner userinput = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "C:\\Users\\chomp\\Downloads\\Facial rec.txt";
		
		File measurements = new File(fileName);
		Scanner file = new Scanner(measurements);

		double [][] measure;
		measure = new double[6][6];
		String[] name;
		name = new String[6];

		double [][] ratio;
		ratio = new double [6][15];
		double [] sum;
		sum = new double [5];
		int person;
		int i,x,y;
		
		
		for(x=0; x<=4; x++) {
			name[x] = file.nextLine();
			System.out.println(name[x]);
			for(y=0; y<=5; y++) {
				measure[x][y] = Double.parseDouble(file.nextLine());
				System.out.println(measure[x][y]);
			}
		}
		
		
		for (i = 0; i<= 5; i++) {
			System.out.print("Enter mystery person's measurement " + i + ": ");
			measure[5][i] = userinput.nextDouble();
			userinput.nextLine();
		}
	
		
		for (person = 0; person <= 5; person++) {
			ratio[person][0] = measure[person][0] / measure [person][1];
			ratio[person][1] = measure[person][0] / measure [person][2];
			ratio[person][2] = measure[person][0] / measure [person][3];
			ratio[person][3] = measure[person][0] / measure [person][4];
			ratio[person][4] = measure[person][0] / measure [person][5];
			ratio[person][5] = measure[person][1] / measure [person][2];
			ratio[person][6] = measure[person][1] / measure [person][3];
			ratio[person][7] = measure[person][1] / measure [person][4];
			ratio[person][8] = measure[person][1] / measure [person][5];
			ratio[person][9] = measure[person][2] / measure [person][3];
			ratio[person][10] = measure[person][2] / measure [person][4];
			ratio[person][11] = measure[person][2] / measure [person][5];
			ratio[person][12] = measure[person][3] / measure [person][4];
			ratio[person][13] = measure[person][3] / measure [person][5];
			ratio[person][14] = measure[person][4] / measure [person][5];
		}
		for(person = 0; person<=4; person++) {
			for(i=0;i<=14;i++) {
				sum[person] += Math.pow(((ratio[5][i] - ratio[person][i])/ratio[person][i]), 2);
			}
		}
		
		double small = 10000;
		
		for(person = 0; person<=4; person++) {
			if(sum[person] < small) {
				small = sum[person];
			}
		}
		
		for(person = 0; person<=4; person++) {
			if(small==sum[person]) {
				System.out.println("The mystery person is " + name[person] + ".");
			}
		}
		
		
	
	}

}
