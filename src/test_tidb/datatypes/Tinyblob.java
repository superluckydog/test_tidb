package test_tidb.datatypes;

import test_tidb.Util;

public class Tinyblob implements DataType {

    //TINYBLOB,0,255
    public Tinyblob() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 10;//255;

    public String nextValue() {
        return Util.getRndStr(rightBound);
    }

    @Override
    public String getDataTypeName() {
        return "TINYBLOB";
    }
    
    public boolean isQuoteFree() {
        return false;
    }
}