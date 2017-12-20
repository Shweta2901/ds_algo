package ds.arrays;

public class FindSubArrayWithGivenSum {

	int[] array;
	
	public boolean findSubArrayWithSum(int[] arr,int sum) {
		if(arr.length==0 && sum ==0)
			return true;
		if(arr.length==0 && sum>0)
			return false;
		int currentSum=arr[0];
		int start=0;
		for(int i=1;i<arr.length;i++) {
			while(currentSum>sum && start<i-1){
				currentSum=currentSum-arr[start];
				start++;
			}
			if(currentSum==sum) {
				System.out.println("sum Found between:"+start+"\tto"+(i-1));
				return true;
			}
			if(i<arr.length-1)
				currentSum+=arr[i];
		}
		System.out.println("subArray not present");
		return false;
	}
	public static void main(String[] args) {
		FindSubArrayWithGivenSum test= new FindSubArrayWithGivenSum();
		int[] arr={1, 4, 20, 3, 10, 5};
		test.findSubArrayWithSum(arr, 33);
		int[] arr1={1, 4};
		test.findSubArrayWithSum(arr1, 0);
		int[] arr2={1, 4, 0, 0, 3, 10, 5};
		test.findSubArrayWithSum(arr2, 7);
	}
}
