package thinkingJava.chapter3.exercises;

public class Exercise1 {

	int thisIsANumber; 
	char thisIsAchar; 
	
	public void excerse1() {
		int localVariable = 0; 
		// the fields should be automatically initialized to zero k
		System.out.println("======== Exercise 1 ========");
		System.out.println("Number	: This should be zero " + thisIsANumber);
		System.out.println("Char	: This should be zero too " + thisIsAchar);
		System.out.println("Java does not allow not initialized variables  : "
							+ localVariable );
		System.out.println("============================");
	}
}
