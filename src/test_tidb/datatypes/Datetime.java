package test_tidb.datatypes;

import java.text.ParseException;

import test_tidb.Util;

public class Datetime implements DataType {

    private int precision = 2;
    //DATETIME(0-6) '1000-01-01 00:00:00.000000'-'9999-12-31 23:59:59.000000'
    public Datetime(int precision) {
        if (precision < 0 || precision >= 6)
            assert false;
        this.precision = precision;
    }
    
    private int beginYear = 1000;
    private int endYear = 9999;
    
    public String nextValue() {
        try {
            return Util.getRndDatetime(beginYear, endYear, precision);
        } catch (ParseException e) {
            e.printStackTrace();
            return "9999-12-31 23:59:59.000000";
        } 
    }

    @Override
    public String getDataTypeName() {
        return "DATETIME";
    }
    
    public boolean isQuoteFree() {
        return false;
    }
}