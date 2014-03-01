package sorting.algorithms;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestQuickSortAlgorithm {

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
	public void testQuickSortPartinioningFunction(){
		// QuickSort sort = new QuickSort();
		// package visible method
		//sort.partition(k, begin, end)
		System.out.println("Hello I am a quick Sort Algorithm test" );
	}
}
