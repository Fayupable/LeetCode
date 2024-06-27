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

#include <iostream>
#include <vector>

int main() {
    std::vector<int> daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
    int day = 1;
    int month = 0;
    int year = 1900;
    int dayOfWeek = 1;
    int sundays = 0;
    while (year < 2001) {
        if (dayOfWeek == 0 && day == 1 && year > 1900) {
            sundays++;
        }
        dayOfWeek = (dayOfWeek + 1) % 7;
        day++;
        if (day > daysInMonth[month]) {
            day = 1;
            month++;
            if (month == 12) {
                month = 0;
                year++;
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                    daysInMonth[1] = 29;
                } else {
                    daysInMonth[1] = 28;
                }
            }
        }
    }
    std::cout << sundays << std::endl;
    return 0;
}