import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;


class main {
	public static void main(String args[]) {
		int [] times = {10, 100, 1000, 10000, 100000, 1000000, 10000000};
		int [] nums;
		Stopwatch s = new Stopwatch();

		System.out.println("-------------------Test-------------------");
		System.out.println("");
		for(int i : times){
			System.out.println("Interval: " + i);
			s.start();	
			nums = new int[i];
			randomize(nums);
			//  Put your method between these two comments
			
			//
			s.stop();
			System.out.println("Duration: " + Stopwatch.readable(s.read()));
			System.out.println("");
		}
	}
	public static void randomize(int arr[]){
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random()*101);
		}
	}
	public static boolean search(int arr[]){
		int check = (int)(Math.random()*200001);
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == check){
				return true;
			}
		}
		return false;
	}
	public static void bubble(int arr[]){
		int i, j;
		for(i = 0; i < n-1; i++){
			for(j = 0; j < n-1; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	public static void insertion(int arr[]){
		int i, key, j;
		for(i = 1; i < arr.length; i++){
			key = arr[i];
			j = i - 1;
			while(j >= 0 && arr[j] > key){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	public static void selection(int arr[]){
		int i, j, min_i;
		for(i = 0; i < arr.length-1; i++){
			min_i = i;
			for(j = i+1; j < arr.length; j++){
				if(arr[j] < arr[min_i]){
					min_i = j;
				}
			}
			int temp = arr[min_i];
			arr[min_i] = arr[i];
			arr[i] = temp;
		}
	}
}

