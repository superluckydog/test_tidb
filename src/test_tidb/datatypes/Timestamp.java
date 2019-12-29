package test_tidb.datatypes;

import java.text.ParseException;

import test_tidb.Util;

public class Timestamp implements DataType {

    private int precision = 2;
    //TIMESTAMP(0-6) '1970-01-01 00:00:01.000000'-'2038-01-19 03:14:07.999999'   0000-00-00 00:00:00
    public Timestamp(int precision) {
        if (precision < 0 || precision >= 6)
            assert false;
        this.precision = precision;
    }
    
    private int beginYear = 1970;
    private int beginMonth = 01;
    private int beginDay = 01;
    private int interval = 25185;
    
    public String nextValue() {
        try {
            return Util.getRndDatetime(beginYear, beginMonth, beginDay, precision, interval);
        } catch (ParseException e) {
            e.printStackTrace();
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= precision; i++) {
                sb.append("9");
            }
            return "2038-01-19 03:14:07." + sb.toString();
        }
    }

    @Override
    public String getDataTypeName() {
        return "TIMESTAMP(" + precision + ")";
    }
    
    public boolean isQuoteFree() {
        return false;
    }
}