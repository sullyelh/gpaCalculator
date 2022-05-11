package gpaCalculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// GPA = points / credits (4.0 / 1)
		// points = grade value * credits
		// A = 4, B = 3, C = 2, D = 1, F = 0
		
		Scanner scanner = new Scanner(System.in);
		
		int totalPoints = 0;
		int totalCredits = 0;
		
		boolean moreClasses = false;
		
		do {
		
		int credits = 0;
		boolean validCredits = true;
		do {
			validCredits = true;
			
			System.out.println("Enter number of credits:");
			String creditsString = scanner.nextLine();
			
			try {	
				credits = Integer.parseInt(creditsString);
				validCredits =true;
			}
			catch (NumberFormatException nfe) {
			System.out.println("Please enter a valid integer");
			}
		}
		while(!validCredits);
		
		boolean validGrade = true;
		String grade = "";
		int gradeValue = 0;
		
	do {
		System.out.println("Enter grade:");
		grade = scanner.nextLine();
		validGrade = true;
		if (grade.equalsIgnoreCase("A")) {
			gradeValue = 4;
		} else if (grade.equalsIgnoreCase("B")) {
			gradeValue = 3;
		} else if (grade.equalsIgnoreCase("C")) {
			gradeValue = 2;
		} else if (grade.equalsIgnoreCase("D")) {
			gradeValue = 1;
		} else if (grade.equalsIgnoreCase("F")) {
			gradeValue = 0;
		} else {
			System.out.println("Please input a valid entry (A, B, C, D).");
			validGrade = false;
		}
	}
	while(!validGrade);
	
	int points = gradeValue * credits;
	
	totalPoints = totalPoints + points; //totalPoints += points
	totalCredits = totalCredits + credits; //same as above
	
	System.out.println("Would you like to enter anohter class?");
	String moreClassesString = scanner.nextLine();
	
	moreClasses = moreClassesString.equalsIgnoreCase("Y");
	
		}	
		while(moreClasses);
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		double gpa = Double.valueOf(totalPoints) / Double.valueOf(totalCredits);
		
		System.out.println("Credits:" +totalCredits);
		System.out.println("Points:" +totalPoints);
		System.out.println("GPA:" +df.format(gpa));

	}

}
