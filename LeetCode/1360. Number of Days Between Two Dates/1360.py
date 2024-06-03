class Solution(object):
    def daysBetweenDates(self, date1, date2):
        """
        :type date1: str
        :type date2: str
        :rtype: int
        """
        
        # Helper function to check if a year is a leap year
        def is_leap(year):
            return year % 4 == 0 and (year % 100 != 0 or year % 400 == 0)
        
        # Helper function to get the number of days in a given month of a given year
        def days_in_month(year, month):
            if month == 2:
                # February: 29 days if leap year, otherwise 28 days
                return 29 if is_leap(year) else 28
            # Months with 31 days
            return 31 if month in [1, 3, 5, 7, 8, 10, 12] else 30  # Months with 30 days
        
        # Helper function to calculate the total number of days from 1971-01-01 to the given date
        def days_from_1971(year, month, day):
            days = 0
            # Add the number of days for each year from 1971 to the year before the given year
            for y in range(1971, year):
                days += 366 if is_leap(y) else 365
            # Add the number of days for each month in the given year up to the month before the given month
            for m in range(1, month):
                days += days_in_month(year, m)
            # Add the number of days in the current month up to the given day
            return days + day - 1
        
        # Parse the input dates into year, month, and day components
        year1, month1, day1 = map(int, date1.split('-'))
        year2, month2, day2 = map(int, date2.split('-'))
        
        # Calculate the absolute difference between the total number of days for the two dates
        return abs(days_from_1971(year1, month1, day1) - days_from_1971(year2, month2, day2))
        

#other people's solution
'''
from datetime import datetime

class Solution(object):
    def daysBetweenDates(self, date1, date2):
        """
        :type date1: str
        :type date2: str
        :rtype: int
        """
        # Parse the input date strings into date objects
        date_format = "%Y-%m-%d"
        d1 = datetime.strptime(date1, date_format).date()
        d2 = datetime.strptime(date2, date_format).date()
        
        # Compute the difference between the two dates
        delta = abs((d2 - d1).days)
        
        return delta

'''
'''
class Solution(object):
    def daysBetweenDates(self, date1, date2):
        """
        :type date1: str
        :type date2: str
        :rtype: int
        """
        from datetime import datetime
        a = datetime.strptime(date1, "%Y-%m-%d").date()
        b = datetime.strptime(date2, "%Y-%m-%d").date()
        mi = min(a, b)
        ma = max(a, b)
        return (ma-mi).days
                
'''
'''
class Solution(object):
    def daysBetweenDates(self, date1, date2):
        dat1= date(int(date1[:4]), int(date1[5:7]), int(date1[8:]))
        dat2 = date(int(date2[:4]), int(date2[5:7]), int(date2[8:]))
        if dat2 > dat1: 
            return (dat2-dat1).days
        else:
            return (dat1-dat2).days
        """
        :type date1: str
        :type date2: str
        :rtype: int
        """
        
'''
'''
from datetime import datetime

class Solution(object):
    def daysBetweenDates(self, date1, date2):
        """
        :type date1: str
        :type date2: str
        :rtype: int
        """
        date_format = "%Y-%m-%d"

        date_object1 = datetime.strptime(date1, date_format)
        date_object2 = datetime.strptime(date2, date_format)
        difference = abs((date_object1 - date_object2).days)
        
        return difference
'''