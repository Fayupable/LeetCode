import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        // Convert the date strings to LocalDate objects
        LocalDate localDate1 = LocalDate.parse(date1);
        LocalDate localDate2 = LocalDate.parse(date2);

        // Calculate the number of days between the two dates
        long daysBetween = ChronoUnit.DAYS.between(localDate1, localDate2);

        // Return the absolute value of the difference
        return Math.abs((int) daysBetween);
    }
}
/*
 class Solution {
    public int daysBetweenDates(String date1, String date2) {
      return Math.abs(tDays(date1)-tDays(date2))  ;
    }
    public static int tDays(String date)
    {
        int year = Integer.parseInt(date.substring(0,4));
        int mon = Integer.parseInt(date.substring(5,7));
        int days = Integer.parseInt(date.substring(8,10));
        int [] ar = {31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i = 0; i < mon - 1; i++)
        {
            days += ar[i];
        }
        days += (year-1)*365;
        days += (year-1)/4;
        if(year % 4 == 0 && mon > 2 && year != 2100) days++;
        return days;
    }
}
 */
/*
 class Solution {
  public int daysBetweenDates(String date1, String date2) {
    int[] days = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
    String[] array1 = date1.split("-");
    String[] array2 = date2.split("-");

    int years1 = Integer.parseInt(array1[0]);
    int years2 = Integer.parseInt(array2[0]);
    int months1 = Integer.parseInt(array1[1]);
    int months2 = Integer.parseInt(array2[1]);
    int days1 = Integer.parseInt(array1[2]);
    int days2 = Integer.parseInt(array2[2]);

    if (years1 > years2 ||
        (years1 == years2 && months1 > months2) ||
        (years1 == years2 && months1 == months2 && days1 > days2)) {
      int temp = years1;
      years1 = years2;
      years2 = temp;
      temp = months1;
      months1 = months2;
      months2 = temp;
      temp = days1;
      days1 = days2;
      days2 = temp;
    }

    int dayOfYear1 = days[months1 - 1] + days1;
    int dayOfYear2 = days[months2 - 1] + days2;

    if (isLeapYear(years1) && months1 > 2) {
      dayOfYear1++;
    }

    if (isLeapYear(years2) && months2 > 2) {
      dayOfYear2++;
    }

    int remainderDays1;
    if (isLeapYear(years1)) {
      remainderDays1 = 366 - dayOfYear1;
    } else {
      remainderDays1 = 365 - dayOfYear1;
    }

    int sum = 0;

    System.out.println(years1);
    System.out.println(years2);
    if (years1 == years2) {
      return Math.abs(dayOfYear1 - dayOfYear2);
    } else {
      for (int i = years1 + 1; i < years2; i++) {
        sum = isLeapYear(i) ? sum + 366 : sum + 365;
      }
    }

    return sum + remainderDays1 + dayOfYear2;
   }

   public boolean isLeapYear(int year) {
    return year != 2100 && year % 4 == 0;
   }
}
 */
/*
 import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


class Solution {
    public int daysBetweenDates(String date1, String date2) {
 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        LocalDate startDate = LocalDate.parse(date1, formatter);
        LocalDate endDate = LocalDate.parse(date2, formatter);
        
        // Calculate the number of days between the two dates
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        
        // Return the absolute value of the number of days to ensure it's a positive integer
        return Math.abs((int) daysBetween);
    }
    
}
 */
/*
 class Solution {

    int daysPerMonth[]={31,28,31,30,31,30,31,31,30,31,30,31};

    public int daysBetweenDates(String date1, String date2) {  
        System.out.println(findDays(date1));
        System.out.println(findDays(date2));     
        return  Math.abs(findDays(date1)-findDays(date2));
    }

    private int findDays(String date){
        int year=Integer.parseInt(date.substring(0,4));
        int month=Integer.parseInt(date.substring(5,7));
        int day=Integer.parseInt(date.substring(8));
        int diff= year-1971;
        boolean isLeap= year%100!=0 ? year%4==0: year%400==0;
        if(month>2 && isLeap){
            day++;
        }
        int numLY=numLeapYears(isLeap,year);
        for(int i=0;i<month-1;i++){
            day+=daysPerMonth[i];
        }
        // System.out.println(diff*35);
        // System.out.println(numLY);
        // System.out.println(day);
        return (diff*365+numLY)+day;
    }

    private int numLeapYears(boolean isLeap, int year){
        int y=year;
        while(y>1971 && !isLeap){
            y--;
            isLeap= y%100!=0 ? y%4==0: y%400==0;
        }
        int diff=y-1971;
        return y==year? (diff/4): diff/4+1;
    }
}
 */
/*
 * class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysInDate(date1) - daysInDate(date2));
    }
    
    public int daysInDate(String date) {
        int years = Integer.valueOf(date.substring(0, 4));
        int months = Integer.valueOf(date.substring(5, 7));
        int days = Integer.valueOf(date.substring(8, 10));
        
        int[] DaysInMonths = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        for(int i = 0; i < months-1; i++) {
            days += DaysInMonths[i];
        }
        
        days += (years-1)/4 + (years-1)*365;
        if(isLeapYear(years) && months > 2) days++;
        
        return days;
        
    }
    
    private Boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
    
    
}
 */