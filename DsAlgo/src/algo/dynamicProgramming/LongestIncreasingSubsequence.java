package algo.dynamicProgramming;

public class LongestIncreasingSubsequence {
	
	public int LIS(int[] arr) {
		if(arr.length==0)
			return 0;
		if(arr.length==1)
			return 1;
		int[] lis=new int[arr.length];
		for(int i=0;i<arr.length;i++)
			lis[i]=1;
		int maxlis=0;
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i] && lis[i]<=lis[j])
					lis[i]=1+lis[j];
			}
			if(lis[i]>maxlis)
				maxlis=lis[i];
		}
		return maxlis;
	}
	public static void main(String[] args) {
		LongestIncreasingSubsequence testObj= new LongestIncreasingSubsequence();
		int[] arr = {2,5,3,7,11,8,7,9};
		System.out.println(testObj.LIS(arr));
		int[] arr1 = {7,9,1,2,3,4,5,6};
		System.out.println(testObj.LIS(arr1));
		int[] arr2 = {9,8,7,6,5,4,3,2};
		System.out.println(testObj.LIS(arr2));
		int[] arr3 = {2,3,4,5,6,7,8,9};
		System.out.println(testObj.LIS(arr3));
		int[] arr4 = {9};
		System.out.println(testObj.LIS(arr4));
		int[] arr5 = {};
		System.out.println(testObj.LIS(arr5));
	}

}
