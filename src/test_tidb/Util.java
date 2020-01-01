package test_tidb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    
    public static String getRndLongUnsignedAbs() {
        BigDecimal bigDecimal1 = new BigDecimal(Math.abs(rnd.nextLong()));
        BigDecimal bigDecimal2 = new BigDecimal(Math.abs(rnd.nextLong()));
        return String.valueOf(bigDecimal1.add(bigDecimal2));
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
    
    public static String getStr(int length) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            int position = getUnsignedRnd(chars.length());
            sb.append(chars.charAt(position));
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
    
    /*
    int startYear=2016;
    int endYear=2018;
    int year = (int)(Math.random()*(endYear-startYear+1))+startYear;    //随机年
    int month= (int)(Math.random()*12)+1;                               //随机月
    Calendar c = Calendar.getInstance();                //创建Calendar对象
    c.set(year, month, 0);                              //设定日期
    int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);      //获取对应年月有几天
    int day=(int)(Math.random()*dayOfMonth+1)   ;       //产生随机日
    Date hireday=Date.valueOf(year+"-"+month+"-"+day);  //通过valueOf方法生成Date对象
    return hireday;
*/
    public static Date getRndDate(int beginYear, int endYear) {
        Calendar calendar = Calendar.getInstance(); 
        Random rnd = new Random();
        int year = rnd.nextInt(endYear - beginYear + 1) + beginYear;
        int month = rnd.nextInt(11);
        calendar.set(year, month, 0); 
        int day = rnd.nextInt(calendar.get(Calendar.DAY_OF_MONTH));
        calendar.set(year, month, day);
        return calendar.getTime();
    }
    
    public static String getRndDateString(int beginYear, int endYear) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = getRndDate(beginYear, endYear);
        return format.format(date);
    }
    
    
    public static String getRndDatetime(int beginYear, int endYear, int precision) throws ParseException { 
        Date date = getRndDate(beginYear, endYear);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < precision; i++) {
            sb.append("s");
        }
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:" + sb.toString()).format(date));
    }
    
    public static String getStrFromInsByCode(InputStream is, String code){
        StringBuilder builder=new StringBuilder();
        BufferedReader reader=null;
        try {
            reader = new BufferedReader(new InputStreamReader(is,code));
            String line;
            while((line=reader.readLine())!=null){
                builder.append(line+"\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
                }finally{
                    try {
                        reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            }
                    }
        return builder.toString();
        }
}