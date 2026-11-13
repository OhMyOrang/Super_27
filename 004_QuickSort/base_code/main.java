import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;


class main {
	static final long createdNano = System.nanoTime();

	public static void main(String args[]) {
		long start = System.nanoTime();
		long finish = System.nanoTime();
		System.out.println("Created: " + createdNano);
		
		int [] times = {10, 100, 1000, 10000, 100000, 1000000, 10000000};
		int [] nums = new int[100];


		System.out.println("-------------------Test-------------------");
		System.out.println("");
		for(int i : times){
			System.out.println("Interval: " + i);
			
			nums = new int[i];
			// randomize(nums);
			start = System.nanoTime();

			//  Put your method between these two comments

			//

			finish = System.nanoTime();
			System.out.println("Started: " + start);
			System.out.println("Finished: " + finish);
			System.out.println("Duration: " + (finish-start));
			System.out.println("");
		}
	}
	public static void quickSort(int arr[], int low, int high){
		if(low < high){
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi -1 );
			quickSort(arr, pi + 1, high);
		}
	}
	public static int partition(int arr[], int low, int high){
		int pivot = arr[high];
		int i = low - 1;
		for(int j = low; j <= high - 1; j++){
			if(arr[j] < pivot){
				i++
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}
}
