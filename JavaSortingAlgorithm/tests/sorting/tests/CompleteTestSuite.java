package sorting.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import sorting.algorithms.TestInsertionSortAlgorithm;
import sorting.algorithms.TestQuickSortAlgorithm;


@RunWith(Suite.class)
@SuiteClasses({ 
	TestQuickSortAlgorithm.class, 
	TestInsertionSortAlgorithm.class
})

public class CompleteTestSuite {

	@BeforeClass 
	public static void setUpClass() {
		System.out.println("Master setup");
	}

	@AfterClass public static void tearDownClass() {
		System.out.println("Master tearDown");
	}

}