package test_tidb.datatypes;

import test_tidb.Util;

public class Varbinary10 implements DataType {

    //VARBINARY,0,10000
    public Varbinary10() {
    }
    
    //private int leftBound = 0;
    //考虑到多字节情况
    private int rightBound = 3;//10000;

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