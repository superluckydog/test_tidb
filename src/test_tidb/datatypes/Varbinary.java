package test_tidb.datatypes;

import test_tidb.Util;

public class Varbinary implements DataType {

    //VARBINARY,0,10000
    public Varbinary() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 10;//10000;

    public String nextValue() {
        return Util.getRndStr(rightBound);
    }

    @Override
    public String getDataTypeName() {
        return "VARBINARY(10)";
    }
    
    public boolean isQuoteFree() {
        return false;
    }
}