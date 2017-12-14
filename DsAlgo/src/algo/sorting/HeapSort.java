package algo.sorting;

public class HeapSort {
	public void sort(int[] arr) {
		if(arr.length==0)
			return;
		int n=arr.length;
		//build the heap tree
		for(int i= n-2/1;i>=0;i--)
			heapify(arr,n,i);
		//once heap tree is build, 
		//remove max node everytime 
		//reduce heap size and heapify on the root node (a[0])
		for(int i=n-1;i>=0;i--) {
			//swap a[0] and a[i]
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;				
			//call heapify on the REDUCED heap
			heapify(arr,i,0);
		}
	}
	public void heapify(int[] arr,int heapSize,int index) {
		int largest=index;
		int leftChild=(2*largest)+1;
		int rightChild=(2*largest)+2;
		//get largest among left child and root
		if(leftChild<heapSize && arr[leftChild]>arr[largest])
			largest=leftChild;
		//now compare right child with the larger one
		if(rightChild<heapSize && arr[rightChild]>arr[largest])
			largest=rightChild;
		if(largest != index) {
			//swap largest and the root
			int temp = arr[index];
			arr[index] = arr[largest];
			arr[largest] = temp;
			//now heapify the node which was swapped...
			heapify(arr,heapSize,largest);
		}
	}
	public static void main(String[] args){
		HeapSort heap=new HeapSort();
		int[] arr = {-4,10,3,5,1,9,-6,-4,0};
		heap.sort(arr);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
	}
}
