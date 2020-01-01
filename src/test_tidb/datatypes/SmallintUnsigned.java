package test_tidb.datatypes;

import test_tidb.Util;

public class SmallintUnsigned implements DataType {
    
    //SMALLINT UNSIGNED,0, 65535
    public SmallintUnsigned() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 65535;

    @Override
    public String getDataTypeName() {
        return "SMALLINT UNSIGNED";
    }

    @Override
    public String nextValue() {
        return String.valueOf(Util.getRndIntAbs(rightBound));
    }
    
    public boolean isQuoteFree() {
        return true;
    }
}