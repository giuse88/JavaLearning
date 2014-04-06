package thinkingJava.control.exercises;

public class Exercise10 {

	private static boolean isVampire(int n ) {
		// todo 
		return false;
	}
	
	
	public static void main(String[] args) {

		for ( int i=1000; i< 10000; i++) {
			if ( isVampire(i))
			System.out.println(i);
		}
	}

}
