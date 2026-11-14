import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;
import java.io.File;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


class main {
	static final long createdNano = System.nanoTime();

	public static void main(String args[]) throws IOException {
		long start = System.nanoTime();
		long finish = System.nanoTime();
		System.out.println("Created: " + createdNano);
		
		int [] times = {10, 100, 1000, 10000, 100000, 1000000, 10000000};
		int [] nums = new int[100];


		System.out.println("-------------------Test-------------------");
		System.out.println("");
		// for(int i : times){
		// 	System.out.println("Interval: " + i);
			
		// 	nums = new int[i];
		// 	randomize(nums);
		// 	start = System.nanoTime();

		// 	//  Put your method between these two comments
		// 	quickSort(nums);
		// 	//

		// 	finish = System.nanoTime();
		// 	System.out.println("Started: " + start);
		// 	System.out.println("Finished: " + finish);
		// 	System.out.println("Duration: " + ((finish-start)/1000000000.0));
		// 	System.out.println("");
		// }
		ArrayList<DayBirth> arr = new ArrayList<>();
		File file = new File("births.csv");
		try(Scanner sc= new Scanner(file)){
			if(sc.hasNextLine()){
				sc.nextLine();
			}
			while (sc.hasNextLine()){
				String[] fields = sc.nextLine().split(",");
				arr.add(new DayBirth(
					Integer.parseInt(fields[0]),
					Integer.parseInt(fields[1]),
					"null".equals(fields[2]) ? null : Integer.parseInt(fields[2]),
					fields[3],
					Integer.parseInt(fields[4])
				));
			}
		}
		quickSort(arr);
		ArrayList<DayBirth> arr2 = new ArrayList<DayBirth>();
		for(int j = 0; j < arr.size(); j++){
			if(arr.get(j).getGe().equals("M")){
				arr2.add(arr.get(j));
				arr.remove(j);
				j--;
			}
		}
		exportCsv(arr, "female_births.csv");
		exportCsv(arr2, "male_births.csv");
	}
	private static void exportCsv(ArrayList<DayBirth> records, String filename) throws IOException {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename))) {
			writer.write("year,month,day,gender,births");
			writer.newLine();
			for (DayBirth record : records) {
				writer.write(record.getYear() + "," + record.getMonth() + ","
					+ (record.getDay() == null ? "null" : record.getDay()) + ","
					+ record.getGe() + "," + record.getBirths());
				writer.newLine();
			}
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
		while (lo < hi) {
			int pivot = a[lo + (hi - lo) / 2];
			int lt = lo;
			int i = lo;
			int gt = hi;

			while (i <= gt) {
				if (a[i] < pivot) {
					swap(a, lt++, i++);
				} else if (a[i] > pivot) {
					swap(a, i, gt--);
				} else {
					i++;
				}
			}

			if (lt - lo < hi - gt) {
				quickSort(a, lo, lt - 1);
				lo = gt + 1;
			} else {
				quickSort(a, gt + 1, hi);
				hi = lt - 1;
			}
		}
	}
	public static void quickSort(ArrayList<DayBirth> a) {
		quickSort(a, 0, a.size() - 1);
	}
	private static void quickSort(ArrayList<DayBirth> a, int lo, int hi) {
		while (lo < hi) {
			int pivot = a.get(lo + (hi - lo) / 2).getBirths();
			int lt = lo;
			int i = lo;
			int gt = hi;

			while (i <= gt) {
				int births = a.get(i).getBirths();
				if (births < pivot) {
					swap(a, lt++, i++);
				} else if (births > pivot) {
					swap(a, i, gt--);
				} else {
					i++;
				}
			}

			if (lt - lo < hi - gt) {
				quickSort(a, lo, lt - 1);
				lo = gt + 1;
			} else {
				quickSort(a, gt + 1, hi);
				hi = lt - 1;
			}
		}
	}
	private static void swap(int[] a, int x, int y) {
    int t = a[x]; a[x] = a[y]; a[y] = t;
	}
	private static void swap(ArrayList<DayBirth> a, int x, int y) {
		DayBirth t = a.get(x);
		a.set(x, a.get(y));
		a.set(y, t);
	}
}
