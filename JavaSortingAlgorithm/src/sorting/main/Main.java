package sorting.main;
import java.util.Arrays;

import sorting.algorithms.QuickSort;
import sorting.interfaces.Sort;

public class Main {
	static public void main(String []  args) {
		System.out.println("Java Learning algorithm");
		
		Sort sorting = new QuickSort();

		System.out.println(sorting.sort(Arrays.asList(new Integer[] {4,8,1,3,0,9,1})));

	} 
}
