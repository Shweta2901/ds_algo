package ds.string;

public class AtoI {
	
	public static int atoi(String str) {
		if(str==null || str.isEmpty())
			return -1;
		int result=0;
		boolean negative=false;
		for(int i=0;i<str.length();i++) {
			char temp=str.charAt(i);
			if(i==0 && temp=='-') {
				negative=true;
				continue;
			}
			if(temp<'0' || temp>'9')
				return -1;
			result=result*10+(temp-'0');
		}
		
		return negative?-result:result;
	}
	public static void main(String[] args) {
		AtoI testObj=new AtoI();
		System.out.println(testObj.atoi(""));
		System.out.println(testObj.atoi("ab"));
		System.out.println(testObj.atoi("12sd"));
		System.out.println(testObj.atoi("123"));
		System.out.println(testObj.atoi("000"));
		System.out.println(testObj.atoi("001"));
		System.out.println(testObj.atoi("-12"));
	}

}
