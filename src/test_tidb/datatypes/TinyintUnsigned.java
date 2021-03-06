package test_tidb.datatypes;

import test_tidb.Util;

public class TinyintUnsigned implements DataType {
    
    //TINYINT UNSIGNED,0, 255
    public TinyintUnsigned() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 255;

    @Override
    public String getDataTypeName() {
        return "TINYINT UNSIGNED";
    }

    @Override
    public String nextValue() {
        return String.valueOf(Util.getRndIntAbs(rightBound));
    }
    
    public boolean isQuoteFree() {
        return true;
    }
}