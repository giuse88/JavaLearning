package thinkingJava.chapter3;

public class ShowProperties {

	static public void  printJavaProperties() {
		// Prints out all the system property 
		System.getProperties().list(System.out);
		System.out.println("The current user is : " +
							System.getProperty("user.name"));
		System.out.println("The current library path is : " +
							System.getProperty("java.library.path"));
	}
}
