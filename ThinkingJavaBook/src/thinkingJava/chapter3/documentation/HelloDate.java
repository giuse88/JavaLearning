package thinkingJava.chapter3.documentation;

import java.util.Calendar;

/** 
 * The first Thinking in Java example program. 
 * @author Giuseppe
 * @author www.test.it
 * @version 4.0 
 *
 */
public class HelloDate {

	/** Entry point to class & application. 
	 * @param args array of string arguments (Ignored) . 
	 * @throws exceptions No exceptions thrown 
	 */
	
	public static void helloDate(String args[]) {
		System.out.println("Hello, it's : " + Calendar.getInstance().getTime());
	}

}
