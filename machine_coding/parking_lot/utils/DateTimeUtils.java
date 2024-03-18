package machine_coding.parking_lot.utils;

import java.util.Date;

public class DateTimeUtils {

    public static int calcHours(Date start, Date end){
        long diff = end.getTime() - start.getTime();
        long diffInSecs = diff/1000;
        return (int) Math.ceil((double) diffInSecs / 3600);
    }
}

