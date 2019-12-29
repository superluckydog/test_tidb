package test_tidb.datatypes;

import test_tidb.Util;

public class Mediumint implements DataType {
    
    //MEDIUMINT,-8388608, 8388607
    public Mediumint() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 8388607;

    @Override
    public String getDataTypeName() {
        return "MEDIUMINT";
    }

    @Override
    public String nextValue() {
        return String.valueOf(Util.getRndInt(rightBound));
    }
    
    public boolean isQuoteFree() {
        return true;
    }
}