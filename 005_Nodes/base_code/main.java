import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;

class main {
	public static void main(String args[]) {
		/*
			Create an ArrayList of 100 Nodes
			Store random integers in each of them
			Print out all of the values
		*/
		ArrayList<Node> arr = new ArrayList<Node>();
		for(int i = 0; i < 100; i++){
			arr.add(new Node((int)(Math.random()*100)));
		}
		for(int i = 0; i < arr.size();i++){
			System.out.print(arr.get(i).getData() + " ");
		}
		

	}
}
