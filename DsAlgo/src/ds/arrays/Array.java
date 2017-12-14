package ds.arrays;

import java.util.HashSet;

public class Array {
	
	int[] array;
	/*
	 * Given two sorted arrays. 
	 * There is only 1 difference between the arrays. 
	 * First array has one element extra added in between. 
	 * Find the index of the extra element.
	 * */
	public static int binarySearch(int[] a,int[] b) {
		int start=0;
		int end=a.length-1;
		int middleElement=0;
		if(a.length==0 && b.length==0)
			return -1;
		
		while(start<=end) {
			middleElement=start + (end-start)/2;
			if(a[middleElement]==b[middleElement]) {
				//elelment is right side
				start=middleElement+1;
			} else {
				end=middleElement-1;
			}
		}
		if(a[middleElement]==b[middleElement]) {
			if(middleElement==0) {
				return b[middleElement-1];
			} else if(middleElement==a.length-1)
				return b[middleElement+1];
		}
		return b[middleElement];
	}
	
	/**
	 * Given a value N, if we want to make change for N cents,
	 * and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
	 * how many ways can we make the change? The order of coins doesn’t matter.
	 * For example, for N = 4 and S = {1,2,3}, 
	 * there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. 
	 * For N = 10 and S = {2, 5, 3, 6}, 
	 * there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. 
	 * So the output should be 5.
	 * */
	public static int CoinProblemWays(int[] coins,int sum,int excludeCoinsIndex) {
		// If n is 0 then there is 1 solution (do not include any coin)
		if(sum==0)
			return 1;
		// If n is less than 0 then no solution exists
		if(sum<0)
			return 0;
		if(excludeCoinsIndex>=coins.length && sum>0)
			return 0;
		return CoinProblemWays(coins,sum-coins[excludeCoinsIndex],excludeCoinsIndex)+CoinProblemWays(coins,sum,excludeCoinsIndex+1);
	}
	
	public static Integer[] removeDuplicates(int[] arr) {
		if(arr.length==0)
			return new Integer[0];
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i: arr) {
			set.add(new Integer(i));
		}
		Integer[] result= set.toArray(new Integer[set.size()]);
		return result;
	}

	/* program to find the sum of contiguous 
	 * subarray within a one-dimensional array 
	 * of numbers which has the largest sum.
	 * */
	static int maxSubArraySum(int a[], int size)
    {
    int max_so_far = a[0];
    int curr_max = a[0];
 
    for (int i = 1; i < size; i++)
    {
        curr_max = Math.max(a[i], curr_max+a[i]);
        max_so_far = Math.max(max_so_far, curr_max);
    }
    return max_so_far;
    }
	
	/*
	 * An element in a sorted array can be found in O(log n) time via binary search. 
	 * But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. 
	 * So for instance, 1 2 3 4 5 might become 3 4 5 1 2. 
	 * Devise a way to find an element in the rotated array in O(log n) time.
	 * */
	public static int findElementInSortedRotatedArray(int[] arr,int element) {
		//
		if(arr.length==0)
			return -1;
		return binaryToSearchInRotatedSortedArray(arr,0,arr.length-1,element);
			
	}
	private static int binaryToSearchInRotatedSortedArray(int[] arr,int start,int end,int element) {
		if(end<start)
			return -1;
		int middle = start + (end-start)/2;
		//check if middle element is equal to element we are searching
		if(arr[middle]==element)
			return middle;
		//else check if left part of middle is sorted
		if(arr[start]<=arr[middle-1]) {
			//element is between start and middle-1
			if(element>=arr[start] && element<=arr[middle-1]) {
				return binaryToSearchInRotatedSortedArray(arr,start,middle-1,element);
			} else { // else search in right part
				return binaryToSearchInRotatedSortedArray(arr,middle+1,end,element);
			}
		} else { //if left part is not sorted right has to be sorted
			if(element<=arr[end] && element>=arr[middle]) {
				return binaryToSearchInRotatedSortedArray(arr,middle+1,end,element);
			} else { // else search in left part
				return binaryToSearchInRotatedSortedArray(arr,start,middle-1,element);
			}
		}
	}
	/* A sorted array is rotated at some unknown point, find the minimum element in it.
	 * 
	 * {1,2,3,4,5,6}  //arr[low]<arr[high]
	 * {6,5,4,3,2,1}
	 * {3,4,5,6,1,2}
	 * */
	public static int getMiddleInSortedRotated(int[] arr,int start,int end) {
		if(arr.length==0)
			return -1;
		if(start>end)
			return -1;
		if(arr[start]<arr[end])
			return start;
		if(start==end)
			return arr[start];
	
		int middle=start + (end-start)/2;
		if(middle<end && arr[middle]>arr[middle+1])
			return middle+1;
		
		if(middle<start && arr[middle]<arr[middle-1])
			return middle;
	
		if(arr[middle]>arr[start]){
			//search in right half
			return getMiddleInSortedRotated(arr,middle+1,end);
		} else {
			//search in right part
			return getMiddleInSortedRotated(arr,start,middle-1);
		}
		
	}
	public static void main(String[] args) {
		int[] a={1,2,3,4,5,7};
		int[] b={1,2,3,4,5,6,7};
		//System.out.println(Array.binarySearch(a, b));
		
		int[] coins={1,2,3};
		int sum=40;
		//System.out.println(Array.CoinProblemWays(coins, sum, 0));
		int[] arr={1,3,5,2,10,1,4,3,5,2,5,1,2,3,5,10,11,34,2,1,5,6,3,4};
		/*Integer[] result=Array.removeDuplicates(arr);
		for(Integer i:result) {
			System.out.println(i);
		}
		int[] maxArray={-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(Array.maxSubArraySum(maxArray, maxArray.length));*/
		int[] sortedRotatedArray={10,9,8,7,6,5,4};
		System.out.println(Array.getMiddleInSortedRotated(sortedRotatedArray, 0, sortedRotatedArray.length-1));
	}
}
