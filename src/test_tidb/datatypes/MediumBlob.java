package test_tidb.datatypes;

import test_tidb.Util;

public class MediumBlob implements DataType {

    //MEDIUMBLOB,0,16777215
    public MediumBlob() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 10;//16777;//215;
    private int extremLong = 100;

    public String nextValue() {
        return Util.getRndStr(rightBound);
    }
    
    public String nextExtremValue() {
        return Util.getRndStr(rightBound, extremLong);
    }

    @Override
    public String getDataTypeName() {
        return "MEDIUMBLOB";
    }
    
    public boolean isQuoteFree() {
        return false;
    }
}