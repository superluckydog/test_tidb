package test_tidb.datatypes;

import test_tidb.Util;

public class Binary implements DataType {

    //BINARY,0,10000
    public Binary() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 1;//10000;

    public String nextValue() {
        return Util.getRndStr(rightBound);
    }

    @Override
    public String getDataTypeName() {
        return "BINARY";
    }

    @Override
    public boolean isQuoteFree() {
        return false;
    }
}