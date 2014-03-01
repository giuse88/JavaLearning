package sorting.algorithms;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestInsertionSortAlgorithm {
	
	String className = getClass().getSimpleName();
	
	@Before
	public void setUp () {
		System.out.format("%s\t : Setting Up\n", className);
	}
	
	@After
	public void tearDown() {
		System.out.format("%s\t : Tear Down \n",className);
	}
	
	@Test 
	public void FirstTestInsertionSort(){
		System.out.println("Hello I am a Insertion Sort Test");
		return; 
	}
}
