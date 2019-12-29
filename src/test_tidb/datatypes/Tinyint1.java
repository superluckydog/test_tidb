package test_tidb.datatypes;

import test_tidb.Util;

public class Tinyint1 implements DataType {

    //TINYINT(1),0,1
    public Tinyint1() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 1;

    @Override
    public String getDataTypeName() {
        return "TINYINT(1)";
    }

    @Override
    public String nextValue() {
        return String.valueOf(Util.getRndInt(rightBound));
    }
    
    public boolean isQuoteFree() {
        return true;
    }
}