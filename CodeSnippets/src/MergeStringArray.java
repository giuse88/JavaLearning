import java.util.ArrayList;
import java.util.List;

public class MergeStringArray {

	static public String[] mergeTwo(String[] a, String[] b) {
		List<String> mergedArray = new ArrayList<String>();
		String [] shortArray = (a.length > b.length) ? b : a;  
		String [] longArray  = (a.length > b.length) ? a : b;
		int j=0,i=0;
		
		for (; i< shortArray.length && j < longArray.length; ) {
			int comparision = shortArray[i].compareTo(longArray[j]);
			if (comparision > 0 ) {
				mergedArray.add(longArray[j]);
				j++;
			} else if ( comparision < 0) {
				mergedArray.add(shortArray[i]);
				i++;
			} else {
				mergedArray.add(shortArray[j]);
				j++;
				i++;
			}
		}

		// copy the remainder of the long array
		for ( int index=j; index < longArray.length; index++)
			mergedArray.add(longArray[index]);
		
		for ( int index=i; index < shortArray.length; index++)
			mergedArray.add(shortArray[index]);

		return mergedArray.toArray(new String[mergedArray.size()]);
		
		}
	
	static public int[] mergeIntArray(int[] a, int[] b) {
		
		int [] merged = new int[a.length + b.length];
		int i=0; // used to go through a; 
		int j=0; // used to go through b;
		int m=0;
		
		// exiting condition 
		while(i<a.length && j< b.length) {
			//
			if (a[i] < b[j]) {
				merged[m] = a[i]; 
				i++;
			} else if (a[i] > b[j]) {
				merged[m]= b[j];
				j++;
			}else {
				merged[m]=a[i];
				i++; j++;
			}
			//
			m++;
		}
		
		for ( int index =i; index< a.length; index++, m++)
			merged[m] =a[index]; 
		
		for ( int index =j; index< b.length; index++, m++)
			merged[m] =b[index]; 

		return merged;
	}

	
	
	public int commonTwo(String[] a, String[] b) {
		
		String []  shortArray = a.length > b.length ? b:a;
		String []  longArray  = a.length > b.length ? a:b;
	
		int i=0, j=0, counter=0; 

		while ( i < shortArray.length && j < longArray.length) {
			int comparision = shortArray[i].compareTo(longArray[j]);
			if (comparision == 0) {
				counter++; 
				i++; j++;
				//skip the same strings
				for (; i<shortArray.length && shortArray[i-1].equals(shortArray[i]); i++); 
				for (; j<longArray.length && longArray[j-1].equals(longArray[j]); j++);
			}else if ( comparision < 0) {
				i++;
			}else {
				j++;
			}
		}
		
		return counter;
	}

	public static void main(String[] args) {
		
		String [] a = {"a", "c", "e", "g", "t", "z"};
		String [] b = {"b", "d", "f", "h", "u"};
		
		for ( String str : mergeTwo(a, b))
			System.out.println(str);
		
		int [] ai = {1,3,5,7,8,11};
		int [] bi = {2,4,6,9,34};

		for ( int integer : mergeIntArray(ai, bi))
			System.out.println(integer);
	}

}
