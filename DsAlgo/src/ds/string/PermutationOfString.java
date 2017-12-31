package ds.string;

public class PermutationOfString {
	
	public void permute(String str,int start,int end) {
		if(start==end) {
			System.out.println(str);
			return;
		}
		for(int i=start;i<end;i++) {
			str=swap(str,start,i);
			permute(str,start+1,end);
			str=swap(str,start,i);
		}
		return;
	}
	public boolean checkSame(String str,int start,int end) {
		char[] chararray=str.toCharArray();
		for(int i=start;i<end;i++){
			if(chararray[i]==chararray[end])
				return false;	
		}
		return true;
	}
	public void permuteWithoutDuplicates(String str,int start,int end) {
		if(start==end) {
			System.out.println(str);
			return;
		}
			for(int i=start;i<end;i++) {
				if(checkSame(str,start,i)) {
					str=swap(str,start,i);
					permute(str,start+1,end);
					str=swap(str,start,i);
				}
			}
		return;
	}
	
	private String swap(String str,int start,int i) {
		char[] chararray=str.toCharArray();
		char temp=chararray[start];
		chararray[start]=chararray[i];
		chararray[i]=temp;
		return String.valueOf(chararray);
	}

	public static void main(String[] args) {
		PermutationOfString testObj= new PermutationOfString();
		//testObj.permute("abca", 0, 4);
		System.out.println("--------------------------------------");
		testObj.permuteWithoutDuplicates("aabc",0,4);
	}
}
