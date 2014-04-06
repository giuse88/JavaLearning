package thinkingJava.control.exercises;

public class Exercise9 {

	static void fibonacci( int howMany) {
		
		int a =1, b =1; 
		for ( int i =0, tmp = 0; i< howMany ; i++ ) {
			System.out.println(b);
			tmp=b;
			b +=a; 
			a=tmp;
		}
	}
	
	
	public static void main(String[] args) {
		
		//if( args.length <= 1)
		//	System.exit(0);
		//Integer howMany = Integer.parseInt("10");

		fibonacci(10);
	}

}
