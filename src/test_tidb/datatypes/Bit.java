package test_tidb.datatypes;

import test_tidb.Util;

public class Bit implements DataType {

    //BIT 0/1
    public Bit() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 1;

    @Override
    public String getDataTypeName() {
        return "BIT(1)";
    }

    @Override
    public String nextValue() {
        return String.valueOf(Util.getRndInt(rightBound));
    }

    @Override
    public boolean isQuoteFree() {
        return true;
    }
    
    
}