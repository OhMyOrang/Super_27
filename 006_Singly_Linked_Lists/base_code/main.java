import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;

class main {
	public static void main(String args[]) {
		MySinglyLinkedList list = new MySinglyLinkedList();
		
		for(int i = 0; i < 20; i++){
			list.insert(0, (int)(Math.random()*100));
		}

		for(int i = 0; i < 20; i++){
			list.insert((int)(Math.random()*20), -1);
		}
		list.printList();

		for(int i = 0; i < 20; i++){
			int temp = list.get(i);
			list.insert(i, list.get(39-i));
			list.remove(39-i+1);
			list.insert(39-i, temp);
		}
		list.printList();
	}
}
