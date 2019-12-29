package test_tidb.datatypes;

import test_tidb.Util;

public class Bit5 implements DataType {

    //BIT(5)   00000-11111
    public Bit5() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 1;
    private int loop = 5;

    public String nextValue() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < loop; i++) {
            sb.append(Util.getRndInt(rightBound));
        }
        return sb.toString();
    }

    @Override
    public String getDataTypeName() {
        return "BIT(5)";
    }

    @Override
    public boolean isQuoteFree() {
        return true;
    }
    
}