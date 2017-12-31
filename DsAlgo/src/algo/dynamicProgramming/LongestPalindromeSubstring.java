package algo.dynamicProgramming;

public class LongestPalindromeSubstring {
	
	public int lps(String str) {
		if(str==null || str.isEmpty())
			return 0;
		int n=str.length();
		boolean[][] l=new boolean[n][n];
		
		//substrings with length 1 are always palindrome
		int substring=1;
		for(int i=0;i<n;i++)
			l[i][i]=true;
		
		for(int len=2;len<=n;len++) {
			for(int i=0;i<=n-len;i++) {
				int j=i+len-1;
				if(str.charAt(i)==str.charAt(j)) {
					if(len==2) {
						l[i][j]=true;
						substring=2;
					} else if(l[i+1][j-1]) {
						l[i][j]=true;
						if(substring<len)
							substring = len;
					  }
				}
			}
	    }
		return substring;
	}
	public static void main(String[] args) {
		LongestPalindromeSubstring testObject=new LongestPalindromeSubstring();
		System.out.println(":"+testObject.lps(""));
		System.out.println("a:"+testObject.lps("a"));
		System.out.println("aa:"+testObject.lps("aa"));
		System.out.println("aaa:"+testObject.lps("aaa"));
		System.out.println("baa:"+testObject.lps("baa"));
		System.out.println("aba:"+testObject.lps("aba"));
		System.out.println("abcd:"+testObject.lps("abcd"));
		System.out.println("xabababay:"+testObject.lps("xabababay"));
		System.out.println("xabababayaa:"+testObject.lps("xabababayaa"));
	}

}
