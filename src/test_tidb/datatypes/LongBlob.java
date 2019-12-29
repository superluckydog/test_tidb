package test_tidb.datatypes;

import test_tidb.Util;

public class LongBlob implements DataType {

    //LONGBLOB,0,4294967295
    public LongBlob() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 10;//429496;//7295;
    private int extremLong = 1000;

    public String nextValue() {
        return Util.getRndStr(rightBound);
    }
    
    public String nextExtremValue() {
        return Util.getRndStr(rightBound, extremLong);
    }

    @Override
    public String getDataTypeName() {
        return "LONGBLOB";
    }
    
    public boolean isQuoteFree() {
        return false;
    }
}