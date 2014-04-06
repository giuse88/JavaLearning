package thinkingJava.control;

public class LabeledFor {

	public static void main (String[] args) {
		int i =0; 
		outer : // can't have statements here Java Label 
		for (;true;) { // infine loop
			inner : // can't have statements here Java Label 
				for (; i<10; i++) {
					System.out.println("i = " + i );
					if ( i == 2 ) {
						System.out.println("Continue");
						continue;
					}
					if ( i == 3 ) {
						System.out.println("Break");
						i++;	// if not incremented it would cause an infinite 
								// loop
						break;	//  this breaks the inner loop 
					}
					if ( i == 7 ) {
						System.out.println("Continue outher");
						i++; // same as the previous case 
						continue outer; // jumps at the outer label  
					}
					if( i == 8 ) {
						System.out.println("Break outer");
						break outer; 
					}
					for ( int k=0; k<5; k++)
						if ( k==3 ) {
							System.out.println("Continue inner");
							continue inner; 
						}
				}
		}
	}
}
