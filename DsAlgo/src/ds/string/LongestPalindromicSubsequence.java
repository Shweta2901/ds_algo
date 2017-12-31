package ds.string;

public class LongestPalindromicSubsequence {

	public int lpslength(String str,int start,int end) {
		if(str==null || str.isEmpty())
			return 0;
		//every string of length 1 is always palindromic
		if(start==end)
			return 1;
		//when we are left with string of length 2 and if both characters are same
		//then length of palindromic string becomes 2
		if(str.charAt(start)==str.charAt(end) && (end-start == 1))
			return 2;
		//if last and first character of a string are same, then they are present in palindrome
		//subsequence, so length of subsenquence will be 2+ lps(i+1,j-1)
		if(str.charAt(start)==str.charAt(end))
			return 2+lpslength(str,start+1,end-1);
		//if last and first characters are not same then length of palindrome sunsequence will be
		// maximum of lps(i+1,j),lps(i,j-1)
		return Math.max(lpslength(str,start,end-1), lpslength(str,start+1,end));
	}
	public static void main(String[] args) {
		LongestPalindromicSubsequence testObject=new LongestPalindromicSubsequence();
		System.out.println(testObject.lpslength("acbdba", 0, 5));
		System.out.println(testObject.lpslength("a", 0, 0));
		System.out.println(testObject.lpslength("aa", 0, 1));
		System.out.println(testObject.lpslength("aaaaa", 0, 4));
		System.out.println(testObject.lpslength("", 0, 0));
		System.out.println(testObject.lpslength("geeksforgeeks", 0, 12));
	}
}
