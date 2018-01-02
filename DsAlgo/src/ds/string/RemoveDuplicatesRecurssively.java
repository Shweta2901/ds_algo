package ds.string;

public class RemoveDuplicatesRecurssively {

	public String removeDuplicates(String str) {
		if(str==null || str.isEmpty())
			return "";
		if(str.length()==1)
			return str;
		int p=0;
		int q=1;
		int count=0;
		
		while(p<str.length()) {
			if(q==str.length() || str.charAt(p)!= str.charAt(q)) {
				if(count>0) {
					if(q==str.length()) {
						if(p==0) //to handle case like aaa
							str="";
						else //to handle case like abbb
							str=str.substring(0, p);
					} else {
						str=str.substring(0, p)+str.substring(q);
						p=(p>0)?p-1:0; //To handle case like dddqb
						q=p+1;
						count=0;
					}
				} else {
					p++;
					q++;
				}
			} else {
				count++;
				q++;
			}
		}
		return str;
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesRecurssively testObject=new RemoveDuplicatesRecurssively();
		System.out.println(testObject.removeDuplicates(""));
		System.out.println(testObject.removeDuplicates("aaa"));
		System.out.println(testObject.removeDuplicates("azxxzy"));
		System.out.println(testObject.removeDuplicates("geeksforgeeg"));
		System.out.println(testObject.removeDuplicates("caaabbbaacdddd"));
		System.out.println(testObject.removeDuplicates("acaaabbbacdddd"));
		System.out.println(testObject.removeDuplicates("caaabbbaac"));
		System.out.println(testObject.removeDuplicates("aaaacddddcappp"));
		System.out.println(testObject.removeDuplicates("aaaaaaaaaa"));
		System.out.println(testObject.removeDuplicates("qpaaaaadaaaaadprq"));
		System.out.println(testObject.removeDuplicates("acaaabbbacdddd"));
		System.out.println(testObject.removeDuplicates("mississipie"));
	}
}
