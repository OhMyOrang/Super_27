package pkg;
import java.util.Scanner;
import java.util.Random;


public class DayBirth {
    int year;
    int month;
    int day;
    String ge;
    int births;
	public DayBirth() {
        year=0;
        month=0;
        day=0;
        g="";
        births=0;
	}
    public DayBirth(int y, int m, int d, String g, int b){
        year=y;
        month=m;
        day=d;
        ge=g;
        births=b;
    }
    public int getBirths(){
        return births;
    }

}
