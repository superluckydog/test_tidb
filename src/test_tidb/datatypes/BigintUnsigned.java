package test_tidb.datatypes;

import test_tidb.Util;

public class BigintUnsigned implements DataType {
    
    //BIGINT UNSIGNED,0,18446744073709551615
    public BigintUnsigned() {
    }
    
    public String nextValue() {
        return Util.getRndLongUnsignedAbs();
    }

    @Override
    public String getDataTypeName() {
        return "BIGINT UNSIGNED";
    }

    @Override
    public boolean isQuoteFree() {
        return true;
    }
}