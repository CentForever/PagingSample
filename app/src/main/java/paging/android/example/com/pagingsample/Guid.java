package paging.android.example.com.pagingsample;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by xdjaxa on 2017/2/10.
 */

public class Guid {
    private static Random random = new Random();
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss");
    public static synchronized String generateId() {
        String timeString = simpleDateFormat.format(Calendar.getInstance().getTime());
        return timeString + getRandomNumber(6);
    }

    public static synchronized String generateTime() {
        String timeString = simpleDateFormat2.format(Calendar.getInstance().getTime());
        return timeString;
    }

    public static synchronized String generateId(int length) {
        String timeString = simpleDateFormat.format(Calendar.getInstance().getTime());
        return timeString + getRandomNumber(length - 17);
    }

    public static String getRandomNumber(int length) {
        String string = String.valueOf(Math.abs(random.nextLong()));
        while (string.length() < length) {
            string = string + String.valueOf(Math.abs(random.nextLong()));
        }
        return string.substring(0, length);
    }
}
