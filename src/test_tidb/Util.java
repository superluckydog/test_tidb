package test_tidb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Util {

    private static Random rnd = new Random();
    private static String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvyxyz01234567890中华人民共和国成立七十周年";

    public static int getUnsignedRnd(int bound) {
        return rnd.nextInt(bound);
    }
    
    public static int getRndInt(int bound) {
        if (rnd.nextBoolean()) {
            return rnd.nextInt(bound);
        } else {
            return rnd.nextInt(bound) * -1;
        }
    }
    
    public static int getRndIntAbs(int bound) {
        return Math.abs(rnd.nextInt(bound));
    }
    
    public static boolean getRndBoolen() {
        return rnd.nextBoolean();
    }
    
    public static long getRndLong() {
        return rnd.nextLong();
    }
    
    public static String getRndLongUnsigned() {
        if (rnd.nextBoolean()) {
            return String.valueOf(Math.abs(rnd.nextLong()) * 2 + 1);
        }
        else {
            return String.valueOf(Math.abs(rnd.nextLong()) * 2 + 1);
        }
    }
    
    public static int getRndInt(int leftBound, int rightBound) {
        return rnd.nextInt(rightBound - leftBound + 1) + leftBound;
    }
    
    public static String getBit(int length) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            sb.append(getUnsignedRnd(1));
        }
        return sb.toString();
    }
    
    public static String getRndStr(int bound) {
        int length = getUnsignedRnd(bound);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            int position = getUnsignedRnd(chars.length());
            sb.append(chars.charAt(position));
        }
        return sb.toString();
    }
    
    public static String getRndStr(int bound, int loop) {
        int length = getUnsignedRnd(bound);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            int position = getUnsignedRnd(chars.length());
            sb.append(chars.charAt(position));
        }
        StringBuilder longSb = new StringBuilder();
        int rndLoop = getUnsignedRnd(loop);
        for(int i = 0; i < rndLoop; i++) {
            longSb.append(sb);
        }
        return longSb.toString();
    }
    
    public static String getRndDate(int year, int month, int day, int interval) {
        GregorianCalendar begin = new GregorianCalendar(year, month, day);
        begin.add(Calendar.DATE, Util.getRndInt(interval));
        return begin.get(Calendar.YEAR) + "-" + (begin.get(Calendar.MONTH) + 1) + "-" + begin.get(Calendar.DAY_OF_MONTH);
    }
    
    public static String getRndDatetime(int beginYear, int beginMonth, int beginDay, int precision, int interval) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
        java.util.Date date = format.parse(Util.getRndDate(beginYear, beginMonth, beginDay, interval));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < precision; i++) {
            sb.append("s");
        }
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:" + sb.toString()).format(date));
    }
}