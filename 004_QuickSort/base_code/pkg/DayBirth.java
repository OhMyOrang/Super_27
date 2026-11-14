package pkg;
import java.util.Scanner;
import java.util.Random;


public class DayBirth {
    int year;
    int month;
    Integer day;
    String ge;
    int births;
	public DayBirth() {
        year=0;
        month=0;
        day=0;
        ge="";
        births=0;
	}
    public DayBirth(int y, int m, Integer d, String g, int b){
        year=y;
        month=m;
        day=d;
        ge=g;
        births=b;
    }
    public int getBirths(){
        return births;
    }
    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public Integer getDay(){
        return day;
    }
    public String getGe(){
        return ge;
    }

}
