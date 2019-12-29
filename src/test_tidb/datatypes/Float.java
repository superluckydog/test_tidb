package test_tidb.datatypes;

import test_tidb.Util;

public class Float implements DataType {

    //FLOAT  -2^128 ~ +2^128
    public Float() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 128;

    @Override
    public String getDataTypeName() {
        return "FLOAT";
    }

    @Override
    public String nextValue() {
        int loop = Util.getRndInt(rightBound);
        long value = 2;
        for(int i = 1; i <= loop; i++) {
            value = value<<1;
        }
        if (Util.getRndBoolen()) {
            return String.valueOf(value);
        } else {
            return String.valueOf(value * -1);
        }
    }
    
    public boolean isQuoteFree() {
        return false;
    }
}