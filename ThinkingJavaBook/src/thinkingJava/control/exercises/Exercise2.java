package thinkingJava.control.exercises;

import java.util.Random;

public class Exercise2 {

	private static final int VALUES = 25;
	private static final Random RANDOM = new Random();

	public static void main(String[] args) {
		
		for ( int i = 0; i < VALUES/2; i++ ) {
			int first =  RANDOM.nextInt(100), 
				second = RANDOM.nextInt(100);
			System.out.println(i+": " + first + " is " + 
						(first > second ? "bigger/equal " : "smaller ") +
						"than " + second);	
		}
	}
}
