package algo.dynamicProgramming;

public class LongestPalindromeSubsequence {
	
	public int lps(String str) {
		if(str==null || str.isEmpty())
			return 0;
		
		int n=str.length();
		int[][] l=new int[n][n];
		//we will fill top diagonal part of the matrix 
		//we will consider strings of different lengths while filling up the matrix
		
		//all strings of length 1 are always palindromic
		//so length of longest palindromic subsequence possible given one character is always 1
		for(int i=0;i<n;i++)
			l[i][i]=1;
		
		//fill matrix for larger length
		for(int len=2;len<=n;len++) {
			for(int i=0;i<=n-len;i++) {
				    int j=i+len-1;
					//if last and first characters are same
					//lps= 2+ lps(i-1,j-1)
					if(str.charAt(i)==str.charAt(j)) {
						//if string is of length 2 then max length possible is 2
						if(len==2)
							l[i][j]=2;
						else
							l[i][j]=l[i+1][j-1]+2;
					} else {
						//if last and first characters are not same
						//lps= max(lps(i-1,j),lps(i,j-1))
						l[i][j]= Math.max(l[i+1][j], l[i][j-1]);
					}
			}
		}
		return l[0][n-1];
	}

	public static void main(String[] args) {
		LongestPalindromeSubsequence testObject=new LongestPalindromeSubsequence();
		System.out.println(testObject.lps("aa"));
		System.out.println(testObject.lps(""));
		System.out.println(testObject.lps("aba"));
		System.out.println(testObject.lps("abbgbba"));
		System.out.println(testObject.lps("abcdefg"));
		System.out.println(testObject.lps("acbdba"));
		System.out.println(testObject.lps("geeksforgeeks"));
		System.out.println(testObject.lps("aaaaaaa"));
	}
}
