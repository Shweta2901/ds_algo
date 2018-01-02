package ds.string;

public class LongestSubstringWithoutRepeatingChar {
	
	public static final int NO_OF_CHARS=256;
	public int longestSubstringWithoutDuplicates(String str) {
		if(str == null || str.isEmpty())
			return 0;
		if(str.length()==1)
			return 1;
		int n = str.length();
        int curLen = 1;    // length of current substring
        int maxLen = 1;    // result
        int preIndex;        //  previous index
        int visited[] = new int[NO_OF_CHARS];
        for(int j=0;j<NO_OF_CHARS;j++)
        	visited[j]=-1;
        
        visited[str.charAt(0)]=0;
		for(int i=1;i<n;i++) {
			preIndex=visited[str.charAt(i)];
			
			if(preIndex==-1 || (i-curLen)>preIndex) {
				curLen++;
			} else {
				if(maxLen<curLen)
					maxLen=curLen;
				curLen=i-preIndex;
			}
			visited[str.charAt(i)]=i;
		}
		if(maxLen<curLen)
			maxLen=curLen;
		return maxLen;
	}
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingChar testObj=new LongestSubstringWithoutRepeatingChar();
		System.out.println(testObj.longestSubstringWithoutDuplicates(""));
		System.out.println(testObj.longestSubstringWithoutDuplicates("a"));
		System.out.println(testObj.longestSubstringWithoutDuplicates("aaaaaa"));
		System.out.println(testObj.longestSubstringWithoutDuplicates("abababa"));
		System.out.println(testObj.longestSubstringWithoutDuplicates("abcdefga"));
		System.out.println(testObj.longestSubstringWithoutDuplicates("geeksforgeeks"));
		System.out.println(testObj.longestSubstringWithoutDuplicates("ABDEFGABEF"));
		System.out.println(testObj.longestSubstringWithoutDuplicates("aabb"));
		System.out.println(testObj.longestSubstringWithoutDuplicates("aacbddd"));
	}
}
