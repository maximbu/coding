package ProjectAuler;

import java.util.Calendar;

/**
 * Created by max on 1/27/2017.
 */
public class p19 {
    /*
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
     */
    private static Calendar cal = Calendar.getInstance();

    public static int questionNaive() {
        int sundays = 1;

        for (int year = 1901; year <= 2000; year++) {
            for (int month = 1; month <= 12; month++) {
                if (createDateInstance(year, month, 1).get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    sundays++;
                }
            }
        }

        return sundays;
    }

    public static Calendar createDateInstance(int month, int year, int date) {
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DATE, date);

        return cal;

    }


    public static void main(String[] st) {
        p19 q = new p19();

        System.out.println(questionNaive());
    }
}
