package test_tidb.datatypes;

import test_tidb.Util;

public class Tinyint implements DataType {
    
    //TINYINT,-128,127
    public Tinyint() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 127;

    @Override
    public String getDataTypeName() {
        return "TINYINT";
    }

    @Override
    public String nextValue() {
        return String.valueOf(Util.getRndInt(rightBound));
    }
    
    public boolean isQuoteFree() {
        return true;
    }
}