package algo.sorting;

public class QuickSort {
	
	private int partition(int[] arr,int start,int end) {
		int pivot=end;
		int p=start;
		int q=end-1;
		while(q>=p && q!=start) {
			while(p<end && arr[p]<arr[pivot]) {
				p++;
			}
			while(q>start && arr[q]>arr[pivot]){
				q--;
			}
			if(q>p) {
				//swap arr[p] and arr[q]
				int temp=arr[p];
				arr[p]=arr[q];
				arr[q]=temp;
			}
		}
		//swap p and pivot
		int temp=arr[pivot];
		arr[pivot]=arr[p];
		arr[p]=temp;
		
		return p;
	}
	
	public void quickSort(int[] arr,int start,int end) {
		if(end>start) {
			int partitionIndex=partition(arr,start,end);
			quickSort(arr,start,partitionIndex-1);
			quickSort(arr,partitionIndex+1,end);
		}
		return;
	}

	public static void main(String[] args) {
		QuickSort quicksort=new QuickSort();
		int[] arr={90,80,70,50,40,30,10};
		quicksort.quickSort(arr, 0, arr.length-1);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
	}
}
