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

	/*public static int CoinProblemWaysWithDp(int[] coins,int sum) {
		int[][] table = new int[coins.length][sum+1];
		//if we want 0 sum with any number of coins, number of ways will be 1 (no coins)
		for(int i=0;i<coins.length;i++)
			table[1][0] = 1;
		
		//
	}*/
	
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

	public static void main(String[] args) {
		int[] a={1,2,3,4,5,7};
		int[] b={1,2,3,4,5,6,7};
		//System.out.println(Array.binarySearch(a, b));
		
		int[] coins={1,2,3};
		int sum=40;
		//System.out.println(Array.CoinProblemWays(coins, sum, 0));
		int[] arr={1,3,5,2,10,1,4,3,5,2,5,1,2,3,5,10,11,34,2,1,5,6,3,4};
		Integer[] result=Array.removeDuplicates(arr);
		for(Integer i:result) {
			System.out.println(i);
		}
	}
}
