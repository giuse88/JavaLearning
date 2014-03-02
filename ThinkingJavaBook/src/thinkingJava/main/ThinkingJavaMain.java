package thinkingJava.main;

import thinkingJava.chapter3.ShowProperties;
import thinkingJava.chapter3.exercises.Exercise1;

public class ThinkingJavaMain {

	public static void main(String[] args) {
		System.out.println("Thinkin Java Application");
	
		System.out.println(" ******* Chapter 3  *********");

		// Page 80 Java Properties 
		ShowProperties.printJavaProperties();

		// Exercises : 
		Exercise1 exercise = new Exercise1(); 
		exercise.excerse1();

		System.out.println(" ***************************");
	}

}
