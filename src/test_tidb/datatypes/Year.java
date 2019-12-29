package test_tidb.datatypes;

import test_tidb.Util;

public class Year implements DataType {

    //YEAR, 1901,2155
    public Year() {
        super();
    }
    
    private int leftBound = 1901;
    private int rightBound = 2155;

    @Override
    public String getDataTypeName() {
        return "YEAR";
    }

    @Override
    public String nextValue() {
        return String.valueOf(Util.getRndInt(leftBound, rightBound));
    }
    
    public boolean isQuoteFree() {
        return false;
    }
}