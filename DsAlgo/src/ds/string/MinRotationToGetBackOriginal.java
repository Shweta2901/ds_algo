package ds.string;
/*
 * Given a string 
 * find the minimum number of clockwise rotations 
 * required to get the same string back
 * 
 * eg: i/p: abcde  o/p : 5
 * 	i/p: aaaa  o/p : 1
 *  i/p: acac  o/p : 2
 *  i/p: ababd  o/p : 5
 *  i/p: a o/p: 1
 *  
 * */
public class MinRotationToGetBackOriginal {
		
	public static int getMinRotation(String str) {
		if(str==null || str.isEmpty() || str.length()==1)
			return 0;
		
		String temp=str+str;
		String temp1;
		for(int i=1;i<=str.length();i++) {
			temp1=temp.substring(i, i+str.length());
			if(temp1.equals(str))
				return i;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(MinRotationToGetBackOriginal.getMinRotation("abcdef"));
		System.out.println(MinRotationToGetBackOriginal.getMinRotation("acacac"));
		System.out.println(MinRotationToGetBackOriginal.getMinRotation("aaaa"));
		System.out.println(MinRotationToGetBackOriginal.getMinRotation("abcabc"));
		System.out.println(MinRotationToGetBackOriginal.getMinRotation("a"));
		System.out.println(MinRotationToGetBackOriginal.getMinRotation("ababd"));
		System.out.println(MinRotationToGetBackOriginal.getMinRotation("abab"));
		System.out.println(MinRotationToGetBackOriginal.getMinRotation("abcdabcd"));
	}
}
