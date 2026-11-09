package pkg;
import java.util.Scanner;
import java.util.Random;


public class DayBirth {
    int[] DayBirths;
    // File file = new File("births.csv");
	public DayBirth() {
		Scanner sc = new Scanner(newFile("births.csv"));
        int i = 0;
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            DayBirths[i] = line;
            i++;
        }
	}
    public int[] getArr(){
        return DayBirths;
    }

}
