package test_tidb.datatypes;

import test_tidb.Util;

public class Varchar implements DataType {

    //VARCHAR,0,65535
    public Varchar() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 10;

    public String nextValue() {
        return Util.getRndStr(rightBound);
    }

    @Override
    public String getDataTypeName() {
        return "VARCHAR(100)";
    }
    
    public boolean isQuoteFree() {
        return false;
    }
}