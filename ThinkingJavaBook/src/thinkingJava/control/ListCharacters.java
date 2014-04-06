package thinkingJava.control;

public class ListCharacters {

	public static void main(String[] args) {
		for ( char c=0; c < 128; c++)
			if (Character.isLowerCase(c))
				System.out.format("Value : %d character : %c \n", 
						new Integer(c), c);
	}
}