package test_tidb.datatypes;

import test_tidb.Util;

public class Blob implements DataType {

    //BLOB,0,65535
    public Blob() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 65535;

    public String nextValue() {
        return Util.getRndStr(rightBound);
    }

    @Override
    public String getDataTypeName() {
        return "BLOB";
    }

    @Override
    public boolean isQuoteFree() {
        return false;
    }
}