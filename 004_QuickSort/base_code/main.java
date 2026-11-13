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
			randomize(nums);
			start = System.nanoTime();

			//  Put your method between these two comments
			quickSort(nums);
			//

			finish = System.nanoTime();
			System.out.println("Started: " + start);
			System.out.println("Finished: " + finish);
			System.out.println("Duration: " + ((finish-start)/1000000000.0));
			System.out.println("");
		}
	}
	public static void randomize(int arr[]){
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random()*101);
		}
	}
	public static void quickSort(int[] a) {
    	quickSort(a, 0, a.length - 1);
	}
	private static void quickSort(int[] a, int lo, int hi) {
    	if (lo >= hi) {
    	    return;                         // 0 or 1 elements
    	}
    	int p = partition(a, lo, hi);
    	quickSort(a, lo, p - 1);
    	quickSort(a, p + 1, hi);
	}
	private static int partition(int[] a, int lo, int hi) {
    	int pivot = a[hi];
    	int i = lo;
    	for (int j = lo; j < hi; j++) {
        	if (a[j] < pivot) {
            	// a small element joins the small part
            	swap(a, i, j);
            	i++;
        	}
    	}
    	// the pivot goes just after the small part
    	swap(a, i, hi);
    	return i;
	}
	private static void swap(int[] a, int x, int y) {
    int t = a[x]; a[x] = a[y]; a[y] = t;
	}
}
