package test_tidb.datatypes;

import test_tidb.Util;

public class Char implements DataType {

    //CHAR,0,255
    public Char() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 1;//255;

    public String nextValue() {
        return Util.getStr(rightBound);
    }

    @Override
    public String getDataTypeName() {
        return "CHAR";
    }
    
    public boolean isQuoteFree() {
        return false;
    }
}