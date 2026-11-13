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
			mergeSort(nums);
			//

			finish = System.nanoTime();
			System.out.println("Started: " + start);
			System.out.println("Finished: " + finish);
			System.out.println("Duration (seconds): " + ((finish-start)/1000000000.0));
			System.out.println("");
		}
	}
	public static void randomize(int arr[]){
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random()*101);
		}
	}
	public static void mergeSort(int[] a) {
	    if (a.length < 2) {
	        return;             // already sorted
	    }
    	int mid = a.length / 2;
    	// a[0] to a[mid - 1]
    	int[] left = Arrays.copyOfRange(a, 0, mid);
    	int[] right = Arrays.copyOfRange(a, mid, a.length);
    	mergeSort(left);
    	mergeSort(right);
    	merge(left, right, a);  // write the result back into a
	}
	private static void merge(int[] left, int[] right, int[] out) {
    	int i = 0, j = 0, k = 0;
    	while (i < left.length && j < right.length) {
    	    if (left[i] <= right[j]) {
    	        out[k] = left[i];
    	        i++;
    	    } else {
    	        out[k] = right[j];
   	        	j++;
        	}
        k++;
    	}
    	// the rest of left
    	while (i < left.length) { out[k] = left[i]; i++; k++; }
    	// the rest of right
    	while (j < right.length) { out[k] = right[j]; j++; k++; }
    }
	// Scanner sc = new Scanner(newFile("births.csv"));
    //     DayBirth = new ArrayList<String>();
    //     while(sc.hasNextLine()){
    //         String line = sc.nextLine();
    //         DayBirths.add(line);
    //     }
    //     sc.close();
	// public int[] getArr(){
    //     int[] arr = new int[DayBirth.size()];
    //     for(int i = 0; i < DayBirth.size(); i++){
    //         arr[i] = DayBirth.get(i);
    //     }
    //     return arr;
    // }
}
