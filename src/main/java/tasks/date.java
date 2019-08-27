/**
 * date.java
 * date class for use in classes which inherit task
 * format:
 *  2/12/2019 1800
 *  DD/MM/YYYY TIME
 */
package tasks;

import common.dukeException;

public class date {
    private int day;
    private int month;
    private int year;
    private int time;

    private String daySuffix;
    private String monthName;

    public date(String date) throws dukeException {
        String inputParsed[] = date.split(" ", 2);
        String dateParsed[] = inputParsed[0].split("/", 3);

        if (inputParsed.length != 2 || dateParsed.length != 3) {
            throw new dukeException("Wrong date format");
        }

        if (!inputParsed[1].matches("-?(0|[1-9]\\d*)") || !dateParsed[0].matches("-?(0|[1-9]\\d*)") ||
            !dateParsed[1].matches("-?(0|[1-9]\\d*)") || !dateParsed[2].matches("-?(0|[1-9]\\d*)")) {
            throw new dukeException("Please only input numbers for dates.");
        }

        day = Integer.parseInt(dateParsed[0]);
        month = Integer.parseInt(dateParsed[1]);
        year = Integer.parseInt(dateParsed[2]);
        time = Integer.parseInt(inputParsed[1]);

        switch(day) {
            case 1:
                daySuffix = "st";
                break;
            case 2:
                daySuffix = "nd";
                break;
            case 3:
                daySuffix = "rd";
                break;
            default:
                daySuffix = "th";
                break;
        }

        switch(month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }
    }

    public String getDate() {
        return (day + "/" + month + "/" + year);
    }

    public String getDateFormat() {
        return (day + "/" + month + "/" + year + " " + time);
    }

    public String getMonthDayFormat() {
        return (monthName + " " + day + daySuffix);
    }

    public String getMonthDayTimeFormat() {
        return (monthName + " " + day + daySuffix + " " + time);
    }
}
