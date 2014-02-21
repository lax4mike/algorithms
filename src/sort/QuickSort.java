package sort;

public class QuickSort {

	public int[] theArray; 
	
	public static void main(String[] args){
		
		int[] anArray = {5, 8, 3, 7, 4, 1, 2, 9, 6};
		
		QuickSort sort = new QuickSort(anArray);

		sort.sort(0, anArray.length-1);
		
	}
	
	public QuickSort(int[] array) {
		this.theArray = array;
	}
	
	private void sort(int left, int right) {
		
		if (right - left <= 0) {
			System.out.println(right + " - " + left + " = " + (right-left));
			System.out.print("theArray: ");
			printArray(theArray);
			return;
		}
		System.out.println("sorting: " + left +", " + right);

		int pivot = theArray[right];
		
		int pivotLocation = this.partition(left, right, pivot);
		
		this.sort(left, pivotLocation-1);
		this.sort(pivotLocation+1, right);
		
	}
	
	
	private int partition(int left, int right, int pivot) {
		
		System.out.println("pivot: " + pivot);
				
		while (left < right) {
			
			while (theArray[left] < pivot){
				left++;
			}
			while (theArray[right] > pivot){
				right--;
			}
			
//			System.out.println("swaping " + theArray[left] + " and  "+  theArray[right]);
	
			this.swap(left, right);
			
		}
		System.out.print("partition: ");
		printArray(theArray);
		
		if (left != right ) { System.out.println("something went wrong... " + left + ", " + right); }
		
		//System.out.println("new pivot: " + right);
		
		return left; // this is the new pivot
	}
	
	private void printArray(int[] anArray) {
		
		for (int i : anArray) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}
	
	private void swap(int left, int right) {
		
		if (left >= theArray.length || right >= theArray.length) {
			System.out.println("indexes must be in the array");
		}
		
		int temp = this.theArray[left];
		this.theArray[left] = this.theArray[right];
		this.theArray[right] = temp;
		
	}
	
	
}
