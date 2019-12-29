package test_tidb.datatypes;

import test_tidb.Util;

public class Boolean implements DataType {

    //BOOLEAN,0,1
    public Boolean() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 1;

    @Override
    public String getDataTypeName() {
        return "BOOLEAN";
    }

    @Override
    public String nextValue() {
        return String.valueOf(Util.getRndInt(rightBound));
    }
    
    public boolean isQuoteFree() {
        return false;
    }
}