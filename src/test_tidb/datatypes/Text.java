package test_tidb.datatypes;

import test_tidb.Util;

public class Text implements DataType {

    //TEXT,0,65535
    public Text() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 10;//65535;

    public String nextValue() {
        return Util.getRndStr(rightBound);
    }

    @Override
    public String getDataTypeName() {
        return "TEXT";
    }
    
    public boolean isQuoteFree() {
        return false;
    }
}