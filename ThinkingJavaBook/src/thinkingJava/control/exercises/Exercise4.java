package thinkingJava.control.exercises;

public class Exercise4 {

	public static void main(String[] args) {
		for (int i=2;i<100;i++) {
			for (int j=2;j<=i;j++) {
				if ( i == j )
					System.out.println("Prime number " + i );
				if ( (i%j) == 0  )
					break;
			}
		}
	}
}
