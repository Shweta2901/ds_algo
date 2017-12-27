package algo.dynamicProgramming;
/*
 * Given an array of n positive integers. 
 * Write a program to find the sum of maximum sum subsequence 
 * of the given array such that the integers in the subsequence 
 * are sorted in increasing order. 
 * For example, if input is {1, 101, 2, 3, 100, 4, 5}, 
 * then output should be 106 (1 + 2 + 3 + 100), 
 * if the input array is {3, 4, 5, 10}, 
 * then output should be 22 (3 + 4 + 5 + 10) and 
 * if the input array is {10, 5, 4, 3}, 
 * then output should be 10
 * */
public class MaximumSumIncreasingSequence {
	public int MIS(int[] arr) {
		if(arr.length==0)
			return 0;
		if(arr.length==1)
			return arr[0];
		int[] mis=new int[arr.length];
		for(int i=0;i<arr.length;i++)
			mis[i]=arr[i];
		int maxsum=arr[0];
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i] && mis[i]<=(mis[j]+arr[i])) 
					mis[i]=mis[j]+arr[i];
			}
			if(mis[i]>maxsum)
				maxsum=mis[i];
		}
		return maxsum;
	}
	public static void main(String[] args) {
		MaximumSumIncreasingSequence testObj= new MaximumSumIncreasingSequence();
		int[] arr = {1, 101, 2, 3, 100, 4, 5};
		System.out.println(testObj.MIS(arr));
		int[] arr1 = {7,9,1,2,3,4,5,6};
		System.out.println(testObj.MIS(arr1));
		int[] arr2 = {9,8,7,6,5,4,3,2};
		System.out.println(testObj.MIS(arr2));
		int[] arr3 = {2,3,4,5,6,7,8,9};
		System.out.println(testObj.MIS(arr3));
		int[] arr4 = {9};
		System.out.println(testObj.MIS(arr4));
		int[] arr5 = {};
		System.out.println(testObj.MIS(arr5));
		int[] arr6 = {9,80,7,6,5,4,3,2};
		System.out.println(testObj.MIS(arr6));
	}

}
