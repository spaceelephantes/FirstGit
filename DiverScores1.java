// Use an array to look at Diver Scores and etc.


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DiverScores1 {

	public static final int NUM_SCORES = 9;

	public static void main (String[] args) {

		//Input

		//Variables
		double scores[] = new double [NUM_SCORES];
		double minScore;
		double maxScore;
		double sumScores=0;
		double sumProduct=0;
		double degreeDiff;
		double totalScore = 0;
		int diveNumber = 0;
		boolean maxThere = false;
		boolean minThere = false;


		// Set up connection to file

		Scanner infile = null;

		try
		{
			infile = new Scanner (new File ("Diving.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error: Input file not found!");
			System.exit(0);
		}

		//Get degree of difficulty from file

		degreeDiff = infile.nextDouble();

		//Heading
		System.out.println("VWC Diving Results");


		while (degreeDiff != -1)
		{

			//Processing Dive
			diveNumber++;
			System.out.println("  -----------------");
			System.out.printf("      Dive #%2d (%4.2f) \n", diveNumber, degreeDiff);
			System.out.println("  -----------------");
			maxScore =.5;
			minScore = 10;
			for (int i=0; i<NUM_SCORES; i++)
			{
				scores[i] = infile.nextDouble();

				if (scores[i] > maxScore ) // && maxThere == false )
				{
						maxScore = scores[i];
				//	 	maxThere = true;
				}
				if (scores[i] < minScore )//&& minThere == false)
				{

					minScore = scores[i];
					minThere = true;
				}
				sumScores = (sumScores + scores[i]);

				//maxThere = true;
				//minThere = true;
			}

			//some calculations
			sumScores = sumScores - (maxScore + minScore);
			sumProduct = sumScores * degreeDiff;

			for ( int i=0; i<NUM_SCORES; i++)
			{
				if(minThere == false && maxThere == false)
				}
					if (scores[i] == maxScore || scores[i] == minScore)
						System.out.printf("    %4.2f *dropped*\n", scores[i]);
				}
				else
					System.out.printf("    %4.2f\n",  scores[i]);
			}

			System.out.println("-------------------------------------");
			System.out.printf(" The score for Dive # %2d is %4.2f \n", diveNumber, sumProduct);
			System.out.println("-------------------------------------");

			totalScore = sumProduct + totalScore;
			sumProduct = 0;
			sumScores = 0;


			//Get degree of difficulty from file

			degreeDiff = infile.nextDouble();
		}
		System.out.println("\n-------------------------------------------");
		System.out.printf(" The total score for %2d dives is : %4.2f\n", diveNumber, totalScore);
		System.out.println("-------------------------------------------");



	}
	}

