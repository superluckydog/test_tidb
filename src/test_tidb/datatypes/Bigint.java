package test_tidb.datatypes;

import test_tidb.Util;

public class Bigint implements DataType {
    
    //BIGINT,-9223372036854775808, 9223372036854775807
    public Bigint() {

    }

    @Override
    public String getDataTypeName() {
        // TODO Auto-generated method stub
        return  "BIGINT";
    }

    @Override
    public String nextValue() {
        return String.valueOf(Util.getRndLong());
    }

    @Override
    public boolean isQuoteFree() {
        return true;
    }
}