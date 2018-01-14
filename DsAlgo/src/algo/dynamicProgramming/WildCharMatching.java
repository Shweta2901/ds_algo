package algo.dynamicProgramming;

/**
 * 
 * Given a text and a wildcard pattern, implement wildcard pattern matching algorithm that finds if wildcard pattern is matched with text. The matching should cover the entire text (not partial text).
 * The wildcard pattern can include the characters ‘?’ and ‘*’
 * ‘?’ – matches any single character
 * ‘*’ – Matches any sequence of characters (including the empty sequence)
 * For example,
 * 
 * Text = "baaabab",
 * Pattern = “*****ba*****ab", output : true
 * Pattern = "baaa?ab", output : true
 * Pattern = "ba*a?", output : true
 * Pattern = "a*ab", output : false 
 * 
 * */

public class WildCharMatching {
	
	public static boolean matchWildChar(String text,String pattern) {
		if(pattern.length()==0 || pattern.isEmpty() || (text==null || text.isEmpty() && (pattern!=null || !pattern.isEmpty() && pattern.charAt(0)!='*')))
			return false;
		
		if(pattern == null && text==null)
			return true;
		
		//combine adjacent * in the pattern
		/*int k=1;
		 * 
		while(pattern.charAt(k)!='\0')
		 {
			if(pattern.charAt(k)=='*' && pattern.charAt(k)=='*') {
				pattern=pattern.substring(0, k)+pattern.substring(k+1);
			}
			k++;
		}*/
		
		boolean[][] result= new boolean[text.length()+1][pattern.length()+1];
		
		//for text as null and pattern as null, it is a match
		result[0][0]=true;
		
		//if pattern is null, it is "No Match" for any text
		for(int i=1;i<=text.length();i++)
			result[i][0]=false;
		
		//if text is null
		for(int j=1;j<=pattern.length();j++) {
			if(pattern.charAt(j-1)=='*')
				result[0][j]=result[0][j-1];
			else
				result[0][j]=false;
		}
		//for rest of the result
		for(int i=1;i<text.length()+1;i++) {
			for(int j=1;j<pattern.length()+1;j++) {
				if(pattern.charAt(j-1)=='*') {
					result[i][j]=result[i-1][j] || result[i][j-1];
				} else if(pattern.charAt(j-1)=='?' || pattern.charAt(j-1)==text.charAt(i-1)) {
					result[i][j]=result[i-1][j-1];
				} else {
					result[i][j]=false;
				}
			}
		}
		return result[text.length()][pattern.length()];
	}

	public static void main(String[] args) {
		System.out.println(WildCharMatching.matchWildChar("baaabab", "*****ba*****ab"));
		System.out.println(WildCharMatching.matchWildChar("baaabab", "ba*****ab"));
		System.out.println(WildCharMatching.matchWildChar("baaabab", "ba*ab"));
		System.out.println(WildCharMatching.matchWildChar("baaabab", "a*ab"));
		System.out.println(WildCharMatching.matchWildChar("baaabab", "a*****ab"));
		System.out.println(WildCharMatching.matchWildChar("baaabab", "*a*****ab"));
		System.out.println(WildCharMatching.matchWildChar("baaabab", "ba*ab****"));
		System.out.println(WildCharMatching.matchWildChar("baaabab", "****"));
		System.out.println(WildCharMatching.matchWildChar("baaabab", "*"));
		System.out.println(WildCharMatching.matchWildChar("baaabab", "aa?ab"));
		System.out.println(WildCharMatching.matchWildChar("baaabab", "b*b"));
		System.out.println(WildCharMatching.matchWildChar("baaabab", "a*a"));
		System.out.println(WildCharMatching.matchWildChar("baaabab", "baaabab"));
		System.out.println(WildCharMatching.matchWildChar("baaabab", "?baaabab"));
		System.out.println(WildCharMatching.matchWildChar("baaabab", "*baaaba*"));
	}
}
