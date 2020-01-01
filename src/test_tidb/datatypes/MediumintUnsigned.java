package test_tidb.datatypes;

import test_tidb.Util;

public class MediumintUnsigned implements DataType {
    
    //MEDIUMINT UNSIGNED,0, 16777215
    public MediumintUnsigned() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 16777215;

    @Override
    public String getDataTypeName() {
        return "MEDIUMINT UNSIGNED";
    }

    @Override
    public String nextValue() {
        // TODO Auto-generated method stub
        return String.valueOf(Util.getRndIntAbs(rightBound));
    }
    
    public boolean isQuoteFree() {
        return true;
    }
}