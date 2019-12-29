package test_tidb.datatypes;

import test_tidb.Util;

public class Smallint implements DataType {
    
    //SMALLINT,-32768, 32767
    public Smallint() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 32767;

    @Override
    public String getDataTypeName() {
        return "SMALLINT";
    }

    @Override
    public String nextValue() {
        return String.valueOf(Util.getRndInt(rightBound));
    }
    
    public boolean isQuoteFree() {
        return true;
    }
}