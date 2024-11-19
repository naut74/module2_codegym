package nextDayCalculator.src;

public class NextDayCalculator {

    public static String calculateNextDay(int day, int month, int year) {

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        day++;
        if (day > daysInMonth[month - 1]) {
            day = 1;
            month++;

            if (month > 12) {
                month = 1;
                year++;
            }
        }
        return day + "/" + month + "/" + year;
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }
}
