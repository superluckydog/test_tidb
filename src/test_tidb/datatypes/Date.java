package test_tidb.datatypes;

import test_tidb.Util;

public class Date implements DataType {

    //DATE '1000-01-01'-'9999-12-31'
    public Date() {
    }
    
    private int beginYear = 1000;
    private int endYear = 9999;
    
    public String nextValue() {
        return Util.getRndDateString(beginYear, endYear);
    }

    @Override
    public String getDataTypeName() {
        return "DATE";
    }
    
    public boolean isQuoteFree() {
        return false;
    }
}