
public class FindAllOccurencesOfASubStringInAString {

	static public int findAll(String str, String findStr) {

		if (str == null || str.isEmpty() || 
			findStr == null || findStr.isEmpty() || 
			findStr.length() > str.length())
			return 0; 
	
		int count = 0; 
		int index =0; 
		
		while( (index=str.indexOf(findStr, index)) > -1 ) {
			count++; 
			index++;
		}
		
		return count; 
	}
	
	static public int last2(String str) {
		if ( str == null || str.length() < 2)
			return 0; 
		
		String end = str.substring(str.length()-2, str.length()); 
		int index = 0, count=0; 
		
		while( (index = str.indexOf(end, index)) > -1 && 
				index < str.length() -2){
			count++;
			index += 1;
		}
		return count;
		}
	
	static public void printAllSubstringOfLength(String str, int length){
		for( int i=0; i<= str.length() -length; i++)
			System.out.println(str.substring(i, i+length));
	}
	
	static public int stringMatch(String a, String b) {
		if ( a.length() < 2 || b.length() < 2 ) 
			return 0;
	
		int count = 0;
		
		for (int i=0; i <= a.length()-2 ; i++){
			String sub = a.substring(i, i+2); 
			int indexA = a.indexOf(sub, i);
			int indexB = b.indexOf(sub,i);
	
			System.out.println("sub : " + sub + " a:" + indexA + " b: " +indexB);
		
			if ( indexA == indexB ) 
				count ++;
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(findAll("xxxxxx", "xx"));
		printAllSubstringOfLength("abcd", 1);
		System.out.println(last2("hixxxxhi"));
		System.out.println(last2("hihi"));
		System.out.println(last2("xxxx"));
		stringMatch("aabbccdd", "abbbxxd");
	}
}
