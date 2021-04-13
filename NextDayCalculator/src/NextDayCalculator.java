public class NextDayCalculator {
    public static String caculateNextDay(int day, int month, int year) {
        boolean isLeapYear = checkLeapYear(year);
        int dayLimit = getDayLimit(month, isLeapYear);
        int newDay = caculateNewDay(day, dayLimit);
        int newMonth = newMonth(newDay, month);
        int newYear = newYear(year, newMonth,month);
        return newDay +","+newMonth+","+newYear;
    }

    private static int newYear(int year, int newMonth, int month) {
        if (newMonth == 1 && month == 12) {
            return year+1;
        }
        else return year;
    }

    private static int newMonth(int newDay, int month) {
        if (newDay == 1 && month < 12) {
            return month+1;
        }
        else return 1;
    }

    private static int caculateNewDay(int day, int dayLimit) {
        if (day+1 < dayLimit) {
            return day+1;
        }
        else return 1;

    }

    private static int getDayLimit(int month, boolean isLeapYear) {
        int dayLimit = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dayLimit = 31;
                break;
            case 2:
                if (isLeapYear) {
                    dayLimit = 29;
                    break;
                }
                else dayLimit =  28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dayLimit = 30;
                break;
        }
        return dayLimit;
    }

    private static boolean checkLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        else return false;
    }

}
