

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Miscellineous {
	static int preIndex=0;
	public String sequence(int current,int n,String s) {
		if(current==n) {
			return s;
		}
		if(current>n) {
			return "not possible";
		}
		String seq5=sequence(current+5,n,s+"+5");
		String seq3=sequence(current*3,n,s+"*3");
		
		if(seq5.equals("not possible") && seq3.equals("not possible")) {
			return "not possible";
		}
		if(seq5.equals("not possible")) {
			return seq3;
		}
		return seq5;
	}
	
	public static int searchInArray(int[] in,int x,int size) {
		for(int i=0;i<size;i++) {
			if(in[i]==x)
				return i;
		}
		return -1;
	}
	
	public static void printPostOrderTreeTraversal(int[] in,int[] pre,int inStart,int inEnd,int size) {
		if(preIndex==size)
			return;
		//search root element(first element in preOrder array) in inorder array
		int elementIndex= searchInArray(in,pre[preIndex++],size);
		//process the left subtree of the root
		if(elementIndex!=inStart) 
			printPostOrderTreeTraversal(in,pre,inStart,elementIndex-1,size);
		
		//process right sub tree of the root
		if(elementIndex!=inEnd)
			printPostOrderTreeTraversal(in,pre,elementIndex+1,inEnd,size);
		//print root element
				System.out.println(in[elementIndex]);
		//System.out.println(in[elementIndex]);	
	}
	
	public static void main(String args[]){
		Miscellineous obj = new Miscellineous();
		
		System.out.println(obj.sequence(1,15,"1"));
		int in[] = {4, 2, 5, 1, 6,3,7};
		   int pre[] =  {1, 2, 4, 5, 3, 6,7};
		   int n = in.length;
		   
		   printPostOrderTreeTraversal(in,pre,0,n,n);
		
		
	}

}