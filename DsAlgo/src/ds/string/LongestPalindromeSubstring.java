package ds.string;

public class LongestPalindromeSubstring {
	int substringlength;
	public void lpslength(String str,int start,int end,int length) {
		if(str==null || str.isEmpty()) {
			substringlength=0;
			return;
		}
		if(start>=end) {
			if(substringlength<(length+1))
				substringlength=length+1;
			return;
		}
			
		if(str.charAt(start)==str.charAt(end)) {
			if(end==(start+1)) {
				if(substringlength<(length+2))
					substringlength=length+2;
				return;
			}
			lpslength(str,start+1,end-1,length+2);
			return;
		}
		lpslength(str,start+1,end,0);
		lpslength(str,start,end-1,0);
		return;
	}

	public static void main(String[] args) {
		LongestPalindromeSubstring testObject=new LongestPalindromeSubstring();
		testObject.substringlength=0;
		testObject.lpslength("baaaa", 0, 4, 0);
		System.out.println(testObject.substringlength);
		
		testObject.substringlength=0;
		testObject.lpslength("aa", 0, 1, 0);
		System.out.println(testObject.substringlength);
		
		testObject.substringlength=0;
		testObject.lpslength("", 0, 0, 0);
		System.out.println(testObject.substringlength);
		
		testObject.substringlength=0;
		testObject.lpslength("aba", 0, 2, 0);
		System.out.println(testObject.substringlength);
		
		testObject.substringlength=0;
		testObject.lpslength("forgeeksskeegfor", 0, 15, 0);
		System.out.println(testObject.substringlength);
		
	}
}
